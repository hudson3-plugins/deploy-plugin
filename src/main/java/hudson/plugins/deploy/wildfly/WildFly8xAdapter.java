package hudson.plugins.deploy.wildfly;

import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;
import hudson.plugins.deploy.jboss.JBossAdapter;

import org.codehaus.cargo.container.Container;
import org.codehaus.cargo.container.jboss.JBossPropertySet;
import org.codehaus.cargo.generic.ContainerFactory;
import org.codehaus.cargo.generic.configuration.ConfigurationFactory;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Cargo Container Adapter for WildFly 8.x remote deployment
 * 
 * @author Steven Christou
 * @author Kaz Nishimura
 */
public class WildFly8xAdapter extends JBossAdapter {

    @Property(JBossPropertySet.JBOSS_MANAGEMENT_HTTP_PORT)
    public final Integer managementPort;
    
    @DataBoundConstructor
    public WildFly8xAdapter(String url, String password, String userName, Integer managementPort) {
        super(url, password, userName);
        this.managementPort = managementPort;
    }

    @Override
    public String getContainerId() {
        return "wildfly8x";
    }


    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        public String getDisplayName() {
            return "WildFly 8.x";
        }
    }
    //For testing
    @Override
    protected Container getContainer(ConfigurationFactory configFactory, ContainerFactory containerFactory, String id) {
        return super.getContainer(configFactory, containerFactory, id);
    }
}
