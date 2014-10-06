package com.amplify.micro.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/19/14
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {

    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
