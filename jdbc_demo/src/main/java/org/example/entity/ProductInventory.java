package org.example.entity;

public class ProductInventory {
    private int productKey;
    private String productName;
    private String modelName;
    private String productCategoryName;
    private String getProductSubcategoryName;
    private int unitBalance;
    private int unitCost;

    public ProductInventory(int productKey, String productName, String modelName, String productCategoryName, String getProductSubcategoryName, int unitBalance, int unitCost) {
        this.productKey = productKey;
        this.productName = productName;
        this.modelName = modelName;
        this.productCategoryName = productCategoryName;
        this.getProductSubcategoryName = getProductSubcategoryName;
        this.unitBalance = unitBalance;
        this.unitCost = unitCost;
    }

    public ProductInventory(String productName, String modelName, String productCategoryName, String getProductSubcategoryName, int unitBalance, int unitCost) {
        this.productKey = 1;
        this.productName = productName;
        this.modelName = modelName;
        this.productCategoryName = productCategoryName;
        this.getProductSubcategoryName = getProductSubcategoryName;
        this.unitBalance = unitBalance;
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return "ProductInventory{" +
                "productKey=" + productKey +
                ", productName='" + productName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", getProductSubcategoryName='" + getProductSubcategoryName + '\'' +
                ", unitBalance=" + unitBalance +
                ", unitCost=" + unitCost +
                '}';
    }

    public int getProductKey() {
        return productKey;
    }

    public void setProductKey(int productKey) {
        this.productKey = productKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getGetProductSubcategoryName() {
        return getProductSubcategoryName;
    }

    public void setGetProductSubcategoryName(String getProductSubcategoryName) {
        this.getProductSubcategoryName = getProductSubcategoryName;
    }

    public int getUnitBalance() {
        return unitBalance;
    }

    public void setUnitBalance(int unitBalance) {
        this.unitBalance = unitBalance;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }
}
