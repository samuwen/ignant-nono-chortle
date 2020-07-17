package mchaitin.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import io.dropwizard.hibernate.AbstractDAO;
import mchaitin.core.Recipe;

public class RecipeDAO extends AbstractDAO<Recipe> {
    public RecipeDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Recipe> findAll() {
        return list((Query<Recipe>) namedQuery("recipe.findAll"));
    }

    public Optional<Recipe> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public Recipe create(Recipe recipe) {
        return persist(recipe);
    }
}
