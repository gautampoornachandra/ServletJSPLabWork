package DemoProgram;

import org.hibernate.Session;

import com.hibernate.HibernateUtilities;
import com.model.User;

public class Program {
	public static void main(String[] args){
		System.out.println("Hellow World");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.close();
		
		User user = new User();
		user.setId("1");
		user.setName("Gautam");
		user.setPassword("admin");
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
