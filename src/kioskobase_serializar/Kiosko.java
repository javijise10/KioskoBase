package kioskobase_serializar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosko {

    private static RegistroVentas registro = new RegistroVentas();

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {

        boolean salir = false;
        do {
            System.out.println("\n*************************************");
            System.out.println("**        Kiosko Trassierra        **");
            System.out.println("*************************************\n");
            System.out.println("1. Cargar el registro de ventas (todo el registro)");
            System.out.println("2. Mostrar el registro de ventas");
            System.out.println("3. Introducir N ventas (aleatorio)");
            System.out.println("4. Guardar el registro de ventas en un fichero (todo el registro)");
            System.out.println("5. Cargar las ventas del registro desde un fichero (item a item)");
            System.out.println("6. Guardar las ventas del registro en un fichero (item a item)");

            System.out.println("0. Salir");
            System.out.print("\nPor favor, introduzca una opción (0-6):");

            try {

                Scanner entrada = new Scanner(System.in);

                int opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        cargarRegistro();
                        break;
                    case 2:
                        mostrarRegistro();
                        break;
                    case 3:
                        crearVentasAleatorias();
                        break;
                    case 4:
                        guardarRegistro();
                        break;
                    case 5:
                        cargarItemsRegistro();
                        break;
                    case 6:
                        guardarItemsRegistro();
                        break;
                    case 0:
                        System.out.println("\n\nHasta pronto!!\n");
                        salir = true;
                        break;
                    default:
                        System.err.println("Error: Por favor, introduzca una opción válida (0-6)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Por favor, introduzca una opción válida (0-6)");
            }
        } while (salir != true);
    }

    public static void mostrarRegistro() {
        System.out.println(registro);
    }

    public static void crearVentasAleatorias() {

        // esta creación es aleatoria, por supuesto se puede 
        // crear a mano pidiendo datos al usuario
        boolean ventasOK = false;
        Publicacion item;

        do {
            System.out.print("\nIntroduce el número de ventas que se han realizado (se crearán de forma aleatoria N ventas):");

            try {

                Scanner entrada = new Scanner(System.in);
                int ventas = entrada.nextInt();
                boolean hayErrores = false;

                if (ventas > 0) {
                    for (int i = 0; i < ventas; i++) {

                        int aleatorio = (int) (Math.random() * 2); // tenemos solo dos tipos de publicaciones

                        switch (aleatorio) {
                            case 0:
                                item = new Coleccionable(Utils.obtenerTituloColeccionable(), (int) (Math.random() * 120));
                                break;

                            case 1:
                            default:
                                item = new Revista(Utils.obtenerTituloRevista(), Utils.obtenerFechaRevista());
                                break;
                        }

                        if (registro.anadirItemsEnVenta(item) == false) {
                            hayErrores = true;
                            System.err.println("Registro lleno !!! No se pudo añadir la venta " + (i + 1) + " : " + item);
                        }

                    }
                    ventasOK = true;

                    if (hayErrores == false) {
                        System.out.println("\n\nFinalizado !!!  Se añadieron " + ventas + " ventas al registro\n\n");
                    }
                } else {
                    System.err.println("Cantidad de ventas incorrecta, por favor inténtelo de nuevo");
                }

            } catch (InputMismatchException e) {
                System.err.println("Cantidad de ventas incorrecta, por favor inténtelo de nuevo");
            }

        } while (ventasOK != true);
    }

    public static void cargarRegistro() {
        //Se crea fichero 
        String nombreFichero = "registroVentas.dat";
        File fichero = new File(nombreFichero);

        if (fichero.exists()) {
            //hay que realizar un try //catch
            try {
                ///FileInputStream necesita File
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream entrada = new ObjectInputStream(fis);
                //Cargamos del archivo al array principal1
                registro = (RegistroVentas) entrada.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("No se puede leer archivo");
            } catch (IOException e) {
                System.out.println("El programa fallo al cargar");
            } catch (ClassNotFoundException e) {
                System.out.println("No hay datos del tipo registro ventas");
            }
        }
    }

    public static void guardarRegistro() {
        String nombreFichero = "registroVentas.dat";
        File fichero = new File(nombreFichero);
        //hay que realizar un try //catch
        try {
            ///FileOutputStream
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream salida = new ObjectOutputStream(fos);
            //Guardamos al archivo nuestro array principal1
            salida.writeObject(registro);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer archivo");
        } catch (IOException e) {
            System.out.println("No se puede leer archivo");
        }
    }

    public static void cargarItemsRegistro() {
        //objetos 1 a 1
        String nombreFichero = "itemVentas.dat";
        File fichero = new File(nombreFichero);
        Publicacion p;
        if (fichero.exists()) {
            try {
                ///FileInputStream necesita File
                FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream entrada = new ObjectInputStream(fis);
                //Cargamos del archivo al array principal1

                while ((p = (Publicacion) entrada.readObject()) != null) {
                    registro.anadirItemsEnVenta(p);
                }
            } catch (FileNotFoundException e) {
                System.out.println("No se puede leer archivo");
            } catch (IOException e) {
                System.out.println("No se puede leer archivo");
            } catch (ClassNotFoundException e) {
                System.out.println("No hay datos del tipo registro ventas");
            }
        } else {
            System.out.println("El fichero no existe");
        }

    }

    public static void guardarItemsRegistro() {

    }

}
