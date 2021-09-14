
package mx.com.gm.alumnos.datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.alumnos.domain.Alumno;
import mx.com.gm.alumnos.excepciones.AccesoDatosEx;
import mx.com.gm.alumnos.excepciones.EscrituraDatosEx;


public class AccesoDatosAlumnosImpl implements IAccesoDatosAlumnos{

    @Override
    public boolean existeAlumno(String nombreFicheroAlumnos) throws AccesoDatosEx {
        var archivoAlumnos = new File(nombreFicheroAlumnos);
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
       
       var salida = new PrintWriter(new FileWriter(archivoAlumnos,anexar));
    }
    
}
