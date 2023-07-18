package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int uid;
    private  int addressId;
    private Date orderDate;
    private String orderStatus;
}
