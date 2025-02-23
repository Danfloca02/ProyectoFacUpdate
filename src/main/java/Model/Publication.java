/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Publication {
    private long PUBLICATIONID;
    private String titulo;
    private long autor;
    private String place;
    private LocalDateTime fecha;
    private String descripcion;
    private int maxCapacity;
    private List<Long> participants;

    public Publication(long EVENTID,String titulo, int autor,String place, LocalDateTime fecha, String descripcion, int maxCapacity, List<Long> participants) {
        this.PUBLICATIONID = EVENTID;
        this.titulo = titulo;
        this.fecha = fecha;
        this.place = place;
        this.autor = autor;
        this.descripcion = descripcion;
        this.maxCapacity = maxCapacity;
        this.participants = participants;
    }
    public Publication(long EVENTID, String titulo, int autor, String place,LocalDateTime fecha, String descripcion, int maxCapacity) {
        this.PUBLICATIONID = EVENTID;
        this.titulo = titulo;
        this.fecha = fecha;
        this.place = place;
        this.autor = autor;
        this.descripcion = descripcion;
        this.maxCapacity = maxCapacity;
        participants = new ArrayList<>();
    }
    public Publication(){
        this.PUBLICATIONID = 0;
        this.titulo = "";
        this.fecha = LocalDateTime.of(1,1,1,1,1);
        this.place = "";
        this.autor = 0;
        this.descripcion = "";
        this.maxCapacity = 0;
        participants = new ArrayList<>();
    }
    public String getTitulo() {
        return titulo;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getPlace() {
        return place;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }
    public List<Long> getParticipants() {
        return participants;
    }
    public long getPUBLICATIONID(){
        return PUBLICATIONID;
    }
    public long getAutorID(){
        return autor;
    }
    
    public void setTitulo(String line){
        this.titulo = line;
    }
    public void setEventID(long line){
        this.PUBLICATIONID = line;
    }
    public void setFecha(LocalDateTime fecha){
        this.fecha = fecha;
    }
    public void setAutorID(Long line){
        this.autor = line;
    }
    public void setDescription(String line){
        this.descripcion = line;
    }
    public void setMaxCapacity(int line){
        this.maxCapacity = line;
    }
    public void setParticipants(List<Long> a){
        this.participants = a;
    }
    public void setPlace(String line){
        place = line;
    }
    public boolean addParticipant(Long participant) {
        if (this.participants.size() < this.maxCapacity) {
            this.participants.add(participant);
            maxCapacity--;
            return true;
        } 
        return false;
    }
}
