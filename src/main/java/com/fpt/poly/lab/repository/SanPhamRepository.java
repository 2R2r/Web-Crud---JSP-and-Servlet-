package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {


    public List<SanPham> getAll() {
        List<SanPham> listKH = new ArrayList<SanPham>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham ", SanPham.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public SanPham getOne(String id) {
        SanPham value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public Boolean add(SanPham khacHang) {
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

    public boolean update(SanPham value) {
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

    public Boolean delete(SanPham khacHang) {
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
