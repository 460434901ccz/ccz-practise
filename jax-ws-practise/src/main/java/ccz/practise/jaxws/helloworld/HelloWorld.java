package ccz.practise.jaxws.helloworld;

import javax.jws.WebService;

/**
 * Created by 46043 on 2016/8/2.
 */
@WebService
public interface HelloWorld {
    /**
     * 输入用户名称，返回对用户的问候。
     *
     */
    public OutputMsg sayHello(InputMsg inputMsg);

    public String sayHello2(String inputMsg);

}
