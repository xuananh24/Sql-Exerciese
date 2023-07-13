package org.example.entity;

public class ProductInternetSale {
    private String salesOrderNumber;
    private String salesOrderLineNumber;
    private String customerName;
    private String productName;
    private int orderQuantity;
    private float unitPrice;
    private float discountAmount;
    private float salesAmount;
    private float productStandardCost;
    private float totalProductCost;


    public ProductInternetSale(String salesOrderNumber, String salesOrderLineNumber, String customerName, String productName,
                               int orderQuantity, float unitPrice, float discountAmount, float salesAmount, float productStandardCost, float totalProductCost) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrderLineNumber = salesOrderLineNumber;
        this.customerName = customerName;
        this.productName = productName;
        this.orderQuantity = orderQuantity;
        this.unitPrice = unitPrice;
        this.discountAmount = discountAmount;
        this.salesAmount = salesAmount;
        this.productStandardCost = productStandardCost;
        this.totalProductCost = totalProductCost;
    }


    @Override
    public String toString() {
        return "ProductInternetSale{" +
                "salesOrderNumber='" + salesOrderNumber + '\'' +
                ", salesOrderLineNumber='" + salesOrderLineNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", unitPrice=" + unitPrice +
                ", discountAmount=" + discountAmount +
                ", salesAmount=" + salesAmount +
                ", productStandardCost=" + productStandardCost +
                ", totalProductCost=" + totalProductCost +
                '}';
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getSalesOrderLineNumber() {
        return salesOrderLineNumber;
    }

    public void setSalesOrderLineNumber(String salesOrderLineNumber) {
        this.salesOrderLineNumber = salesOrderLineNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public float getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(float salesAmount) {
        this.salesAmount = salesAmount;
    }

    public float getProductStandardCost() {
        return productStandardCost;
    }

    public void setProductStandardCost(float productStandardCost) {
        this.productStandardCost = productStandardCost;
    }

    public float getTotalProductCost() {
        return totalProductCost;
    }

    public void setTotalProductCost(float totalProductCost) {
        this.totalProductCost = totalProductCost;
    }

}
