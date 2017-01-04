package moana;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.datanucleus.Transaction;
import org.datanucleus.api.jpa.JPAEntityTransaction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.*;
import junit.framework.TestListener;
import lab.io.rush.model.MovieTicket;
import lab.io.rush.service.MovieTicketService;
import lab.io.rush.service.mailUtil;

public class jpaTest {

/*
	@Test
	public  void testJpa() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager em = emf.createEntityManager();
		JPAEntityTransaction tx =   (JPAEntityTransaction) em.getTransaction();
		try
		{
		    tx.begin();

		    MovieTicket inv = new MovieTicket();
		    inv.setMovie_id(2);inv.setName("长城");inv.setNumber(300);inv.setCreateTime(new Date());
		    	inv.setEndTime(new Date());inv.setStartTime(new Date());
		    em.persist(inv);

		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		    em.close();
		}
	}*/
	@Test
	public void TestList(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
		 MovieTicketService movieTicketService = (MovieTicketService) applicationContext.getBean("movieTicketService");
		 List<MovieTicket> mList=movieTicketService.getAllMovieTicket();
		 Iterator iterator =mList.iterator();
		 while(iterator.hasNext()){
			 MovieTicket mTicket=(MovieTicket) iterator.next();
			 String string=mTicket.toString();
			 System.out.println(string);
		 }
		 MovieTicket mTicket = new MovieTicket();
		 
		 mTicket.setName("长城");
		 mTicket.setNumber(200);
		 mTicket.setCreateTime(new Date());
		 mTicket.setStartTime(new Date());
		 mTicket.setEndTime(new Date());
		 movieTicketService.addMovieTicket(mTicket);
	}
			@Test
    public void sendMassTest(){    
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
				 mailUtil mailUtil = (mailUtil) applicationContext.getBean("mailUtil");
        mailUtil.send("362254546@qq.com", "demo test!!!", "Hello Mass!");  
    }  
}
