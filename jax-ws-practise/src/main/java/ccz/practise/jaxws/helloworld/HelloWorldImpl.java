package ccz.practise.jaxws.helloworld;

import javax.jws.WebService;

/**
 * Created by 46043 on 2016/8/2.
 */
@WebService(endpointInterface = "ccz.practise.jaxws.helloworld.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    /**
     * 输入用户名称，返回对用户的问候。
     *
     */
    @Override
    public OutputMsg sayHello(InputMsg inputMsg){
        OutputMsg outputMsg = new OutputMsg();
        outputMsg.setOutputId(inputMsg.getInputId() + 1);
        outputMsg.setOutputMsg("input msg id is" + inputMsg.getInputId() + ", output msg id is" + outputMsg.getOutputId());
        return outputMsg;
    }

    @Override
    public String sayHello2(String inputMsg) {
        return "response" + inputMsg;
    }

}
