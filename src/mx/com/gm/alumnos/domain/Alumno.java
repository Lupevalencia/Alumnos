
package mx.com.gm.alumnos.domain;

public class Alumno {  //Las mayúsculas diferencian a las clases de los métodos
    static final int TAM_MAX = 10;
    
    String nombre;
    String sexo;
    int edad;
    float estatura;
    float peso;

    //Constructores
    public Alumno() {
    }

    public Alumno(int edad) {
        this.edad = edad;
    }

    public Alumno(float estatura) {
        this.estatura = estatura;
    }

    public Alumno(String nombre, String sexo, int edad, float estatura, float peso) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
    }
    
    //Métodos

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return this.estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    //toString

    @Override
    public String toString() {
        return "alumno{" + "nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", estatura=" + estatura + ", peso=" + peso + '}';
    }

    
   
    
}
