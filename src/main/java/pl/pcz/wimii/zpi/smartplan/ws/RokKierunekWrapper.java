package pl.pcz.wimii.zpi.smartplan.ws;


import pl.pcz.wimii.zpi.smartplan.json.beans.PlanyJSON;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rokKierunek")
public class RokKierunekWrapper {

    private PlanyJSON plan;
    private String rok_akademicki;
    private String kierunek;
    private String specjalizacja;
    private Integer stopien;
    private Integer semestr;
    private Integer grupaDziekan;
    private Integer grupaLab;

    public PlanyJSON getPlan() {
        return plan;
    }

    public void setPlan(PlanyJSON plan) {
        this.plan = plan;
    }

    public String getRok_akademicki() {
        return rok_akademicki;
    }

    public void setRok_akademicki(String rok_akademicki) {
        this.rok_akademicki = rok_akademicki;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public Integer getStopien() {
        return stopien;
    }

    public void setStopien(Integer stopien) {
        this.stopien = stopien;
    }

    public Integer getSemestr() {
        return semestr;
    }

    public void setSemestr(Integer semestr) {
        this.semestr = semestr;
    }

    public Integer getGrupaDziekan() {
        return grupaDziekan;
    }

    public void setGrupaDziekan(Integer grupaDziekan) {
        this.grupaDziekan = grupaDziekan;
    }

    public Integer getGrupaLab() {
        return grupaLab;
    }

    public void setGrupaLab(Integer grupaLab) {
        this.grupaLab = grupaLab;
    }

}
