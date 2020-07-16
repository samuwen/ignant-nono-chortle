package mchaitin.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.hibernate.UnitOfWork;
import mchaitin.core.Recipe;
import mchaitin.db.RecipeDAO;

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {
    private RecipeDAO recipeDAO;

    private Logger log = LoggerFactory.getLogger(RecipeResource.class);

    public RecipeResource(RecipeDAO dao) {
        this.recipeDAO = dao;
    }

    @GET
    @Timed
    @UnitOfWork
    public List<Recipe> getRecipes() {
        return this.recipeDAO.findAll();
    }

    // @GET
    // @Path("{recipeId}")
    // @Timed
    // public Recipe getRecipe(@PathParam("recipeId") OptionalLong recipeId) {
    // return this.recipes.get((int) recipeId.getAsLong());
    // }

    // @POST
    // @Timed
    // @UnitOfWork
    // public void newRecipe(@Valid Recipe recipe) {
    // log.error(recipe.toString());
    // this.recipes.add(recipe);
    // }
}