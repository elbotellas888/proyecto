/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class mArticulo {

    public void Insertar(String cadenaArticulo) {
        try {
            // Esta linea crea el archivo donde se guarda la informacion
            FileWriter archivo = new FileWriter("listado_articulos.txt", true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
            BufferedWriter buffer = new BufferedWriter(archivo);

            // Escribe en el archivo de texto
            buffer.write(cadenaArticulo);
            // Agrega un salto de linea al registro
            buffer.newLine();
            // Guarda los registros en el archivo
            buffer.close();
            // lblSaludo.setText("¡Archivo guardado con éxito!");

        } catch (IOException e) {
            // lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }

    }

    public ArrayList<String> Consultar() {
        ArrayList<String> listaRegistros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("listado_articulos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // 1. Corregimos el formato: agregamos espacios y cambiamos ';' por ':'
                String datoBonito = "Codigo: " + datos[0] + "| Descripcion: " + datos[1] + "| Precio: " + datos[2];

                listaRegistros.add(datoBonito);
            }
        } catch (IOException e) {
            System.out.print("Mensaje de error: " + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }

        return listaRegistros;
    }

    public void update(String lineActual, String lineaNueva, String archivoOriginal) {
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");

        String lineaLeida;
        Boolean actualizado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));) {

            while ((lineaLeida = br.readLine()) != null) {
                String[] datosLeidos = lineaLeida.split("\\|");
                String[] datosActuales = lineActual.split("\\|");

                // Comparamos por el primer campo (el código) para que sea más robusto
                if (datosLeidos.length > 0 && datosActuales.length > 0
                        && datosLeidos[0].trim().equals(datosActuales[0].trim())) {
                    bw.write(lineaNueva);
                    bw.newLine();
                    actualizado = true;
                } else {
                    bw.write(lineaLeida);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar" + e.getMessage());
        }

        // Eliminacion de archiv0o original
        if (actualizado) {
            if (fileOriginal.delete()) {
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Actualizado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        } else {
            fileTemporal.delete();
            System.out.println("No se encuentro el registro");
        }
    }

    public void delete(String lineActual, String archivoOriginal) {

        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");

        String lineaLeida;
        Boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));) {

            while ((lineaLeida = br.readLine()) != null) {
                String[] datosLeidos = lineaLeida.split("\\|");
                String[] datosActuales = lineActual.split("\\|");

                // Comparamos por el primer campo (el código) para que sea más robusto
                if (datosLeidos.length > 0 && datosActuales.length > 0 &&
                        datosLeidos[0].trim().equals(datosActuales[0].trim())) {
                    eliminado = true;
                } else {
                    bw.write(lineaLeida);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al borrar" + e.getMessage());
        }

        // Eliminacion de archiv0o original
        if (eliminado) {
            if (fileOriginal.delete()) {
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Eliminado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        } else {
            fileTemporal.delete();
            System.out.println("No se encuentro el registro");
        }
    }

}
