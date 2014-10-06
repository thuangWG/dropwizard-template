package com.amplify.micro.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/22/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@NamedNativeQuery(name="findUserWarningByBKSql",
        query="SELECT u.comment " +
                "FROM user_warning u " +
                "WHERE u.user_business_key = :businessKey")
@Table(name = "user_warning")
public class UserWarning {
    @Id
    private long id;
    private String comment;
    private String date_Created;
    private String last_Updated;
    private boolean displayed;
    private String key;
    private String reason;
    private int reason_Code;
    private String user_Business_Key;

    public UserWarning() {

    }

    public UserWarning(long id, String comment, String date_Created, String reason, int reason_Code, String user_Business_Key) {
        this.id = id;
        this.comment = comment;
        this.date_Created = date_Created;
        this.reason = reason;
        this.reason_Code = reason_Code;
        this.user_Business_Key = user_Business_Key;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    @JsonProperty
    public String getDate_Created() {
        return date_Created;
    }

    @JsonProperty
    public String getLast_Updated() {
        return last_Updated;
    }

    @JsonProperty
    public boolean isDisplayed() {
        return displayed;
    }

    @JsonProperty
    public String getKey() {
        return key;
    }

    @JsonProperty
    public String getReason() {
        return reason;
    }

    @JsonProperty
    public int getReason_Code() {
        return reason_Code;
    }

    @JsonProperty
    public String getUser_Business_Key() {
        return user_Business_Key;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("user_Business_Key", user_Business_Key)
                .add("comment", comment)
                .toString();
    }
}
