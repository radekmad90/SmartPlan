/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pcz.wimii.zpi.smartplan.entities.Godziny;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class GodzinyService {

    public static List<Godziny> getGodziny() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Godziny> godziny = session.createCriteria(Godziny.class).list();
        session.getTransaction().commit();
        return godziny;
    }

}
