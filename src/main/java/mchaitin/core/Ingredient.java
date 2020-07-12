package mchaitin.core;

import java.util.Objects;

public class Ingredient {
    private String name;
    private int amount;
    private String unit;

    public Ingredient() {
    }

    public Ingredient(String name, int amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
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
        return Objects.equals(name, ingredient.name) && amount == ingredient.amount
                && Objects.equals(unit, ingredient.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, unit);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", amount='" + getAmount() + "'" + ", unit='" + getUnit() + "'"
                + "}";
    }
}