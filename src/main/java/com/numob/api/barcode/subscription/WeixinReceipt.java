package com.numob.api.barcode.subscription;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "weixinreceipt")
public class WeixinReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 11, nullable = false)
    public Integer user_id;

    @Column(nullable = false, length = 64)
    public String identifier;

    @Column(nullable = false, length = 150)
    public String username;

    @Column(nullable = false, length = 50)
    public String product_id;

    @Column(nullable = false, length = 20)
    public String sn;

    @Column(nullable = false, length = 20)
    public String trade_state;


    @Column(length = 11, nullable = false)
    public Integer activate_date;

    @Column(length = 11, nullable = false)
    public Integer expires_date;

    @Column(nullable = false, length = 40)
    public String transaction_id;

    @Column(nullable = false, length = 20)
    public String trade_type;

    @Column(length = 11, nullable = false)
    public Integer total_fee;


    @Column(nullable = false, length = 20)
    public String bank_type;

    @Column(nullable = false, length = 20)
    public String cash_fee;

    @Column(nullable = false, length = 3)
    public String is_subscribe;

    @Column(columnDefinition="text")
    public String note = "";

    @Column(nullable = false)
    public Date createTime;

    @Column(nullable = false)
    public Date lastUpdate;


}
