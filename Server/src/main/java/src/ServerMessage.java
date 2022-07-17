package src;

import java.io.Serializable;

public class ServerMessage implements Serializable {
    public String message;

    public ServerMessage(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void plusMessage(String message){
        this.message += message;
    }
}
