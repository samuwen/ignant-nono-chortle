package mchaitin.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.hibernate.UnitOfWork;
import mchaitin.core.Ingredient;
import mchaitin.core.Recipe;
import mchaitin.core.Tag;

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {
    private List<Recipe> recipes;
    Logger log = LoggerFactory.getLogger(RecipeResource.class);

    public RecipeResource() {
        Ingredient i = new Ingredient().name("Spaghetti").amount(1).unit("lb");
        Recipe r = new Recipe().name("pasta").id(0).ingredients(Arrays.asList(i))
                .steps(Arrays.asList("Boil water", "Cook pasta")).tags(Arrays.asList(new Tag("Entree", 0)));
        this.recipes = new ArrayList<>();
        this.recipes.add(r);
    }

    @GET
    @Timed
    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    @GET
    @Path("{recipeId}")
    @Timed
    public Recipe getRecipe(@PathParam("recipeId") OptionalLong recipeId) {
        return this.recipes.get((int) recipeId.getAsLong());
    }

    @POST
    @Timed
    @UnitOfWork
    public void newRecipe(@Valid Recipe recipe) {
        log.error(recipe.toString());
        this.recipes.add(recipe);
    }
}