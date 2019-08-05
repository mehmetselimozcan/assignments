package assignments;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.apache.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "assignments.Operations")
public class DbOperations implements Operations{


    public final static Logger logger = Logger.getLogger(DbOperations.class);

    // Method Used To Create The Hibernate's SessionFactory Object
    public static SessionFactory getSessionFactory() {


        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(assignments.User.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return factoryObj;
    }

    // Method 1: This Method Used To Create A New User Record In The Database Table
    @Override
    public String createRecord(User user) {
        Session sessionObj = getSessionFactory().openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(user);

        // Transaction Is Committed To Database
        transObj.commit();

        // Closing The Session Object
        sessionObj.close();
        logger.info("Successfully Created " + user.toString());
        return user.getUsername();
    }

    // Method 2: This Method Is Used To Display The Records From The Database Tabl
    public List<User> displayRecords() {
        Session sessionObj = getSessionFactory().openSession();
        List<User> studentsList = sessionObj.createQuery("FROM User").list();

        // Closing The Session Object
        sessionObj.close();
        logger.info("User Records Available In Database Are?= " + studentsList.size());
        return studentsList;
    }

    // Method 3: This Method Is Used To Update A Record In The Database Table
    @Override
    public void updateRecord(User user) {
        Session sessionObj = getSessionFactory().openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();
        User user2 = (User) sessionObj.load(User.class, user.getUsername());
        user2.setUsername(user.getUsername());
        user2.setSex(user.getSex());

        // Transaction Is Committed To Database
        transObj.commit();

        // Closing The Session Object
        sessionObj.close();
        logger.info("User Record Is Successfully Updated!= " + user2.toString());
    }

    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    @Override
    public void deleteRecord(String username) {
        Session sessionObj = getSessionFactory().openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();
        User user = findRecordByUsername(username);
        sessionObj.delete(user);

        // Transaction Is Committed To Database
        transObj.commit();

        // Closing The Session Object
        sessionObj.close();
        logger.info("Successfully Record Is Successfully Deleted!=  " + user.toString());

    }

    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static User findRecordByUsername(String username) {
        Session sessionObj = getSessionFactory().openSession();
        User user = (User) sessionObj.load(User.class, username);

        // Closing The Session Object
        sessionObj.close();
        return user;
    }

    // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void deleteAllRecords() {
        Session sessionObj = getSessionFactory().openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();
        Query queryObj = sessionObj.createQuery("DELETE FROM User");

        queryObj.executeUpdate();

        // Transaction Is Committed To Database
        transObj.commit();

        // Closing The Session Object
        sessionObj.close();
        logger.info("Successfully Deleted All Records From The Database Table!");
    }
}