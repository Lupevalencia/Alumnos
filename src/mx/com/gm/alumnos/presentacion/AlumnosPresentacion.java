
package mx.com.gm.alumnos.presentacion;

import mx.com.gm.alumnos.domain.Alumno;
import java.util.Scanner;
import mx.com.gm.alumnos.servicio.*;



public class AlumnosPresentacion {
    public static void main(String[] args) {

       int opcion = -1;
       Scanner scanner = new Scanner(System.in);
        
      IAlumnos misAlumnos = new AlumnosImpl();
        
       while(opcion != 0){
            System.out.println("Elige una opcion : \n"
                    
            + "1. Escribir el archivo de datos\n"
            + "2. Leer y procesar los datos\n"
            + "0. Terminar");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion){
                case 1:
                     String nombre = "1234";
                     while(!nombre.matches("^[A-Za-z ]*$")){
                        System.out.println("Introducir el nombre de la persona. No son válidos números. ");
                        nombre = scanner.nextLine();
                     }
                     
                     //char sexo = ' '; muy buena opción pero no queremos que pueda introducir "MAMA" aunque tomaria M
                     //while(sexo != 'M' || sexo != 'F'){
                     //sexo = scanner.nextLine().charAt(0);
                     String sexo = " ";
                     while(!sexo.equalsIgnoreCase("MASCULINO") && !sexo.equalsIgnoreCase("FEMENINO") ){
                        System.out.println("Introduce el sexo de la persona (MASCULINO/FEMENINO): ");
                        sexo = scanner.nextLine();
                     }
                     
                     String edadString = "1234";
                     
                     while(!edadString.matches("[0-9](1,2)")){
                        System.out.println("Introducir la edad de la persona. Sólo válidos números comprendidos entre 1 y 99: ");
                        edadString = scanner.nextLine();
                         System.out.println("HOLAAA");
                     }
                     
                     int edad = Integer.parseInt(edadString);
                     //int edad = 101;
                     //while(){
                     //System.out.println("Introduce la edad de la persona : ");
                     //String edadString = scanner.nextLine();
                     //int edad = Integer.parseInt(edadString);
                     //}
                     
                     String estaturaString = " ";
                     while(!estaturaString.matches("^[100-210 ]*$")){
                        System.out.println("Introduce la estatura de la persona en CENTÍMETROS: ");
                        estaturaString = scanner.nextLine();   
                     }
                     float estatura = Float.parseFloat(estaturaString); 
                     
                     String pesoString = " ";
                     while(!pesoString.matches("^[10-100]*$")){
                        System.out.println("Introduce el peso de la persona en KG: ");
                        pesoString = scanner.nextLine();
                     }
                     float peso = Float.parseFloat(pesoString);
                     
                        
                      Alumno alumnoAAgregar = new Alumno(nombre,sexo,edad,estatura,peso);
                      misAlumnos.escribirArchivoAlumnos(alumnoAAgregar);
                   break;

                case 2:
                    //LLamar a los métodos y escribir el resultado por pantalla
                    misAlumnos.LeerYProcesarAlumnos();
                    break;
                case 0:
                    System.out.println("Hasta pronto!!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;                   
            
            }
         }
    
      }
}


