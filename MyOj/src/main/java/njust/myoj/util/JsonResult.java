package njust.myoj.util;

public class JsonResult {
    private Object obj;
    private String msg;
    private Integer code;

    public Object getObj(){return obj;}
    public String getMsg(){return msg;}
    public Integer getCode(){return code;}
    public void setObj(Object obj){this.obj=obj;}
    public void setMsg(String msg){this.msg=msg;}
    public void setCode(Integer code){this.code=code;}

}
