/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;

/**
 *
 * @author Radek
 */
public class RokKierunekAndUrlJSON implements Serializable {

    private String url;
    private String rokAkademicki;
    private String kierunek;
    private String specjalizacja;
    private Integer stopien;
    private Integer semestr;
    private Integer grupaDziekan;
    private Integer grupaLab;
    private Integer idRokKierunek;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRokAkademicki() {
        return rokAkademicki;
    }

    public void setRokAkademicki(String rokAkademicki) {
        this.rokAkademicki = rokAkademicki;
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

    public Integer getIdRokKierunek() {
        return idRokKierunek;
    }

    public void setIdRokKierunek(Integer idRokKierunek) {
        this.idRokKierunek = idRokKierunek;
    }

}
