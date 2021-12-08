package CRUD;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean appActiva = true;
        int opcion;
        ArrayList<Alumno> ListaDeAlumnos = new ArrayList<Alumno>();

        do{
            System.out.println("|| Administrador de alumnos ||");
            System.out.println("1 - Agregar un nuevo alumno");
            System.out.println("2 - Consultar los alumnos de la lista");
            System.out.println("3 - Modificar los datos de un alumno");
            System.out.println("4 - Eliminar a un alumno de la lista");
            System.out.println("5 - Salir del programa");

            System.out.println("");
            System.out.print("Escriba su opcion: ");
            opcion = input.nextInt();

            if(opcion == 1){

                //Se piden los datos para la clase alumno
                input.nextLine();
                System.out.print("Introduzca el nombre del alumno: ");
                String nombreA = input.nextLine();
                System.out.print("Introduzca la calificación del alumno: ");
                int notaA = input.nextInt();

                //Se crea un alumno con los datos obtenidos
                Alumno a = new Alumno();
                a.setNombre(nombreA);
                a.setNota(notaA);
                //Se agrega a la lista de alumnos
                ListaDeAlumnos.add(a);
                System.out.println("Alumno añadido correctamente!");
            }
            else if(opcion == 2){

                //Se imprimen todos los datos
                System.out.println("Los alumnos en la lista son: ");
                for (Alumno a : ListaDeAlumnos){
                    System.out.println("Nombre: "+ a.getNombre() + ", Calificación: "+ a.getNota());
                }
            }
            else if(opcion == 3){
                System.out.print("Ingrese el nombre del alumno a modificar: ");
                String alumnoModificar = input.next();

                //Se pregunta que quiere modificar
                boolean menu = true;
                input.nextLine();//Para que el contenido del bucle no se imprima doble
                do{
                    System.out.println("¿Quiere modificar su nombre o su calificacion");
                    System.out.print("Escriba C para calificacion o N para nombre: ");
                    String respuesta = input.nextLine();

                    if(Objects.equals(respuesta, "C") || Objects.equals(respuesta, "c")){
                        System.out.print("Ingrese la nueva calificacion para " + alumnoModificar + ": ");
                        int notaNueva = input.nextInt();

                        //Se recorre el arraylist hasta encontrarlo y modificarlo
                        Iterator<Alumno> it = ListaDeAlumnos.iterator();
                        while( it.hasNext() ){
                            Alumno a = it.next();
                            if(Objects.equals(a.getNombre(), alumnoModificar)){
                                a.setNota(notaNueva);
                            }
                        }
                        System.out.println("¡Calificacion modificada!");
                        //Salimos del menu
                        menu = false;
                    }
                    else if(Objects.equals(respuesta, "N") || Objects.equals(respuesta, "n")){
                        System.out.print("Ingrese el nuevo nombre para " + alumnoModificar + ": ");
                        String nombreNuevo = input.nextLine();

                        //Se recorre el arraylist hasta encontrar el nombre y modificarlo
                        Iterator<Alumno> it = ListaDeAlumnos.iterator();
                        while( it.hasNext() ){
                            Alumno a = it.next();
                            if(Objects.equals(a.getNombre(), alumnoModificar)){
                                a.setNombre(nombreNuevo);
                            }
                        }

                        menu = false;
                    }
                    else{
                        System.out.println("Respuesta invalida, intentelo de nuevo");
                        System.out.println("");
                    }
                }while(menu);

            }
            else if(opcion == 4){
                //Se pide el nombre del alumno a eliminar
                System.out.print("Ingrese el nombre del alumno a eliminar: ");
                String alumnoEliminar = input.next();
                //Se recorre el arraylist hasta encontrarlo y borrarlo
                Iterator<Alumno> it = ListaDeAlumnos.iterator();
                while( it.hasNext() ){
                    Alumno a = it.next();
                    if(Objects.equals(a.getNombre(), alumnoEliminar)){
                        it.remove();
                    }
                }
                System.out.println("Alumno eliminado correctamente!");
            }
            else if(opcion == 5){
                appActiva = false;
                System.out.println("Adios :)");
                System.exit(0);

            }
            else{
                System.out.println("Vuelva a intentarlo con una opcion valida");
            }


        }while(appActiva = true);
    }
}
