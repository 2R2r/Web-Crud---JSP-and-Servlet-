package com.fpt.poly.lab.repository;


import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {



        public List<CuaHang> getAll() {
            List<CuaHang> listKH = new ArrayList<CuaHang>();
            try (Session session = HibernateUtil.getFACTORY().openSession()) {
                Query query = session.createQuery("FROM CuaHang ", CuaHang.class);
                listKH = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listKH;
        }

    public CuaHang getOne(String id) {
        CuaHang value = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            value = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

        public Boolean add(CuaHang khacHang){
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

    public boolean update(CuaHang value) {
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

        public Boolean delete(CuaHang khacHang){
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
