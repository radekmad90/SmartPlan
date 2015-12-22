package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
public class PlanyJSON implements Serializable {

    private static final long serialVersionUID = 6718027127357843575L;
     private Integer id;
     private String planNazw;
     private Date dataPublikacji;
     private Date dataDodania;
     private int widoczny;
     private Integer rok;
     private String kierunek;
     private Set<ZjazdyJSON> zjazdy = new HashSet<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanNazw() {
        return planNazw;
    }

    public void setPlanNazw(String planNazw) {
        this.planNazw = planNazw;
    }

    public Date getDataPublikacji() {
        return dataPublikacji;
    }

    public void setDataPublikacji(Date dataPublikacji) {
        this.dataPublikacji = dataPublikacji;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public int getWidoczny() {
        return widoczny;
    }

    public void setWidoczny(int widoczny) {
        this.widoczny = widoczny;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public Set<ZjazdyJSON> getZjazdy() {
        return zjazdy;
    }

    public void setZjazdy(Set<ZjazdyJSON> zjazdy) {
        this.zjazdy = zjazdy;
    }

}
