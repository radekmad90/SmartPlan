package pl.pcz.wimii.zpi.smartplan.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import pl.pcz.wimii.zpi.smartplan.entities.Godziny;

@XmlRootElement(name = "students")
public class StudentWrapper {

    private List<Student> list;

    public StudentWrapper() {
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    private List<Godziny> godziny;

    public List<Godziny> getGodziny() {
        return godziny;
    }

    public void setGodziny(List<Godziny> godziny) {
        this.godziny = godziny;
    }

}
