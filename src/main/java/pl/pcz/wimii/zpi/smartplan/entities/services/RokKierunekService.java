/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import java.util.List;
import static javax.ws.rs.core.Response.status;
import static jdk.nashorn.internal.objects.NativeJava.type;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class RokKierunekService {

    public static List<RokKierunek> getRokKierunek(String rok_akademicki, Integer rok, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(RokKierunek.class);
        c.add(Restrictions.eq("rok_akademicki", rok_akademicki));
        c.add(Restrictions.eq("rok", rok));
        c.add(Restrictions.eq("kierunek", kierunek));
        if (spec != null && !spec.equals("")) {
            c.add(Restrictions.eq("specjalizacja", spec));
        }
        if (stopien != null && !stopien.equals(0)) {
            c.add(Restrictions.eq("stopien", stopien));
        }
        c.add(Restrictions.eq("semestr", semestr));
        if (grupaDziekan != null && !grupaDziekan.equals(0)) {
            c.add(Restrictions.eq("grupa_dziekan", grupaDziekan));
        }
        if (grupaLab != null && !grupaLab.equals(0)) {
            c.add(Restrictions.eq("grupa_lab", grupaLab));
        }
        List<RokKierunek> result = c.list();
        session.getTransaction().commit();

        return result;
    }

    public static RokKierunek addRokKierunek(String rok_akademicki, Integer rok, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {
        RokKierunek rokKierunek = new RokKierunek(rok_akademicki, rok, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(rokKierunek);

        session.getTransaction().commit();
        session.beginTransaction();
        return (RokKierunek) session.get(RokKierunek.class, id);
    }

}
