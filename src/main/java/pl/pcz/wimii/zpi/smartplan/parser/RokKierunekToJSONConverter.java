/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.Plany;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.Zajecia;
import pl.pcz.wimii.zpi.smartplan.entities.Zjazdy;
import pl.pcz.wimii.zpi.smartplan.json.beans.GodzinyJSON;
import pl.pcz.wimii.zpi.smartplan.json.beans.PlanyJSON;
import pl.pcz.wimii.zpi.smartplan.json.beans.PrzedmiotyJSON;
import pl.pcz.wimii.zpi.smartplan.ws.RokKierunekWrapper;
import pl.pcz.wimii.zpi.smartplan.json.beans.ZajeciaJSON;
import pl.pcz.wimii.zpi.smartplan.json.beans.ZjazdyJSON;

/**
 *
 * @author Radek
 */
public class RokKierunekToJSONConverter {

    private final Logger logger = Logger.getLogger(this.getClass());
    public  RokKierunekWrapper convert(RokKierunek rokKierunek) {
        logger.info("convert");
        RokKierunekWrapper wrapper = new RokKierunekWrapper();
        wrapper.setGrupaDziekan(rokKierunek.getGrupaDziekan());
        wrapper.setGrupaLab(rokKierunek.getGrupaLab());
        wrapper.setKierunek(rokKierunek.getKierunek());
        wrapper.setRok_akademicki(rokKierunek.getRok_akademicki());
        wrapper.setSemestr(rokKierunek.getSemestr());
        wrapper.setSpecjalizacja(rokKierunek.getSpecjalizacja());
        wrapper.setStopien(rokKierunek.getStopien());
        
        
        PlanyJSON planJSON = new PlanyJSON();
        Plany plan = rokKierunek.getPlany();
        planJSON.setDataDodania(plan.getDataDodania());
        planJSON.setDataPublikacji(plan.getDataPublikacji());
        planJSON.setId(plan.getId());
        planJSON.setPlanNazw(plan.getPlanNazw());
        planJSON.setWidoczny(plan.getWidoczny());
        
        Set<Zjazdy> zjazdy = new TreeSet<>();
        for (Zajecia zaj : plan.getZajecias()) {
            logger.info("petla zaj ecia");
            zjazdy.add(zaj.getZjazdy());
        }
        
        Set<ZjazdyJSON> zjazdyJSON = new TreeSet<>();
        for(Zjazdy zjazd : zjazdy) {
            logger.info("petla zjazdy");
            ZjazdyJSON zjazdJSON = new ZjazdyJSON();
            zjazdJSON.setData(zjazd.getData());
            zjazdJSON.setId(zjazd.getId());
            Set<Zajecia> zajecia = new TreeSet(plan.getZajecias().stream().filter(z-> z.getZjazdy().equals(zjazd)).collect(Collectors.toSet()));
            List<ZajeciaJSON> zajeciaJSON = zajecia.stream().map(z -> new ZajeciaJSON(z.getId(),new GodzinyJSON(z.getGodziny().getGodz()),new PrzedmiotyJSON(z.getPrzedmioty().getNazwa()),z.getProwadzacyNazw(),z.getSala())).collect(Collectors.toList());
            zjazdJSON.setZajecia(zajeciaJSON);
            zjazdyJSON.add(zjazdJSON);
        }
        planJSON.setZjazdy(zjazdyJSON);
        
        wrapper.setPlan(planJSON);
        return wrapper;
    }
}
