package mchaitin.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "step")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "ordinal")
    private int ordinal;

    @Column(name = "recipe_id", nullable = false)
    private int recipeId;

    public Step() {
    }

    public Step(int id, String text, int ordinal, int recipeId) {
        this.id = id;
        this.text = text;
        this.ordinal = ordinal;
        this.recipeId = recipeId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public Step id(int id) {
        this.id = id;
        return this;
    }

    public Step text(String text) {
        this.text = text;
        return this;
    }

    public Step ordinal(int ordinal) {
        this.ordinal = ordinal;
        return this;
    }

    public Step recipeId(int recipeId) {
        this.recipeId = recipeId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Step)) {
            return false;
        }
        Step step = (Step) o;
        return id == step.id && Objects.equals(text, step.text) && ordinal == step.ordinal && recipeId == step.recipeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, ordinal, recipeId);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", text='" + getText() + "'" + ", ordinal='" + getOrdinal() + "'"
                + ", recipeId='" + getRecipeId() + "'" + "}";
    }
}