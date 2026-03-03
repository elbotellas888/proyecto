/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author martin
 */
public class clscliente {
    
    private String nombre;
    private String razonsocial;
    private String tipodecliente;
    private String nombredecliente;
    
    //consructor
    public clscliente(String nombre, String razonsocial, String tipodecliente, String nombredecliente){
        this.nombre = nombre;
        this.razonsocial = razonsocial;
        this.tipodecliente = tipodecliente;
        this.nombredecliente = nombredecliente;
                
    }
    //sobrecarga del metodo constructor
    public clscliente(){
        
    }
    //imprimir en consola los datos del articulo
    public String aTexto(){
        String cliente = this.nombre + "|" + this.razonsocial + "|" + this.tipodecliente + "|" + this.nombredecliente + "|";
        return cliente;
    }
        //guardar info
    public void guardar(){
        
        mCliente client = new mCliente();
        
        client.insertar(this.aTexto());
        System.out.println(this.aTexto());
    }
    public DefaultListModel<String> llenarlista(){
        mCliente client = new mCliente();
        ArrayList<String> datos = client.consultar();
        
       DefaultListModel modelLista = new DefaultListModel<>();
       
       for (String registro: datos){
           modelLista.addElement(registro);
       }
        
       return modelLista;
    }
    
            
}
    
