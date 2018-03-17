package app.kotlin.com.newproject;

/**
 * Created by DELL on 3/17/2018.
 */

public class Message {
    private String uid;
    private String uname;
    private String msg;

    public Message(){

    }

    public Message(String uid, String uname, String msg) {
        this.uid = uid;
        this.uname = uname;
        this.msg = msg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
