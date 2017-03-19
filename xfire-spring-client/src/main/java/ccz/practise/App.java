package ccz.practise;

import ccz.practise.xfire.spring.server.example.ExampleRequest;
import ccz.practise.xfire.spring.server.example.ExampleResponse;
import ccz.practise.xfire.spring.server.example.ExampleWSPortType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ExampleWSPortType exampleWSPortType = (ExampleWSPortType) ctx.getBean("exampleWS");

        final ExampleRequest in0 = new ExampleRequest();
        in0.setId(1);

        in0.setMsg("aa");
        ExampleResponse exampleResponse = exampleWSPortType.getExample(in0);
        System.out.println(exampleResponse.getResponseMsg());
    }
}
