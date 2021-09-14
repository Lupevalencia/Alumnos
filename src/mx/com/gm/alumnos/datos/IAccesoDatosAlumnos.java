
package mx.com.gm.alumnos.datos;

import mx.com.gm.alumnos.domain.Alumno;
import mx.com.gm.alumnos.excepciones.AccesoDatosEx;
import mx.com.gm.alumnos.excepciones.EscrituraDatosEx;


public interface IAccesoDatosAlumnos {
    boolean existeAlumno(String nombreFicheroAlumnos) throws AccesoDatosEx;
    
    void escribirAlumno(Alumno alumno ,String nombreFicheroAlumnos, boolean anexar) throws EscrituraDatosEx;
     
    void crearAlumno(String nombreFicheroAlumnos) throws AccesoDatosEx;
}
