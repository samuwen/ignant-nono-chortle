package mchaitin.resources;

import java.util.List;
import java.util.OptionalLong;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    // @UnitOfWork
    // public Recipe getRecipe(@PathParam("recipeId") OptionalLong recipeId) {
    // return this.recipeDAO.findById(recipeId.getAsLong())
    // .orElseThrow(() -> new NotFoundException("Recipe not found"));
    // }

    @POST
    @Timed
    @UnitOfWork
    public void createRecipe(@Valid Recipe recipe) {
        this.recipeDAO.create(recipe);
    }

    // @POST
    // @Timed
    // @UnitOfWork
    // public void newRecipe(@Valid Recipe recipe) {
    // log.error(recipe.toString());
    // this.recipes.add(recipe);
    // }
}