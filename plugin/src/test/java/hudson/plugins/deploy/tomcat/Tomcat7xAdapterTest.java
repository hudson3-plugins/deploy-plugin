package hudson.plugins.deploy.tomcat;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.cargo.container.configuration.Configuration;
import org.codehaus.cargo.container.configuration.ConfigurationCapability;
import org.codehaus.cargo.container.configuration.ConfigurationType;
import org.codehaus.cargo.container.tomcat.Tomcat7xRemoteContainer;
import org.codehaus.cargo.container.tomcat.TomcatPropertySet;
import org.codehaus.cargo.util.log.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author soudmaijer
 */
public class Tomcat7xAdapterTest {

    private Tomcat7xAdapter adapter;
    private static final String url = "http://localhost:8080";
    private static final String username = "username";
    private static final String password = "password";

    @Before
    public void setup() {
        adapter = new  Tomcat7xAdapter(url, password, username);
    }

    @Test
    public void testContainerId() {
        Assert.assertEquals(adapter.getContainerId(), Tomcat7xRemoteContainer.ID);            
    }

    @Test
    public void testConfigure() {
        Assert.assertEquals(adapter.url,url);
        Assert.assertEquals(adapter.userName,username);
        Assert.assertEquals(adapter.password,password);
    }
    
    @Test
    public void testUrl() {
        Configuration configuration = new Configuration() {
            Map<String, String> properties = new HashMap<String, String>();
            public void setLogger(Logger arg0) {}
            public Logger getLogger() { return null; }
            public ConfigurationType getType() {return null;}
            public ConfigurationCapability getCapability() { return null; }
            
            public Map<String, String> getProperties() {
                return properties;
            }
            public void setProperty(String arg0, String arg1) {
                properties.put(arg0, arg1);
            }
            
            public String getPropertyValue(String arg0) {
                return properties.get(arg0);
            }
        };
        
        adapter.configure(configuration);
        Assert.assertEquals("http://localhost:8080/manager/text", configuration.getPropertyValue(TomcatPropertySet.MANAGER_URL));
    }
}
