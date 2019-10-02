package com.numob.api.barcode.team;

import com.numob.api.barcode.user.User;
import com.numob.api.barcode.utils.NUString;

import javax.persistence.*;

@Entity(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "user_id", nullable = false)
    public Integer userId;

    @Column(nullable = false)
    public String identifier;

    @Column(nullable = false)
    public String name;

    public String avatar = "";

    @Lob
    public String note = "";

    public Team(){
        this.identifier = NUString.UUID();
    }

    public Team(Integer userId, String name) {
        this.identifier = NUString.UUID();
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Team[id=%d, identifier=%s, name=%s]", id, identifier, name
        );
    }
}
