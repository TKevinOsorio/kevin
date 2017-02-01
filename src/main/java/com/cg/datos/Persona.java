package com.cg.datos;

public class Persona implements Comparable<Persona> {

    //Se utiliza final para indicar que los valores son constantes, esto hace que no admita cambios
    //despues de su declaracion y asignacion de valor 
    
    public static final String EDAD = "EDAD";
    public static final String ID = "ID";
    public static String Criterio = EDAD;

    private int edad;

    private String nombre;

    private String identificacion;

    public Persona() {
        this(0, "", "");
    }

    public Persona(int edad, String nombre, String identificacion) {
        this.edad = edad;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    /**
     * Get the value of identificacion
     *
     * @return the value of identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Set the value of identificacion
     *
     * @param identificacion new value of identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    // Metodo que compara los datos presentados en la tabla EDAD/ID utilizando compareTo()
    
    @Override
    public int compareTo(Persona p) {
        int val = 0;

        switch (Criterio) {
            case ID:
                val = identificacion.compareTo(p.identificacion);
                break;
            case EDAD:
                val = edad - p.edad;
                if ( val == 0)
                {
                    val = identificacion.compareTo(p.identificacion);
                }
                break;
        }

        return val;
    }

}
