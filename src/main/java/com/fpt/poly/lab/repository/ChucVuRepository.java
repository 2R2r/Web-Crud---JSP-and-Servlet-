package com.fpt.poly.lab.repository;


import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> listKH = new ArrayList<ChucVu>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ", ChucVu.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public ChucVu getOne(String id) {
        ChucVu value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public Boolean add(ChucVu khacHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khacHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(ChucVu value) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(value);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean delete(ChucVu khacHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khacHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(System.out);
            return false;
        }
    }


}
