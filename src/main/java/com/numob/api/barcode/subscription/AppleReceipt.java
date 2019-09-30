package com.numob.api.barcode.subscription;

import com.numob.api.barcode.team.Team;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "applereceipt")
public class AppleReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 100 ,nullable = false)
    public String original_transaction_id;

    @Column(length = 11 ,nullable = false)
    public Integer original_purchase_date;

    @Lob
    public String latest_receipt;

    @Column(length = 11 ,nullable = false)
    public Integer latest_expires_date;

    @Column(length = 100 ,nullable = false)
    public String latest_product_id;

    @Column(length = 100 ,nullable = false)
    public Date createTime;

    @Column(length = 100 ,nullable = false)
    public Date lastUpdate;

    @Lob
    public String note = "";

    @Column(length = 11)
    public Integer user_id;

}
