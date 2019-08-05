package Client;


import wsdl.DbOperationsService;
import wsdl.Operations;
import wsdl.User;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        DbOperationsService service = new DbOperationsService();
        Operations db =  service.getDbOperationsPort();
        User user = new User();
        user.setUsername("s");
        user.setPassword("s");
        user.setEmail("s");
        System.out.println(db.createRecord(user));
    }
}
