package mchaitin.core;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "Recipes")
public class Recipe {
    // TODO: Add db interactions

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Column(name = "name", nullable = false)
    private String name;

    // @Column(name = "description")
    @Nullable
    private String description;

    private List<String> steps;

    private List<Ingredient> ingredients;

    // TODO: Figure out images
    // private Something image;

    private List<Tag> tags;

    public Recipe() {
    }

    public Recipe(long id, String name, String description, List<String> steps, List<Ingredient> ingredients,
            List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.ingredients = ingredients;
        this.tags = tags;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Recipe id(long id) {
        this.id = id;
        return this;
    }

    public Recipe name(String name) {
        this.name = name;
        return this;
    }

    public Recipe description(String description) {
        this.description = description;
        return this;
    }

    public Recipe steps(List<String> steps) {
        this.steps = steps;
        return this;
    }

    public Recipe ingredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public Recipe tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description)
                && Objects.equals(steps, recipe.steps) && Objects.equals(ingredients, recipe.ingredients)
                && Objects.equals(tags, recipe.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, steps, ingredients, tags);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'"
                + ", steps='" + getSteps() + "'" + ", ingredients='" + getIngredients() + "'" + ", tags='" + getTags()
                + "'" + "}";
    }

}