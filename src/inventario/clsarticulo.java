package inventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author martin
 */
public class clsarticulo {
    
    private String codigo;
    private String descripcion;
    private Double precio;
    
    //consructor
    public clsarticulo(String codigo, String descripcion, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
                
    }
    //sobrecarga del metodo constructor
    public clsarticulo(){
        
    }
    //imprimir en consola los datos del articulo
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio + "|";
        return articulo;
    }
        //guardar info
    public void guardar(){
        
        mArticulos article = new mArticulos();
        
        article.insertar(this.aTexto());
        System.out.println(this.aTexto());
    }
    public DefaultListModel<String> llenarlista(){
        mArticulos mArticle = new mArticulos();
        ArrayList<String> datos = mArticle.consultar();
        
       DefaultListModel modelLista = new DefaultListModel<>();
       
       for (String registro: datos){
           modelLista.addElement(registro);
       }
        
       return modelLista;
    }
}
            


