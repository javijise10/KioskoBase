package kioskobase_serializar;

import java.io.Serializable;

public class RegistroVentas implements Serializable{

    private final int MAX_VENTAS;
    private Publicacion[] ventas;
    private int numeroVentas; 
    
    public RegistroVentas() {
        
       MAX_VENTAS = 550; 
       ventas = new Publicacion[MAX_VENTAS];
       numeroVentas=0;
    } 

    public boolean anadirItemsEnVenta(Publicacion item) {
        
        if(numeroVentas<MAX_VENTAS){ 
            ventas[numeroVentas] = item;
            numeroVentas++;
            return true;
        }
        else  return false;
    }

    public void vender() {
        for(int i =0; i<numeroVentas; i++)
        {
            ventas[i].vender();
        }
    }

    @Override
    public String toString() {
        
        String texto="\n\n---------------------------------\n";
        texto       +=   "Contenido del Registro de Ventas\n";
        texto       +=   "---------------------------------\n";
        
        if(numeroVentas == 0 ){
            texto   += "\n              El registro de ventas está vacío\n\n";
        }
        else{
                for(int i=0; i<numeroVentas; i++){
                    texto  += (i+1) + " : " + ventas[i]+"\n";
                }
        }        
        return texto;
    }
}