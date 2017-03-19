package ccz.practise.xfire.spring.server.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by 46043 on 2016/8/8.
 */
public interface ExampleWS {
    public ExampleResponse getExample(ExampleRequest exampleRequest);
}
