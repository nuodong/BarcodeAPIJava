package com.numob.api.barcode.user;

import java.io.Serializable;
import javax.persistence.*;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name = "no name";

    @Transient
    public String transientString;  // will not update this field in db.

    @JsonIgnore
    public String ignoreField;  // will not in the response Json.


    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters are hidden for brevity

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s']", id, name
        );
    }



}
