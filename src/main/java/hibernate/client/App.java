package hibernate.client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

import hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
//		Employee e = new Employee();
//		Employee v = new Employee();
//		e.setId(1);
//		e.setName("kishan Kumar");
//		e.setGender("male");
//		e.setSalary(22000);
//		
//		v.setId(2);
//		v.setName("shyam");
//		v.setGender("male");
//		v.setSalary(2500000);
		
//		Configuration cfg = new Configuration().configure();
//		SessionFactory sf = cfg.buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.buildSessionFactory();		
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("--Start----");
		
//		Example of HQL to get all the records
		Query query1 =session.createQuery("from Employee");
		List list=query1.list();
		System.out.println(list);
		Query q=session.createQuery("select max(name) from Employee");  
		List<Integer> list1=q.list();  
		System.out.println(list1.get(0));  
		
//		HQL to get records with pagination
		Query query2=session.createQuery("from Employee");  
		query2.setFirstResult(5);  
		query2.setMaxResults(5);  
		List list2=query2.list();//will return the records from 5 to 10th number  
		System.out.println("5 to 10: "+list2);
		
//		HQL update query Using Named Parameters
//		Query q=session.createQuery("update Employee set name=:n where id=:i");  
//		q.setParameter("n","Udit kumar");  
//		q.setParameter("i",1);  
//		System.out.println("status: "+q.executeUpdate());  
//
////		HQL delete query
//		Query query=session.createQuery("delete from Employee where id= 20");  
//		query.executeUpdate();  
//		
//		Query query1=session.createQuery("from Employee");
//		List list=query1.list();  
//		System.out.println(list);
		
		
//		session.save(e);
//		session.save(v);
//		System.out.println(e);
//		System.out.println(v);
		
		
		tx.commit();
		session.close();
		sf.close();
		
//		System.out.println("main_method");
		}

}
