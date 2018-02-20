package propulsar.sinnix.domainlayer.models;

/**
 * Created by givet on 16/01/2018.
 */

public class Speaker {
    private String nombre;
    private String linkImg;
    private String icon;
    private String keynotes;
    private int userID;
    private String info1;
    private String info2;

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIcon() { return icon; }

    public void setIcon(String icon) { this.icon = icon; }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }

    public String getLinkImg() { return linkImg; }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getKeynotes() {
        return keynotes;
    }

    public void setKeynotes(String keynotes) {
        this.keynotes = keynotes;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }
}
