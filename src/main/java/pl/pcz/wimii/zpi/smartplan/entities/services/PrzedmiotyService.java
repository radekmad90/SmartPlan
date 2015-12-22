/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.entities.services;

import org.hibernate.Session;
import pl.pcz.wimii.zpi.smartplan.entities.Przedmioty;
import pl.pcz.wimii.zpi.smartplan.entities.configuration.HibernateUtil;

/**
 *
 * @author Radek
 */
public class PrzedmiotyService {
      public static Przedmioty addPrzedmiot(Przedmioty przedmiot) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(przedmiot);
        session.getTransaction().commit();
        return przedmiot;
    }
}
