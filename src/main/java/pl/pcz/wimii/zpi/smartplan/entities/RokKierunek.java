package pl.pcz.wimii.zpi.smartplan.entities;
// Generated 2015-12-07 21:04:58 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RokKierunek generated by hbm2java
 */
@Entity
@Table(name = "rok_kierunek", catalog = "smartplan"
)
public class RokKierunek implements java.io.Serializable {

    private int id;
    private String rok_akademicki;
    private Integer rok;
    private String kierunek;
    private String specjalizacja;
    private Integer stopien;
    private Integer semestr;
    private Integer grupaDziekan;
    private Integer grupaLab;
    private Set<Przedmioty> przedmioties = new HashSet<>(0);
    private Set<Plany> planies = new HashSet<>(0);

    public RokKierunek() {
    }

    public RokKierunek(int id, Integer rok, String kierunek) {
        this.id = id;
        this.rok = rok;
        this.kierunek = kierunek;
    }

    public RokKierunek( String rok_akademicki, Integer rok, String kierunek, String specjalizacja, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {
        this.rok_akademicki = rok_akademicki;
        this.rok = rok;
        this.kierunek = kierunek;
        this.specjalizacja = specjalizacja;
        this.stopien = stopien;
        this.semestr = semestr;
        this.grupaDziekan = grupaDziekan;
        this.grupaLab = grupaLab;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "kierunek", nullable = false, length = 45)
    public String getKierunek() {
        return this.kierunek;
    }

    @Column(name = "rok_akademicki", nullable = false, length = 45)
    public String getRok_akademicki() {
        return rok_akademicki;
    }

    public void setRok_akademicki(String rok_akademicki) {
        this.rok_akademicki = rok_akademicki;
    }

    @Column(name = "rok", nullable = false, length = 45)
    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    @Column(name = "specjalizacja", length = 45)
    public String getSpecjalizacja() {
        return this.specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    @Column(name = "stopien")
    public Integer getStopien() {
        return this.stopien;
    }

    public void setStopien(Integer stopien) {
        this.stopien = stopien;
    }

    @Column(name = "semestr")
    public Integer getSemestr() {
        return this.semestr;
    }

    public void setSemestr(Integer semestr) {
        this.semestr = semestr;
    }

    @Column(name = "grupa_dziekan")
    public Integer getGrupaDziekan() {
        return this.grupaDziekan;
    }

    public void setGrupaDziekan(Integer grupaDziekan) {
        this.grupaDziekan = grupaDziekan;
    }

    @Column(name = "grupa_lab")
    public Integer getGrupaLab() {
        return this.grupaLab;
    }

    public void setGrupaLab(Integer grupaLab) {
        this.grupaLab = grupaLab;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rokKierunek")
    public Set<Przedmioty> getPrzedmioties() {
        return this.przedmioties;
    }

    public void setPrzedmioties(Set<Przedmioty> przedmioties) {
        this.przedmioties = przedmioties;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rokKierunek")
    public Set<Plany> getPlanies() {
        return this.planies;
    }

    public void setPlanies(Set<Plany> planies) {
        this.planies = planies;
    }

    @Override
    public String toString() {
        return "RokKierunek{" + "id=" + id + ", rok_akademicki=" + rok_akademicki + ", rok=" + rok + ", kierunek=" + kierunek + ", specjalizacja=" + specjalizacja + ", stopien=" + stopien + ", semestr=" + semestr + ", grupaDziekan=" + grupaDziekan + ", grupaLab=" + grupaLab + '}';
    }

}
