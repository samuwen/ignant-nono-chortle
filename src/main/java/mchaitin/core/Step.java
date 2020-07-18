package mchaitin.core;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "step")
public class Step {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "ordinal")
    private int ordinal;

    public Step() {
    }

    public Step(UUID id, String text, int ordinal) {
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

    public Step id(UUID id) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Step)) {
            return false;
        }
        Step step = (Step) o;
        return Objects.equals(id, step.id) && Objects.equals(text, step.text) && ordinal == step.ordinal;
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