package hibernate.client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee();
		Employee v = new Employee();
		e.setId(1);
		e.setName("kishan Kumar");
		e.setGender("male");
		e.setSalary(22000);
		
		v.setId(2);
		v.setName("shyam");
		v.setGender("male");
		v.setSalary(2500000);
		
//		Configuration cfg = new Configuration().configure();
//		SessionFactory sf = cfg.buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.buildSessionFactory();		
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(e);
		session.save(v);
//		System.out.println(e);
//		System.out.println(v);
		
		
		tx.commit();
		
//		System.out.println("main_method");
		}

}
