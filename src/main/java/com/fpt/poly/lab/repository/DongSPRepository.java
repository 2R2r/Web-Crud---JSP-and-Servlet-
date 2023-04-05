package com.fpt.poly.lab.repository;


import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DongSPRepository {


    public List<DongSP> getAll() {
        List<DongSP> listKH = new ArrayList<DongSP>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongSP ", DongSP.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public DongSP getOne(String id) {
        DongSP value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public Boolean add(DongSP khacHang) {
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

    public boolean update(DongSP value) {
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

    public Boolean delete(DongSP khacHang) {
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
