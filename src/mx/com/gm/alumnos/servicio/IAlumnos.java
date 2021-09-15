
package mx.com.gm.alumnos.servicio;

import mx.com.gm.alumnos.domain.Alumno;


public interface IAlumnos {
        String NOMBRE_FICHERO_ALUMNOS = "alumnos.txt";
        
        
        void escribirArchivoAlumnos(Alumno alumnoAAgregar);
        void LeerYProcesarAlumnos();
        
}
