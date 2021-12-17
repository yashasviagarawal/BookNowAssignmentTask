package com.example.booknowassignmenttask;

public class DataStore {

    public DataStore(String date, String time, String productName, String price, String unit, String unitType, String total, String transactionType, String quantity) {
        Date = date;
        Time = time;
        ProductName = productName;
        Price = price;
        Unit = unit;
        UnitType = unitType;
        Total = total;
        TransactionType = transactionType;
        Quantity = quantity;
    }

    String Date;
    String Time;
    String ProductName;
    String Price;
    String Unit;
    String UnitType;
    String Total;
    String TransactionType;
    String Quantity;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getUnitType() {
        return UnitType;
    }

    public void setUnitType(String unitType) {
        UnitType = unitType;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
