/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import java.util.List;
import org.hibernate.Session;
import pl.pcz.wimii.zpi.smartplan.entities.Godziny;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class GodzinyService {

    private static List<Godziny> godziny;
    
    public static List<Godziny> getGodziny() {
        if (godziny == null) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        godziny = session.createCriteria(Godziny.class).list();
        session.getTransaction().commit();
        }
        return godziny;
    }
    public static void addGodziny(Godziny godz) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(godz);
        session.getTransaction().commit();
        
        
    }
}
