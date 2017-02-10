package zj.ui;

import zj.model.ModelBase;

/**
 * 请求响应
 * Created by lzj on 2017/2/10.
 */
public class ResponseResult extends ModelBase
{
    
    private int status;
    
    private String msg;
    
    private Object obj;
    
    public ResponseResult(int status, String msg)
    {
        this.status = status;
        this.msg = msg;
    }
    
    public static ResponseResult fail(String msg)
    {
        return new ResponseResult(0, msg);
    }
    
    public static ResponseResult success(String msg)
    {
        return new ResponseResult(1, msg);
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
}
