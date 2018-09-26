package com.hqlupdatedelete;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLUpdateDelete {
	public static void main(String[] args)
	{
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	 
	        SessionFactory factory = cfg.buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Employee e1=new Employee();
	        Employee e2=new Employee();
	        Employee e3=new Employee();
	        
	        
	      /*  e2.setId(101);
	        e2.setFirstName("Sheeja");
	        e2.setLastName("Santosh");
	        e2.setSalary(1300);
	        
	        e3.setId(102);
	        e3.setFirstName("Santosh");
	        e3.setLastName("Kumar");
	        e3.setSalary(1400);
	        
	        
	        session.save(e2);
	        session.save(e3); */
	 
//-----------------> Get All Employees
	     /* String hql = "FROM Employee";
	        Query query = session.createQuery("FROM Employee");
	        List<Employee> list = (List<Employee>) query.list();
	        for (Employee emp1 : list) 
	        {
	            System.out.println(emp1);
	        }*/
//------------> Get Employee with id
	       
	     /*  Query query = session.createQuery("from Employee where id= :id");
	        query.setLong("id", 102);
	      Employee emp2 = (Employee) query.uniqueResult();
	        System.out.println(emp2); */
	        
	    /*  String hql = "FROM Employee WHERE id = 101";
	        Query query = session.createQuery(hql);
	       //List emp3 = query.list();
	       Employee emp3 = (Employee) query.uniqueResult();
	      System.out.println(emp3); */
	        
	        String hql="UPDATE Employee set salary=:salary " + " WHERE id=:id";
	        Query query=session.createQuery(hql);
	        query.setParameter("id", 100);
	        query.setParameter("salary",1500);
	        int result=query.executeUpdate();
	       
	        System.out.println("Rows affected"+ result); 
	        
	        
	        String hl="DELETE from Employee"+" WHERE id=: id";
	        Query q=session.createQuery(hl);
	        q.setParameter("id", 102);
	        int res=q.executeUpdate();
	        System.out.println("Rows affected"+ res);
	        
	        
	        tx.commit();
	        session.close();
	        factory.close();

	}

}


