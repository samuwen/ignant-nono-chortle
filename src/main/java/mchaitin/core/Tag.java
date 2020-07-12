package mchaitin.core;

import java.util.Objects;

public class Tag {
    private String text;
    private int ordinal;

    public Tag() {
    }

    public Tag(String text, int ordinal) {
        this.text = text;
        this.ordinal = ordinal;
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

    public Tag text(String text) {
        this.text = text;
        return this;
    }

    public Tag ordinal(int ordinal) {
        this.ordinal = ordinal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) o;
        return Objects.equals(text, tag.text) && ordinal == tag.ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, ordinal);
    }

    @Override
    public String toString() {
        return "{" + " text='" + getText() + "'" + ", ordinal='" + getOrdinal() + "'" + "}";
    }
}