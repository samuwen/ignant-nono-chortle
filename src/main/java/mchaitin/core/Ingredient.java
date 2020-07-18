package mchaitin.core;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @Column(name = "unit")
    private String unit;

    public Ingredient() {
    }

    public Ingredient(UUID id, String name, int amount, String unit) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Ingredient id(UUID id) {
        this.id = id;
        return this;
    }

    public Ingredient name(String name) {
        this.name = name;
        return this;
    }

    public Ingredient amount(int amount) {
        this.amount = amount;
        return this;
    }

    public Ingredient unit(String unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ingredient)) {
            return false;
        }
        Ingredient ingredient = (Ingredient) o;
        return Objects.equals(id, ingredient.id) && Objects.equals(name, ingredient.name) && amount == ingredient.amount
                && Objects.equals(unit, ingredient.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, unit);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", amount='" + getAmount() + "'"
                + ", unit='" + getUnit() + "'" + "}";
    }
}