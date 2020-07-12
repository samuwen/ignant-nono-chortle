package mchaitin;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import mchaitin.health.TemplateHealthCheck;
import mchaitin.resources.HelloWorldResource;

public class RecipeApplication extends Application<RecipeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RecipeApplication().run(args);
    }

    @Override
    public String getName() {
        return "RecipeApplication";
    }

    @Override
    public void initialize(final Bootstrap<RecipeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RecipeConfiguration configuration, final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
                configuration.getDefaultName());
        final TemplateHealthCheck check = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", check);
        environment.jersey().register(resource);
    }

}
