package com.numob.api.barcode.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.numob.api.barcode.user.User;
import com.numob.api.barcode.utils.StringToJsonAttributeConverter;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "teammember")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String identifier;

    @OneToOne
    public Team team;

    @ManyToOne
    public User member;

    @Column(nullable = false)
    public String member_name;

    @Column(nullable = false)
    public Date createTime = new Date();

    //added from 2.9
    public Integer role = 0;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    public JsonNode permissions;

    public TeamMember(String identifier, Team team, User member, String member_name) {
        this.identifier = identifier;
        this.team = team;
        this.member = member;
        this.member_name = member_name;
    }

    @Override
    public String toString() {
        return String.format(
                "TeamMember[id=%d, identifier=%s, team_id=%d, member_user_id=%d, member_name=%s]", id, identifier, team.id, member.id, member_name
        );
    }



}
