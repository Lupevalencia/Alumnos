
package mx.com.gm.alumnos.servicio;

import mx.com.gm.alumnos.datos.AccesoDatosAlumnosImpl;
import mx.com.gm.alumnos.datos.IAccesoDatosAlumnos;
import mx.com.gm.alumnos.domain.Alumno;
import mx.com.gm.alumnos.excepciones.AccesoDatosEx;
import mx.com.gm.alumnos.excepciones.EscrituraDatosEx;


public class AlumnosImpl implements IAlumnos {
    private final IAccesoDatosAlumnos datos;
    
    public AlumnosImpl(){
         this.datos = new AccesoDatosAlumnosImpl();
    }    

    @Override
    public void escribirArchivoAlumnos(Alumno alumnoAAgregar) {
        
        boolean anexar = false;
        try {
            anexar = datos.existeAlumno(NOMBRE_FICHERO_ALUMNOS);
            datos.escribirAlumno(alumnoAAgregar, NOMBRE_FICHERO_ALUMNOS, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        } catch (EscrituraDatosEx ex) {
           System.out.println("Error de escritura de datos");
           ex.printStackTrace();
           
        }        
    }

    @Override
    public void LeerYProcesarAlumnos() {
        float resultadoPromedio = 0;
        int resultadoPersonas = 0; 
        try {
            resultadoPromedio = this.datos.promedioEdad(NOMBRE_FICHERO_ALUMNOS);
            resultadoPersonas = this.datos.totalPersonas(NOMBRE_FICHERO_ALUMNOS);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);            
        }
        System.out.println("resultadoPromedio = " + resultadoPromedio);
        System.out.println("resultadoPersonas = " + resultadoPersonas); 
    }
}
