package assignments;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Endpoint ep = Endpoint.create(new DbOperations());
        ep.publish("http://127.0.0.1:10000/calcServer");
    }

}
