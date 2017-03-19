package ccz.practise.jaxws.helloworld;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 46043 on 2016/8/2.
 */
public class InputMsg {
    private Integer inputId;
    private String inputMsg;

    public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
    }

    public String getInputMsg() {
        return inputMsg;
    }

    public void setInputMsg(String inputMsg) {
        this.inputMsg = inputMsg;
    }
}
