package mchaitin.db;

import java.util.List;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import mchaitin.core.Recipe;

public class RecipeDAO extends AbstractDAO<Recipe> {
    public RecipeDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Recipe> findAll() {
        return (List<Recipe>) namedQuery("recipe.findAll").list();
    }
}
