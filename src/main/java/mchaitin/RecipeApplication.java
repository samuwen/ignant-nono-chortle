package mchaitin;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import mchaitin.health.TemplateHealthCheck;
import mchaitin.resources.RecipeResource;

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
        final RecipeResource recipeResource = new RecipeResource();
        final TemplateHealthCheck check = new TemplateHealthCheck(configuration.getRecipe());
        environment.healthChecks().register("template", check);
        environment.jersey().register(recipeResource);
    }

}
