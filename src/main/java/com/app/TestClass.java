package com.app;


import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestClass {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		//activate the hibernate framework
			cfg=new Configuration().configure("hibernate.cfg.xml");
			//build the session factory
			sf=cfg.buildSessionFactory();
			//open/get the session
			ses=sf.openSession();
			//declare the page size means how many records display per page
			int page_size=5;
			//Enter the page number
			int page_no=1;
			//calculate the page number starting or first number
			int firstNumber=(page_no-1)*page_size;

			//create then sql query
			
			String sql="from Employee";
				Query q=ses.createQuery(sql);
				
				//set the first result
				q.setFirstResult(firstNumber);
				//set the page size
				q.setMaxResults(page_size);
				//q.addEntity(Employee.class);
				List<Employee> 	emplist=((org.hibernate.query.Query) q).list();

				System.out.println("\n\t\t******************************************");
				emplist.forEach(row->{
					System.out.println("\t"+row.getId()+"\t"+row.getName()+"\t"+row.getSal());

				});

			System.out.println("\n\t\t******************************************");
			System.out.println("\n\t\t***\t"+emplist.size()+" RECORDS DISPLAY ON PAGE ***");
			System.out.println("\n\t\t******************************************");

					//close the session factory and session
					ses.close();
					sf.close();
		
	}//main ends

}//class ends
