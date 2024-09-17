/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.dt;

/**
 *
 * @author Law
 */
public class errorBundle {
    private boolean verificacion;
    private Integer numero_error_interno;
    
    public errorBundle(boolean valor, Integer numero){
        this.verificacion = valor;
        this.numero_error_interno = numero;
    }
    
    public boolean getValor(){
        return this.verificacion;
    }
    
    public Integer getNumero(){
        return this.numero_error_interno;
    }
}
