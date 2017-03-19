package ccz.practise.jaxws.helloworld;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 46043 on 2016/8/2.
 */
public class OutputMsg {
    private Integer outputId;
    private String outputMsg;

    public Integer getOutputId() {
        return outputId;
    }

    public void setOutputId(Integer outputId) {
        this.outputId = outputId;
    }

    public String getOutputMsg() {
        return outputMsg;
    }

    public void setOutputMsg(String outputMsg) {
        this.outputMsg = outputMsg;
    }
}
