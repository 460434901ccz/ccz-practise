package ccz.practise.xfire.spring.server.example;

import javax.xml.bind.annotation.*;

/**
 * Created by 46043 on 2016/8/8.
 */

public class ExampleRequest {
    private int id;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
