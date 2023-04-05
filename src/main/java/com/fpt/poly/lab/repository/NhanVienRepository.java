package com.fpt.poly.lab.repository;


import com.fpt.poly.lab.entity.NhanVien;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {


    public List<NhanVien> getAll() {
        List<NhanVien> listKH = new ArrayList<NhanVien>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien ", NhanVien.class);
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public NhanVien getOne(String id) {
        NhanVien value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(NhanVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public Boolean add(NhanVien khacHang) {
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

    public boolean update(NhanVien value) {
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

    public Boolean delete(NhanVien khacHang) {
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
