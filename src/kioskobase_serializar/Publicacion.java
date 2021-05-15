package kioskobase_serializar;

import java.io.Serializable;

public abstract class Publicacion implements Serializable{

    private String titulo;

    public Publicacion(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public abstract void vender();
}
