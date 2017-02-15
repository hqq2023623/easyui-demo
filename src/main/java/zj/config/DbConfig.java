package zj.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lzj on 2017/2/15.
 */
@Configuration
@ConfigurationProperties(prefix = "db")
public class DbConfig
{
    
    private String username;
    
    private String passwd;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPasswd()
    {
        return passwd;
    }
    
    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }
}
