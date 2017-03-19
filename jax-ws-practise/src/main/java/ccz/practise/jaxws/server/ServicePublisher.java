package ccz.practise.jaxws.server;

import ccz.practise.jaxws.helloworld.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by 46043 on 2016/8/2.
 */
public class ServicePublisher {
    public static void main(String[] args) {
        System.out.println("====正在启动Service服务器程序====");
        Endpoint.publish("http://localhost/service/helloWorld", new HelloWorldImpl());

        System.out.println("====Service服务器启动完成=====");
        System.out.println("可以通过地址 [http://localhost/service/helloWorld?wsdl]访问服务相关描述信息!");
    }
}
