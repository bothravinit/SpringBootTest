package hello;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author vinit.bothra
 * @since 4/18/14.
 */
@XmlRootElement(name = "person")
public class CurrencyAPIUpsertResponse1 {

    private int status;

    private List<String> messages;

    @XmlElement
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlElement
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
