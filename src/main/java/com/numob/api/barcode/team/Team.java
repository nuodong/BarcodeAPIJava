package com.numob.api.barcode.team;

import com.numob.api.barcode.user.User;
import javax.persistence.*;

@Entity(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    public User user;

    @Column(nullable = false)
    public String identifier;

    @Column(nullable = false)
    public String name;

    public String avatar = "";

    @Lob
    public String note = "";

    public Team(String identifier, User user, String name) {
        this.identifier = identifier;
        this.user = user;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Team[id=%d, identifier=%s, name=%s]", id, identifier, name
        );
    }
}
