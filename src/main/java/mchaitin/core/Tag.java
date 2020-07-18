package mchaitin.core;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue
    private UUID id;

    private String text;
    private int ordinal;

    public Tag() {
    }

    public Tag(UUID id, String text, int ordinal) {
        this.id = id;
        this.text = text;
        this.ordinal = ordinal;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
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

    public Tag id(UUID id) {
        this.id = id;
        return this;
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
        return Objects.equals(id, tag.id) && Objects.equals(text, tag.text) && ordinal == tag.ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, ordinal);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", text='" + getText() + "'" + ", ordinal='" + getOrdinal() + "'" + "}";
    }
}