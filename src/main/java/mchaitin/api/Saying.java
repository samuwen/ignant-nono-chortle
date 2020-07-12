package mchaitin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
    private long id;

    private String content;

    public Saying() {
        // stub
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return this.id;
    }

    @JsonProperty
    public String getContent() {
        return this.content;
    }
}