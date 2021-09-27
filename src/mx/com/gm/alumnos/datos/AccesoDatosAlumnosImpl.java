
package mx.com.gm.alumnos.datos;

import java.io.*;
import mx.com.gm.alumnos.domain.Alumno;
import mx.com.gm.alumnos.excepciones.*;


public class AccesoDatosAlumnosImpl implements IAccesoDatosAlumnos{

    @Override
    public boolean existeAlumno(String nombreFicheroAlumnos) throws AccesoDatosEx {
        File archivoAlumnos = new File(nombreFicheroAlumnos);
        return archivoAlumnos.exists();
       
    }

    @Override
    public void escribirAlumno(Alumno alumno, String nombreFicheroAlumnos, boolean anexar) throws EscrituraDatosEx {
        File archivoAlumnos = new File(nombreFicheroAlumnos);
        try {
            var salida = new PrintWriter(new FileWriter(archivoAlumnos,anexar));
            
            salida.println(alumno.getNombre() + ";" + " " + alumno.getSexo() 
                    + ";" + " " + alumno.getEdad() + ";" + " " + alumno.getEstatura() + ";" + " " + alumno.getPeso());
            salida.close();
            System.out.println("El Alumnos se ha añadido correctamente ");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir Alumnos " + ex.getMessage());
        }
    }

    @Override
    public void crearAlumno(String nombreFicheroAlumnos) throws AccesoDatosEx {
       File archivoAlumnos = new File(nombreFicheroAlumnos);
       
        try {
            var salida = new PrintWriter(new FileWriter(archivoAlumnos));
            salida.close();
            System.out.println("Se ha creado el archivo de Alumnos");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear Alumnos " + ex.getMessage());
        }
    }

    @Override
    public float promedioEdad(String nombreFicheroAlumnos) throws AccesoDatosEx {
        File archivoAlumnos = new File(nombreFicheroAlumnos);
        int resultadoPromedio = 0;
        try {
            var entrada = new BufferedReader(new FileReader(archivoAlumnos));
            String linea = null;
            linea = entrada.readLine();
            
            //float resultadoPromedio = 0;
            int indice = 0;
            while (linea != null){
                String[] lineaArray = linea.split(";");
                //lineaArray[1].trim().charAt(0) == 'M'
                if (lineaArray[1].trim().equalsIgnoreCase("MASCULINO")) { 
                    resultadoPromedio += Integer.parseInt(lineaArray[2].trim());
                    indice++;
                }
                linea = entrada.readLine();
            }
            if(indice >0){
            resultadoPromedio =resultadoPromedio/ indice;}
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear Alumnos " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear Alumnos " + ex.getMessage());            
        }
        //System.out.println("La edad promedio de personas con sexo masculino es: ");
        return resultadoPromedio;
    }
    
    @Override
    public int totalPersonas(String nombreFicheroAlumnos) throws AccesoDatosEx {
        File archivoAlumnos = new File(nombreFicheroAlumnos);
        int resultadoPersonas = 0;
        try {
            var entrada = new BufferedReader(new FileReader(archivoAlumnos));
            String linea = null;
            linea = entrada.readLine();
            
            while (linea != null){
                String[] lineaArray = linea.split(";");
                if (Float.parseFloat(lineaArray[3].trim()) >= 1.65) { 
                    resultadoPersonas++;
                }
                linea = entrada.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear Alumnos " + ex.getMessage());            
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear Alumnos " + ex.getMessage());               
        }
        //System.out.println("El número total de personas que miden más de 1.65 es: ");
        return resultadoPersonas;
    }

    
}
