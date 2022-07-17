package src;

import java.io.Serializable;

public class ClientMessage implements Serializable {
    public String command;
    public Object obj;
    public int id;
    public String arg;
    public String[] commands;

    public ClientMessage(String [] commands){
        this.commands = commands;
    }

    public ClientMessage(String command, Object obj, String arg){
        this.command = command;
        this.obj = obj;
        this.arg = arg;
    }

    public ClientMessage(String command, Object obj, int id, String arg){
        this.command = command;
        this.arg = arg;
        this.obj = obj;
        this.id = id;
    }
}
