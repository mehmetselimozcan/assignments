package assignments;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Operations {

    @WebMethod
    String createRecord(User user);

    @WebMethod
    void deleteRecord(String username);

    @WebMethod
    void updateRecord(User user);


}
