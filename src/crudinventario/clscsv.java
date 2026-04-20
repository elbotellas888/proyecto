/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jorge
 */
public class clscsv {
    
    String archivo = "inventario.csv";
    
    public void importarDatos(){    
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            br.readLine();            
            
            double valor_total = 0;
            
            while ((linea = br.readLine()) != null){

                String[] datos = linea.split(",");
                //asignacion de valores
                clsArticulo cArticulo = new clsArticulo(
                    datos[0], datos[1], Double.parseDouble(datos[2]));
                //almacena en archivo txt
                cArticulo.guardar();
               
                }
            br.close();
            System.out.println("se ha terminado con la importacin :");
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());
        }
    }
}
