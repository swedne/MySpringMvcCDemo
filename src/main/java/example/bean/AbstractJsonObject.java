package example.bean;

import java.util.Date;

public class AbstractJsonObject {
    //code
    private int code;
    //msg
    private String msg;

    private Long time = new Date().getTime();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setContent(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setStatusObject(StatusObject statusObject) {
        this.code = statusObject.getCode();
        this.msg = statusObject.getMsg();
    }
}