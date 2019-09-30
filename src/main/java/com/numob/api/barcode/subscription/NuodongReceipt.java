package com.numob.api.barcode.subscription;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "nuodongreceipt")
public class NuodongReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false, length = 64)
    public String identifier;

    @Column(nullable = false, length = 150)
    public String username;

    @Column(nullable = false, length = 50)
    public String product_id;

    @Column(nullable = false, length = 20)
    public String sn;

    @Column(length = 11, nullable = false)
    public Integer activate_date;

    @Column(length = 11, nullable = false)
    public Integer expires_date;

    @Column(nullable = false)
    public Date createTime;

    @Column(nullable = false)
    public Date lastUpdate;

    @Column(columnDefinition="text")
    public String note = "";

}
