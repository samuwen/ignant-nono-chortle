package mchaitin;

import io.dropwizard.Configuration;
import mchaitin.core.Recipe;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeConfiguration extends Configuration {
    private Recipe recipe;

    @JsonProperty
    public Recipe getRecipe() {
        return this.recipe;
    }

    @JsonProperty
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
