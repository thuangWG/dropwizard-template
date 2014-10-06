package com.amplify.micro;

import com.amplify.micro.core.UserWarning;
import com.amplify.micro.db.UserWarningDAO;
import com.amplify.micro.resources.HelloWorldResource;
import com.amplify.micro.resources.UserWarningResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/19/14
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    private final HibernateBundle<HelloWorldConfiguration> hibernateBundle =
        new HibernateBundle<HelloWorldConfiguration>(UserWarning.class) {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    public String getName() {
        return "hello-world";
    }
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> helloWorldConfigurationBootstrap) {
        helloWorldConfigurationBootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource  = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(),helloWorldConfiguration.getDefaultName());

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(helloWorldConfiguration.getTemplate());
        environment.healthChecks().register("templateStringCheck", healthCheck);
        environment.jersey().register(resource);

        final UserWarningDAO dao = new UserWarningDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new UserWarningResource(dao));

    }
}
