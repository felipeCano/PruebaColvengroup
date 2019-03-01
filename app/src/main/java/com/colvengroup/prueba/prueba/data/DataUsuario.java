package com.colvengroup.prueba.prueba.data;

public class DataUsuario {
    private String apellido;
    private String barrio;
    private String birthday;
    private String direccion;
    private String email;
    private String foto;
    private String genero;
    private String latitud;
    private String location;
    private String longitud;
    private String nombre;
    private String telefono;
    private String timeFormatedRegistro;
    private String timeFormatedUltimaConexion;
    private String timeMillisRegistro;
    private String token;
    private String uniqueId;

    public DataUsuario(){

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTimeFormatedRegistro() {
        return timeFormatedRegistro;
    }

    public void setTimeFormatedRegistro(String timeFormatedRegistro) {
        this.timeFormatedRegistro = timeFormatedRegistro;
    }

    public String getTimeFormatedUltimaConexion() {
        return timeFormatedUltimaConexion;
    }

    public void setTimeFormatedUltimaConexion(String timeFormatedUltimaConexion) {
        this.timeFormatedUltimaConexion = timeFormatedUltimaConexion;
    }

    public String getTimeMillisRegistro() {
        return timeMillisRegistro;
    }

    public void setTimeMillisRegistro(String timeMillisRegistro) {
        this.timeMillisRegistro = timeMillisRegistro;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public DataUsuario(String apellido, String barrio, String birthday, String direccion, String email, String foto, String genero, String latitud, String location, String longitud, String nombre, String telefono, String timeFormatedRegistro, String timeFormatedUltimaConexion, String timeMillisRegistro, String token, String uniqueld) {
        this.apellido = apellido;
        this.barrio = barrio;

        this.birthday = birthday;
        this.direccion = direccion;
        this.email = email;
        this.foto = foto;
        this.genero = genero;
        this.latitud = latitud;
        this.location = location;
        this.longitud = longitud;
        this.nombre = nombre;
        this.telefono = telefono;
        this.timeFormatedRegistro = timeFormatedRegistro;
        this.timeFormatedUltimaConexion = timeFormatedUltimaConexion;
        this.timeMillisRegistro = timeMillisRegistro;
        this.token = token;
        this.uniqueId = uniqueld;
    }
}
