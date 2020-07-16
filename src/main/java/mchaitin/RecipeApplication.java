package mchaitin;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import mchaitin.core.Recipe;
import mchaitin.db.RecipeDAO;
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
    public void initialize(Bootstrap<RecipeConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    private HibernateBundle<RecipeConfiguration> hibernate = new HibernateBundle<RecipeConfiguration>(Recipe.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(RecipeConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void run(final RecipeConfiguration configuration, final Environment environment) {
        RecipeDAO dao = new RecipeDAO(hibernate.getSessionFactory());
        final RecipeResource recipeResource = new RecipeResource(dao);
        // final TemplateHealthCheck check = new
        // TemplateHealthCheck(configuration.getRecipe());

        // environment.healthChecks().register("template", check);
        environment.jersey().register(recipeResource);
    }
}
