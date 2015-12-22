package pl.pcz.wimii.zpi.smartplan.ws;

import pl.pcz.wimii.zpi.smartplan.json.beans.ZajeciaJSON;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.Zajecia;

@XmlRootElement(name = "plan")
public class Student implements Serializable {

    private static final long serialVersionUID = 6718071273578435756L;

    private Integer id;
    private RokKierunek rokKierunek;
    private String planNazw;
    private Date dataPublikacji;
    private Date dataDodania;
    private int widoczny;
    private Integer rok;
    private String kierunek;
    private Set<ZajeciaJSON> zajecias = new HashSet<>(0);

}
