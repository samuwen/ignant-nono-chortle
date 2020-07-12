package mchaitin;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RecipeApplicationApplication extends Application<RecipeApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RecipeApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "RecipeApplication";
    }

    @Override
    public void initialize(final Bootstrap<RecipeApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RecipeApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
