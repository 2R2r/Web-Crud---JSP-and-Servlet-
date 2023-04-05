package com.fpt.poly.lab.util;

import com.fpt.poly.lab.entity.ChiTietSP;
import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.entity.NhanVien;
import com.fpt.poly.lab.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);

        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(SanPham.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}