package mchaitin.health;

import com.codahale.metrics.health.HealthCheck;

import mchaitin.core.Recipe;

public class TemplateHealthCheck extends HealthCheck {
    private final Recipe recipe;

    public TemplateHealthCheck(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    protected Result check() throws Exception {
        // TODO: Make this not suck
        if (this.recipe.getName().isEmpty()) {
            return Result.unhealthy("No name found for recipe");
        }
        return Result.healthy();
    }
}