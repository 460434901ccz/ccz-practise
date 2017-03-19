package ccz.practise.xfire.spring.server.example;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by 46043 on 2016/7/20.
 */
public class Example {
    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}