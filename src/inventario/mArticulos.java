package inventario;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

        


/**
 *
 * @author martin
 */
public class mArticulos {
    public void insertar(String cadenaArticulo){
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
            
        } catch (IOException e) {
            //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
    public ArrayList <String> consultar(){
        ArrayList <String> listaRegistro = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader (new FileReader("listado_articulos.txt"))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split("\\|");
                String datoBonito = "codigo " + datos[0] + "| descripcion " + datos[1] + "| precio " + datos[2];
                listaRegistro.add(datoBonito);
            }
        }catch(IOException e){
            System.out.println("mensaje de error" + e.getMessage());
            listaRegistro.add("error");  
        }
        return listaRegistro;
    }
    
    public void update(String lineaactual, String lineanueva, String archivooriginal ){
        
        java.io.File fileoriginal = new java.io.File(archivooriginal);
        java.io.File filetemporal = new java.io.File("temporal.txt");
        
        String linealeida;
        Boolean actualizado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileoriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filetemporal));){
            
            
            
            while((linealeida = br.readLine()) !=null){
                if(linealeida.equals(lineaactual)){
                    bw.write(lineanueva);
                    actualizado = true;
                }else {
                    bw.write(linealeida);
                }
                bw.newLine();
            }
            
        }catch(Exception e){
            System.out.println("error al actualizar" + e.getMessage());
            
            
        }
        //eliminacion de archivo temporal 
        if(actualizado){
            if(fileoriginal.delete()){
                filetemporal.renameTo(fileoriginal);
                System.out.println("error: no se pudo borrar");
            }
        }else{
            filetemporal.delete();
            System.out.println("no se pudo encontrar el registro");
                
                
            }
            
        }
    
    public void delete(String lineaactual, String archivooriginal){
        
        
        java.io.File fileoriginal = new java.io.File(archivooriginal);
        java.io.File filetemporal = new java.io.File("temporal.txt");
        
        String linealeida;
        Boolean eliminado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileoriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filetemporal));){
            
            
            
            while((linealeida = br.readLine()) !=null){
                if(linealeida.equals(lineaactual)){
                    
                    eliminado = true;
                }else {
                    bw.write(linealeida);
                }
                bw.newLine();
            }
            
        }catch(Exception e){
            System.out.println("error al actualizar" + e.getMessage());
            
            
        }
        //eliminacion de archivo temporal 
        if(eliminado){
            if(fileoriginal.delete()){
                filetemporal.renameTo(fileoriginal);
                System.out.println("error: no se pudo borrar");
            }
        }else{
            filetemporal.delete();
            System.out.println("no se pudo encontrar el registro");
                
                
            }
            
        }
    }
    

