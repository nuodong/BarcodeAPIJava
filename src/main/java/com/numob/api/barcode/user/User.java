package com.numob.api.barcode.user;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "auth_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String password="";
    public Date last_login;


    public Boolean is_superuser = false;

    @Column(nullable = false)
    public String username;

    @JsonProperty(value = "name")
    @Column(name = "first_name", nullable = false)
    public String first_name;

    public String last_name = "";
    public String email = "";

    public Boolean is_active = true;

    @Column(nullable = false)
    public Date date_joined;

    public User(String username, String first_name, Date date_joined) {
        this.username = username;
        this.first_name = first_name;
        this.date_joined = date_joined;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username=%s, first_name=%s]", id, username, first_name
        );
    }

}
