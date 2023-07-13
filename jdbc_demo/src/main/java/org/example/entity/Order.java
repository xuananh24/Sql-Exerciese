package org.example.entity;

public class Order {
    private String customerName;
    private String salesOrderNumber;
    private int customerKey;
    private float totalOrderCost;

    public Order(String customerName, String salesOrderNumber, int customerKey, float totalOrderCost) {
        this.customerName = customerName;
        this.salesOrderNumber = salesOrderNumber;
        this.customerKey = customerKey;
        this.totalOrderCost = totalOrderCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", salesOrderNumber='" + salesOrderNumber + '\'' +
                ", customerKey=" + customerKey +
                ", totalOrderCost=" + totalOrderCost +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public int getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(int customerKey) {
        this.customerKey = customerKey;
    }

    public float getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(float totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }
}
