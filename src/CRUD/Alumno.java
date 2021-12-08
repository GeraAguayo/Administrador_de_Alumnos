package CRUD;

public class Alumno {
    private String nombre;
    private int nota;

    //Metodos getters
    public String getNombre(){
        return nombre;
    }

    public int getNota(){
        return nota;
    }

    //Metodos setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
