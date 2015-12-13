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
public class ZjazyService {
    public static List<Zjazdy> getZjazdy() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Zjazdy> godziny = session.createCriteria(Zjazdy.class).list();
        session.getTransaction().commit();
        return godziny;
    }
}
