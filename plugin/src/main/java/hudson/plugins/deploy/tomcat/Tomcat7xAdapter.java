package hudson.plugins.deploy.tomcat;

import java.net.MalformedURLException;
import java.net.URL;
import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;
import org.codehaus.cargo.container.configuration.Configuration;
import org.codehaus.cargo.container.tomcat.TomcatPropertySet;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Tomcat 7.x
 *
 * @author soudmaijer
 */
public class Tomcat7xAdapter extends TomcatAdapter {

    /**
     * Tomcat 7 support
     * 
     * @param url Tomcat server location (for example: http://localhost:8080)
     * @param password tomcat manager password
     * @param userName tomcat manager username
     */
    @DataBoundConstructor
    public Tomcat7xAdapter(String url, String password, String userName) {
        super(url, password, userName);
    }

    /**
     * Tomcat Cargo containerId
     * @return tomcat7x
     */
    public String getContainerId() {
        return "tomcat7x";
    }
    
    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        public String getDisplayName() {
            return "Tomcat 7.x";
        }
    }
    
    @Override
    public void configure(Configuration config)
    {
        super.configure(config);
        try {
            URL _url = new URL(url + "/manager/text");
            config.setProperty(TomcatPropertySet.MANAGER_URL,_url.toExternalForm());
        } catch (MalformedURLException e) {
            throw new AssertionError(e);
        }
    }
}

