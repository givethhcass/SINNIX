package propulsar.sinnix.domainlayer.models;

/**
 * Created by givet on 16/01/2018.
 */

public class Agenda
{
    private String speak;
    private String nombre;
    private String icon;
    private String info;
    private String locacion;
    private String fecha;
    private String horario;
    private String linkimg;

    public String getSpeak() { return speak; }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }
}
