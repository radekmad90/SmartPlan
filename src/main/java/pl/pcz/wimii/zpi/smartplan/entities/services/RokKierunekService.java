/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pl.pcz.wimii.zpi.smartplan.entities.Plany;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.Zajecia;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class RokKierunekService {

    private static final Logger logger = Logger.getLogger(RokKierunekService.class);

    public static List<RokKierunek> getRokKierunekAndZajecia(String rok_akademicki, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {
        logger.info("getRokKierunekAndZajecia");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(RokKierunek.class);
        c.add(Restrictions.eq("rok_akademicki", rok_akademicki));
        c.add(Restrictions.eq("kierunek", kierunek));
        if (spec != null && !spec.equals("")) {
            c.add(Restrictions.eq("specjalizacja", spec));
        }
        if (stopien != null && !stopien.equals(0)) {
            c.add(Restrictions.eq("stopien", stopien));
        }
        c.add(Restrictions.eq("semestr", semestr));
        if (grupaDziekan != null && !grupaDziekan.equals(0)) {
            c.add(Restrictions.eq("grupaDziekan", grupaDziekan));
        }
        if (grupaLab != null && !grupaLab.equals(0)) {
            c.add(Restrictions.eq("grupaLab", grupaLab));
        }
        List<RokKierunek> result = c.list();
        if (result != null && !result.isEmpty()) {
            RokKierunek rokKier = result.get(0);
            rokKier.getPlany().getPrzedmioties().size();
            rokKier.getPlany().getZajecias().size();
        }

        session.getTransaction().commit();

        return result;
    }

    public static List<RokKierunek> getRokKierunekList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<RokKierunek> result = session.createCriteria(RokKierunek.class).list();

        session.getTransaction().commit();
        return result;
    }

    public static RokKierunek addRokKierunek(Plany plan, String rok_akademicki, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {
        RokKierunek rokKierunek = new RokKierunek(rok_akademicki, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        rokKierunek.setPlany(plan);
        Integer id = (Integer) session.save(rokKierunek);
        session.getTransaction().commit();
        return rokKierunek;
    }

    public static List<RokKierunek> getRokKierunekById(int id) {
        logger.info("rokkierunekbyid: " + id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        RokKierunek rokKierunek = (RokKierunek) session.get(RokKierunek.class, id);
        if (rokKierunek != null) {
            rokKierunek.getPlany().getPrzedmioties().size();
            rokKierunek.getPlany().getZajecias().size();
        }
        session.getTransaction().commit();
        List<RokKierunek> lista = new ArrayList<>();
        lista.add(rokKierunek);
        return lista;
    }

    public static RokKierunek clearRokKierunek(RokKierunek rokKierunek, Date publicationTime) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.refresh(rokKierunek);
        rokKierunek.getPlany().setDataPublikacji(publicationTime);
        rokKierunek.getPlany().setDataDodania(Calendar.getInstance().getTime());
        Set<Zajecia> zajecia = rokKierunek.getPlany().getZajecias();
        for (Zajecia zaj : zajecia) {
            session.delete(zaj);
        }
        zajecia.clear();
        session.getTransaction().commit();
        return rokKierunek;
    }

}
