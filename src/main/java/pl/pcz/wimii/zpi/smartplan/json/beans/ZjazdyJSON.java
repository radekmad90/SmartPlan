package pl.pcz.wimii.zpi.smartplan.json.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zjazd")
public class ZjazdyJSON implements Serializable, Comparable<Object> {

    private static final long serialVersionUID = 6718027127357843575L;
    private Integer id;
    private Date data;
    private Boolean active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int compareTo(Object o) {
        ZjazdyJSON zj = (ZjazdyJSON) o;
        return this.getId().compareTo(zj.getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.data);
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
        final ZjazdyJSON other = (ZjazdyJSON) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

}
