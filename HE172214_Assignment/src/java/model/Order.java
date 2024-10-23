/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephhoang
 */
public class Order {
    private int id;
    private int amount;
    private int accountId;
    private Timestamp createAt;
    List<OrderDetails> listOrderDetails = new ArrayList<>();
    
}
