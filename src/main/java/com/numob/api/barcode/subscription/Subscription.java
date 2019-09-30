package com.numob.api.barcode.subscription;

import javax.persistence.Entity;

public class Subscription {
    String product_id;
    String product_name;
    Long expires_date;  //seconds since 1970
    String username;
    String user_identifier;
    String channel;
    String identifier;
}


