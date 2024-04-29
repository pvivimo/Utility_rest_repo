package pv.sb_utilities_rest.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RestController;

import pv.sb_utilities_rest.model.Utility;

@RestController
public class Database {
	
	private SessionFactory sessionFactory;
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
	}

	public Utility getUtilityById(int utilityId) {
		
		Utility utility = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		utility = session.get(Utility.class, utilityId);
		
		tx.commit();
		session.close();
		
		return utility;
	}

}
