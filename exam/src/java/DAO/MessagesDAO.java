/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Messages;
import Hibernate.NewHibernateUtil;
import java.util.List;
import metier.IMessages;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class MessagesDAO implements IMessages{

    @Override
    public List<Messages> getListMsg() {
       List< Messages> listeMsg = null;
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            listeMsg = se.createQuery("from Messages order by date desc").list();

            // commit transaction
            tr.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return listeMsg;     }

    @Override
    public String Enregistrer(Messages m) {
                try{
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(m);
            tr.commit();
            return "ok";
            
            
        }catch (Exception x) {
            return "ko";
    }    }    }