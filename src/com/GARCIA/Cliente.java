package com.GARCIA;

import com.GARCIA.excepciones.ErrorValidacion;

public class Cliente {

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


    //constructor
    public Cliente(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId() {   //para devolver

        return id;
    }

    //metodo
    public void setId(String id) throws ErrorValidacion {  //para modificar ,y este metodo
                                 //^ puede mandar una exception  usando el throws
        if (id.length() != 13) {
        throw new ErrorValidacion("El numero de indentidad bede contener 13 caracteres");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     //metodo
    public String getNombreCompleto(){

        return this.nombre+ " "+this.apellido;
    }


    public String getTelefono() {

        return telefono;
    }

    //tarea  poner un errorvalidacion en correo
    public void setTelefono(String telefono) throws ErrorValidacion {
        if (!telefono.matches("^(\\+504\\s?)?[0-9]{4}\\-?[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public String getEmail() {

        return email;
    }

    /**correo electronico**/
    public void setEmail(String email) throws ErrorValidacion {
                if (!email.matches("[a-z1-9]+(\\@)?.*")){
                    throw new ErrorValidacion("El correo que ingreso es invalido");
                }
        this.email = email;
    }




}
