package com.numob.api.barcode.user;

import com.numob.api.barcode.utils.NUString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "userextension")
public class UserExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String identifier;

    public String avatar = "";

    @Lob
    public String note = "";
    public Integer maxDevices = 3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    public User user;

    public UserExtension() {
        this.identifier = NUString.UUID();
    }

    public UserExtension(User user) {
        this.identifier = NUString.UUID();
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
                "UserExtension[id=%d, user_id=%d, identifier=%s]", id, user.id, identifier
        );
    }

}
