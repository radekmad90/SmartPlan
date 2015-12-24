/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import pl.pcz.wimii.zpi.smartplan.utils.CompareUtil;

/**
 *
 * @author Radek
 */
@XmlRootElement(name = "rokKierunek")
public class RokKierunekJSON implements Serializable, Comparable<RokKierunekJSON> {

    private int id;
    private String rok_akademicki;
    private String kierunek;
    private String specjalizacja;
    private Integer stopien;
    private Integer semestr;
    private Integer grupaDziekan;
    private Integer grupaLab;
    
    private String nazwa;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.rok_akademicki);
        hash = 41 * hash + Objects.hashCode(this.kierunek);
        hash = 41 * hash + Objects.hashCode(this.specjalizacja);
        hash = 41 * hash + Objects.hashCode(this.stopien);
        hash = 41 * hash + Objects.hashCode(this.semestr);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RokKierunekJSON other = (RokKierunekJSON) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.rok_akademicki, other.rok_akademicki)) {
            return false;
        }
        if (!Objects.equals(this.kierunek, other.kierunek)) {
            return false;
        }
        if (!Objects.equals(this.specjalizacja, other.specjalizacja)) {
            return false;
        }
        if (!Objects.equals(this.stopien, other.stopien)) {
            return false;
        }
        if (!Objects.equals(this.semestr, other.semestr)) {
            return false;
        }
        if (!Objects.equals(this.grupaDziekan, other.grupaDziekan)) {
            return false;
        }
        if (!Objects.equals(this.grupaLab, other.grupaLab)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(RokKierunekJSON other) {
        int i = CompareUtil.<String>cp(this.kierunek,other.getKierunek());
        if (i != 0) {
            return i;
        }
        i = CompareUtil.<Integer>cp(this.stopien,other.getStopien());
        if (i != 0) {
            return i;
        }
        i = CompareUtil.<Integer>cp(this.semestr,other.getSemestr());
        if (i != 0) {
            return i;
        }
        i = CompareUtil.<Integer>cp(this.grupaDziekan,other.getGrupaDziekan());
        if (i != 0) {
            return i;
        }
        i = CompareUtil.<Integer>cp(this.grupaLab,other.getGrupaLab());
        if (i != 0) {
            return i;
        }
        return CompareUtil.<String>cp(this.specjalizacja,other.getSpecjalizacja());
    }
}
