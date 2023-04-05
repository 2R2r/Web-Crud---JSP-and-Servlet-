package com.fpt.poly.lab.repository;


import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {


    public List<MauSac> getAll() {
        List<MauSac> listKH = new ArrayList<MauSac>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac ", MauSac.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public MauSac getOne(String id) {
        MauSac value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public Boolean add(MauSac khacHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khacHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean update(MauSac value) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(value);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean delete(MauSac khacHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khacHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


}
