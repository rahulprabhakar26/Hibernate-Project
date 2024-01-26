package com.kodnest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kodnest.entity.Bike;
import com.kodnest.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure();

       SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tr = session.beginTransaction();
          Bike bike = new Bike("Harle",4.45);
          session.save(bike);
         Student s = new Student(1,"Rahul",bike);
         session.save(s);
        
       
//        
//        List<Student> list = session.createQuery("from Student where name ='Rahul'").list();
//        
//           for (Student student : list) {
//        	   System.out.println(student);
//			
//		}
//        
        
           
//        Student s = session.get(Student.class, 1);
//        System.out.println(s.getId()+"___"+s.getName());
//        System.out.println();
//        
//        System.out.println(s);
//        
//        Bike bike = session.get(Bike.class, "Harle");
//        System.out.println(bike.getName()+"___"+bike.getPrice());
//        System.out.println();
//        
//        System.out.println(bike); 
        
        
        tr.commit();
        session.close();
        factory.close();
        
   }
}
