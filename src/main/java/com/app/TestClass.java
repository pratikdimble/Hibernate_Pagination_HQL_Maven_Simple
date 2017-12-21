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
			cfg=new Configuration().configure("com/app/hibernate.cfg.xml");
			//build the session factory
			sf=cfg.buildSessionFactory();
			//open/get the session
			ses=sf.openSession();
			//declare the page size means howmany records display per page
			int page_size=5;
			//Enter the page number
			int page_no=1;
			//calculate the page number starting or first number
			int firstNumber=(page_no-1)*page_size;
			int count=0;
		
/*			//create criteria object using session object
			Criteria c=ses.createCriteria(Employee.class);
				//set the first result
				c.setFirstResult(firstNumber);
					//set the page size
					c.setMaxResults(page_size);
					//send criteria object data to list of type(model class)
						List<Employee> 	emplist=c.list();
					for(Employee e:emplist)
						{
							System.out.println(e);
								count++;
						}
			System.out.println("\n\t\t******************************************");
			System.out.println("\n\t\t***\t"+count+" RECORDS DISPLAY ON PAGE ***");
			System.out.println("\n\t\t******************************************");
			
			*/
			
			
			//create then sql query
			
			String sql="from Employee";
				Query q=(Query) ses.createQuery(sql);
				
				//set the first result
				q.setFirstResult(firstNumber);
				//set the page size
				q.setMaxResults(page_size);
				//q.addEntity(Employee.class);
				List<Employee> 	emplist=((org.hibernate.Query) q).list();
/*				for(Employee e:emplist)
				{
					System.out.println(e);
					count++;
				}*/
				System.out.println("\n\t\t******************************************");
				emplist.forEach(row->{
					System.out.println("\t"+row.getId()+"\t"+row.getName()+"\t"+row.getSal());

				});
		/*		for(Employee e:emplist)
				{
					System.out.println(e);
					count++;
				}*/
/*				//set the first result
				q.setFirstResult(firstNumber);
				//set the page size
				q.setMaxResults(page_size);
					//q.addEntity(Employee.class);
		//execute the query
			emplist=q.list();
			System.out.println("\n\t\t******************************************");
			emplist.forEach(row->{
				System.out.println("\t"+row.getId()+"\t"+row.getName()+"\t"+row.getSal());

			});
			for(Employee e:emplist)
			{
				System.out.println(e);
				count++;
			}*/
			System.out.println("\n\t\t******************************************");
			System.out.println("\n\t\t***\t"+count+" RECORDS DISPLAY ON PAGE ***");
			System.out.println("\n\t\t******************************************");
			//display the data
			/*
			emplist.forEach(row->{
				System.out.println("\t"+row.getId()+"\t"+row.getName()+"\t"+row.getSal());
			});*/
		
					//close the session factory and session
					ses.close();
					sf.close();
		
	}//main ends

}//class ends
