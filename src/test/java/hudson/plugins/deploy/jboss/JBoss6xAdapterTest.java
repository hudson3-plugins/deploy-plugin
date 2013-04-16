package hudson.plugins.deploy.jboss;

import hudson.plugins.deploy.glassfish.*;
import hudson.FilePath;
import hudson.model.StreamBuildListener;
import org.codehaus.cargo.container.Container;
import org.codehaus.cargo.container.glassfish.GlassFish3xInstalledLocalContainer;
import org.codehaus.cargo.generic.ContainerFactory;
import org.codehaus.cargo.generic.DefaultContainerFactory;
import org.codehaus.cargo.generic.configuration.ConfigurationFactory;
import org.codehaus.cargo.generic.configuration.DefaultConfigurationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author soudmaijer
 */
public class JBoss6xAdapterTest {

    private JBoss6xAdapter adapter;
    private static final String home = "http://localhost:8180";
    private static final String username = "username";
    private static final String password = "password";
    private static int rmiPort = 1199;

    @Before
    public void setup() {
        adapter = new JBoss6xAdapter(home, password, username, rmiPort);
    }

    @Test
    public void testContainerId() {
        Assert.assertEquals(adapter.getContainerId(), "jboss6x");
    }

    @Test
    public void testConfigure() {
         
        Assert.assertEquals(adapter.userName, username);
        Assert.assertEquals(adapter.getPassword(), password);

        ConfigurationFactory configFactory = new DefaultConfigurationFactory();
        ContainerFactory containerFactory = new DefaultContainerFactory();

        Container container = adapter.getContainer(configFactory, containerFactory, adapter.getContainerId());
        Assert.assertNotNull(container);
    }
    
    //@Test
    public void testDeploy() throws IOException, InterruptedException {
        //adapter.redeploy(new FilePath(new File("/Users/winstonp/hudson/github/hudson-test/target/HudsonTest-1.0-SNAPSHOT.war")), null, null, new StreamBuildListener(System.out));
    }

}
