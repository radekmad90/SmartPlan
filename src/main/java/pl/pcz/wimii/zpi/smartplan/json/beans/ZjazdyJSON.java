package pl.pcz.wimii.zpi.smartplan.json.beans;

import pl.pcz.wimii.zpi.smartplan.json.beans.ZajeciaJSON;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zjazd")
public class ZjazdyJSON implements Serializable, Comparable<Object> {

    private static final long serialVersionUID = 6718027127357843575L;
    private Integer id;
    private Date data;
    private List<ZajeciaJSON> zajecia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ZajeciaJSON> getZajecia() {
        return zajecia;
    }

    public void setZajecia(List<ZajeciaJSON> zajecia) {
        this.zajecia = zajecia;
    }

    @Override
    public int compareTo(Object o) {
        ZjazdyJSON zj = (ZjazdyJSON) o;
        return this.getId().compareTo(zj.getId());
    }

}
