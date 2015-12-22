package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "godziny")
public class GodzinyJSON implements Serializable {

    private static final long serialVersionUID = 6718027127357843575L;
    private Integer id;
    private String godz;

    public GodzinyJSON() {
    }   

    public GodzinyJSON(String godz) {
        this.godz = godz;
    }
     
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGodz() {
        return godz;
    }

    public void setGodz(String godz) {
        this.godz = godz;
    }

}
