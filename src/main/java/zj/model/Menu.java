package zj.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2017/1/17.
 */
public class Menu extends ModelBase
{
    private int id;
    
    private String text;
    
    //"open" or "closed"
    private String state = "";
    
    //指示节点是否被选中
    private int checked;
    
    private Map<String, Object> attributes = new HashMap<>();
    
    private List<Menu> children = new ArrayList<>();
    
    public void toggleState()
    {
        if ("closed".equalsIgnoreCase(this.state))
        {
            this.state = "open";
        }
        else
        {
            this.state = "closed";
        }
    }
    
    public int getChecked()
    {
        return checked;
    }
    
    public void setChecked(int checked)
    {
        this.checked = checked;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
    public Map<String, Object> getAttributes()
    {
        return attributes;
    }
    
    public void setAttributes(Map<String, Object> attributes)
    {
        this.attributes = attributes;
    }
    
    public List<Menu> getChildren()
    {
        return children;
    }
    
    public void setChildren(List<Menu> children)
    {
        this.children = children;
    }
    
}
