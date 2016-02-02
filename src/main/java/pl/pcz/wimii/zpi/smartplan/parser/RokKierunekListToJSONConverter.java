/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.parser;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.json.beans.RokKierunekJSON;

/**
 *
 * @author Radek
 */
public class RokKierunekListToJSONConverter {

    private final Logger logger = Logger.getLogger(this.getClass());
    public  Set<RokKierunekJSON> convert(Set<RokKierunekJSON> rokKierunekSet, List<RokKierunek> rokKierunekList) {
        logger.info("convert");
        for(RokKierunek rokKier :rokKierunekList) {
            RokKierunekJSON json = new RokKierunekJSON();
            json.setGrupaDziekan(rokKier.getGrupaDziekan());
            json.setGrupaLab(rokKier.getGrupaLab());
            json.setId(rokKier.getId());
            json.setKierunek(rokKier.getKierunek());
            json.setRok_akademicki(rokKier.getRok_akademicki());
            json.setSemestr(rokKier.getSemestr());
            json.setSpecjalizacja(rokKier.getSpecjalizacja());
            json.setStopien(rokKier.getStopien());
            json.setNazwa(rokKier.getPlany().getPlanNazw());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            json.setDataPublikacji(rokKier.getPlany().getDataPublikacji());
            rokKierunekSet.add(json);
        }
        return rokKierunekSet;
    }

}
