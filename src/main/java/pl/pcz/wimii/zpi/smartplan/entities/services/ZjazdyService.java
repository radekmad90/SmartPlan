/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import java.util.List;
import org.hibernate.Session;
import pl.pcz.wimii.zpi.smartplan.entities.Zjazdy;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class ZjazdyService {

    public static List<Zjazdy> getZjazdy() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Zjazdy> godziny = session.createCriteria(Zjazdy.class).list();
        session.getTransaction().commit();
        return godziny;
    }

    public static Zjazdy addZjazd(Zjazdy zjazd) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(zjazd);
        session.getTransaction().commit();
        return zjazd;
    }
}
