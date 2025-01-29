/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.llenarmuebles;

/**
 *
 * @author ECTOR
 */
public class Mueble {
    private  int ID_Mueble;
    private String Modelo;
    private String Tipo;
    private String Material;
    private String Precio_Venta;
    private String Descripcion;
    public Mueble(){
    ID_Mueble=0;
    Tipo="";
    Material="";
    Precio_Venta="";
    Descripcion="";
    }
    public boolean VacioAlgo(Mueble mueble){
    boolean res=false;
    if((mueble.ID_Mueble==0) &&((mueble.Tipo="").equals(""))&&
      ((mueble.Material).equals(""))&&(mueble.Precio_Venta.equals(""))&&
       (mueble.Descripcion.equals(""))){
    res=true;
    }
    return res;
    }
    public int getID_Mueble() {
        return ID_Mueble;
    }

    public void setID_Mueble(int ID_Mueble) {
        this.ID_Mueble = ID_Mueble;
    }

    // Getter and Setter for Tipo
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    // Getter and Setter for Material
    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    // Getter and Setter for Precio_Venta
    public String getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(String Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    // Getter and Setter for Descripcion
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String getModelo(){
    return this.Modelo;
    }
    public void setModelo(String Modelo){
    this.Modelo=Modelo;
    }
}
