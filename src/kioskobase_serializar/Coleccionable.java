package kioskobase_serializar;

public class Coleccionable extends Publicacion {

    private int numero;

    public Coleccionable(String titulo, int numero) {
        super(titulo);
        this.numero = numero;
    }

    public int getEscritor() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void vender() {
        System.out.println("Se ha vendido 1 unidad del libro con titulo" + getTitulo());
    }

    @Override
    public String toString() {
        return "Coleccionable:\t " + super.toString() + " (num. " + numero + ")";
    }
}
