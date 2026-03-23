/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class mCliente {
    public void insertar(String cadenaCliente){
        try {
            // Esta linea crea el archivo donde se guarda la informacion
            FileWriter archivo = new FileWriter("listado_clientes.txt", true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
            BufferedWriter buffer = new BufferedWriter(archivo);
            
            // Escribe en el archivo de texto
            buffer.write(cadenaCliente); 
            // Agrega un salto de linea al registro
            buffer.newLine(); 
            // Guarda los registros en el archivo
            buffer.close();
            
        } catch (IOException e) {
            //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
    public ArrayList<String> consultar(){
    ArrayList<String> listaRegistro = new ArrayList<>();
    
    try(BufferedReader br = new BufferedReader (new FileReader("listado_clientes.txt"))){
        String linea;
        while ((linea = br.readLine()) != null){
            listaRegistro.add(linea); // formato original
        }
    }catch(IOException e){
        System.out.println("mensaje de error" + e.getMessage());
        listaRegistro.add("error");  
    }
    return listaRegistro;
}
    
    public void actualizar(String cadenaActualizada){
    ArrayList<String> registros = new ArrayList<>();
    
    
    try (BufferedReader br = new BufferedReader(new FileReader("listado_clientes.txt"))){
        String linea;
        
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split("\\|");
            String[] nuevosDatos = cadenaActualizada.split("\\|");
            
            // Comparamos por ID (nombre)
            if (datos[0].equals(nuevosDatos[0])){
                registros.add(cadenaActualizada); // reemplaza
            } else {
                registros.add(linea); // deja igual
            }
        }
        
    } catch (IOException e){
        System.out.println("Error al leer: " + e.getMessage());
    }
    
    // Sobrescribir archivo
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("listado_clientes.txt"))){
        for (String registro : registros){
            bw.write(registro);
            bw.newLine();
        }
    } catch (IOException e){
        System.out.println("Error al escribir: " + e.getMessage());
    }
}
    
    public void eliminar(String id){
    ArrayList<String> registros = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader("listado_clientes.txt"))){
        String linea;
        
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split("\\|");
            
            // Si NO coincide, lo guardamos
            if (!datos[0].equals(id)){
                registros.add(linea);
            }
        }
        
    } catch (IOException e){
        System.out.println("Error al leer: " + e.getMessage());
    }
    
    // Reescribir archivo sin el eliminado
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("listado_clientes.txt"))){
        for (String registro : registros){
            bw.write(registro);
            bw.newLine();
        }
    } catch (IOException e){
        System.out.println("Error al escribir: " + e.getMessage());
    }
}
    
}

    

