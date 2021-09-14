
package mx.com.gm.alumnos.presentacion;

import mx.com.gm.alumnos.domain.Alumno;
import java.util.Scanner;


public class AlumnosPresentacion {
    public static void main(String[] args) {
   //Un máximo establecido de 10 alumnos.
       var opcion = -1;
       var scanner = new Scanner(System.in);
        
       Alumno alumno = new Alumno();
        
       while(opcion != 0){
            System.out.println("Elige una opcion : \n"
                    
            + "1. Escribir el archivo de datos\n"
            + "2. Leer y procesar los datos\n"
            + "3. Terminar\n"
            + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion){
                case 1:
                     System.out.println("Introduce el nombre de la pesona : ");
                     String nombre = scanner.nextLine();
                        
                     System.out.println("Introduce el sexo de la persona : ");
                     String sexo = scanner.nextLine();
                        
                     System.out.println("Introduce la edad de la persona : ");
                     String edadString = scanner.nextLine();
                     int edad = Integer.parseInt(edadString);
                        
                     System.out.println("Introduce la estatura de la persona: ");
                     String estaturaString = scanner.nextLine();
                     float estatura =Float.parseFloat(estaturaString);
                        
                     System.out.println("Introduce el peso de la persona: ");
                     String pesoString = scanner.nextLine();
                     float peso = Float.parseFloat(pesoString);
                        
                      Alumno alumnoAgregado = new Alumno(nombre,sexo,edad,estatura,peso);
                        
                   break;

                case 2:
                    //LLamar a los métodos y escribir el resultado por pantalla
                    break;
                case 3:
                   
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


