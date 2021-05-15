package kioskobase_serializar;

import java.text.DecimalFormat;

public class Utils {

    public static String obtenerFechaRevista() {

        int mes = (int) (Math.random() * 12);
        DecimalFormat formato = new DecimalFormat("00");

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        return meses[mes] + "/20" + formato.format((int) (Math.random() * 20)); /// Ejemplo: Mayo/2005

    }

    public static String obtenerTituloColeccionable() {

        String[] nombre = {"Coches", "Dinosaurios", "Edificios", "Futbolistas", "Barcos"};
        String[] adjetivo = {"Fabulosos", "Increíbles", "Clásicos", "Locos", "Asombrosos", "de Leyenda"};

        return nombre[(int) (Math.random() * nombre.length)] + " " + adjetivo[(int) (Math.random() * adjetivo.length)];
    }

    public static String obtenerTituloRevista() {

        String[] nombre = {"PC World", "Computer Hoy", "Gadget", "Emprendedores", "National Geographic", "Semana",
            "Apple World", "Muy Interesante", "Science", "Vogue", "Harper's Bazaar", "Rolling Stones",
            "Cocina", "Viajar", "Telva", "Bild", "Diez Minutos", "Hola"};

        return nombre[(int) (Math.random() * nombre.length)];
    }
}
