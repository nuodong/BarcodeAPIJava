package com.numob.api.barcode.user;

import javax.persistence.*;

@Entity(name = "userextension")
public class UserExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    public User user;

    @Column(nullable = false)
    public String identifier;

    public String avatar = "";

    @Lob
    public String note = "";
    public Integer maxDevices = 3;

}
