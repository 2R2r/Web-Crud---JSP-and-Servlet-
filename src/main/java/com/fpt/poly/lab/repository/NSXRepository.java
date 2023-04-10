package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NSXRepository {



        public List<NSX> getAll() {
            List<NSX> listKH = new ArrayList<NSX>();
            try (Session session = HibernateUtil.getFACTORY().openSession()) {
                Query query = session.createQuery("FROM NSX ", NSX.class);
                listKH = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listKH;
        }

    public NSX getOne(String id) {
        NSX value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

        public Boolean add(NSX khacHang){
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

    public boolean update(NSX value) {
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

        public Boolean delete(NSX khacHang){
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
