/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.ws;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.bind.annotation.XmlRootElement;
import pl.pcz.wimii.zpi.smartplan.json.beans.RokKierunekJSON;

/**
 *
 * @author Radek
 */

@XmlRootElement(name = "rokKierunekList")
public class RokKierunekListWrapper implements Serializable {
    private Set<RokKierunekJSON> rokKierunekList = new TreeSet<>();

    public Set<RokKierunekJSON> getRokKierunekList() {
        return rokKierunekList;
    }

    public void setRokKierunekList(Set<RokKierunekJSON> rokKierunekList) {
        this.rokKierunekList = rokKierunekList;
    }
    
}
