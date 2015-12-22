package pl.pcz.wimii.zpi.smartplan.json.beans;

import pl.pcz.wimii.zpi.smartplan.json.beans.GodzinyJSON;
import pl.pcz.wimii.zpi.smartplan.json.beans.PrzedmiotyJSON;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zajecie")
public class ZajeciaJSON implements Serializable {

    private static final long serialVersionUID = 6718027127357843575L;
    private Integer id;
    private GodzinyJSON godziny;
    private PrzedmiotyJSON przedmioty;
    private String prowadzacyNazw;
    private String sala;

    public ZajeciaJSON() {
    }

    public ZajeciaJSON(Integer id, GodzinyJSON godziny, PrzedmiotyJSON przedmioty, String prowadzacyNazw, String sala) {
        this.id = id;
        this.godziny = godziny;
        this.przedmioty = przedmioty;
        this.prowadzacyNazw = prowadzacyNazw;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GodzinyJSON getGodziny() {
        return godziny;
    }

    public void setGodziny(GodzinyJSON godziny) {
        this.godziny = godziny;
    }

    public PrzedmiotyJSON getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(PrzedmiotyJSON przedmioty) {
        this.przedmioty = przedmioty;
    }

    public String getProwadzacyNazw() {
        return prowadzacyNazw;
    }

    public void setProwadzacyNazw(String prowadzacyNazw) {
        this.prowadzacyNazw = prowadzacyNazw;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

}
