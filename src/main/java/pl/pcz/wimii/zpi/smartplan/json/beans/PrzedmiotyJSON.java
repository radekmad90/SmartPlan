package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "przedmiot")
public class PrzedmiotyJSON implements Serializable {

    private Integer id;
    private String nazwa;
    
    public PrzedmiotyJSON() {
        
    }
    
    public PrzedmiotyJSON(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}
