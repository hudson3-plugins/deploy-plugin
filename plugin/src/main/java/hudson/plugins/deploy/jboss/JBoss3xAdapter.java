package hudson.plugins.deploy.jboss;

import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;
import org.codehaus.cargo.container.Container;
import org.codehaus.cargo.generic.ContainerFactory;
import org.codehaus.cargo.generic.configuration.ConfigurationFactory;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * JBoss 3.x.
 * 
 * @author Kohsuke Kawaguchi
 */
public class JBoss3xAdapter extends JBossAdapter {
    @DataBoundConstructor
    public JBoss3xAdapter(String url, String password, String userName) {
        super(url, password, userName);
    }

    public String getContainerId() {
        return "jboss3x";
    }

    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        public String getDisplayName() {
            return "JBoss 3.x";
        }
    }
    
    //For test
    @Override
    protected Container getContainer(ConfigurationFactory configFactory, ContainerFactory containerFactory, String id) {
        return super.getContainer(configFactory, containerFactory, id);
    }
}
