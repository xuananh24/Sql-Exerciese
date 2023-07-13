package org.example.entity;

public class Product {
    private String name;
    private String modelName;
    private String productLine;
    private String productCategoryName;
    private String productSubcategoryName;
    private Float dealerPrice;
    private Float listPrice;
    private String Color;
    private String description;

    public Product(String name, String modelName, String productLine, String productCategoryName, String productSubcategoryName, Float dealerPrice, Float listPrice, String color, String description) {
        this.name = name;
        this.modelName = modelName;
        this.productLine = productLine;
        this.productCategoryName = productCategoryName;
        this.productSubcategoryName = productSubcategoryName;
        this.dealerPrice = dealerPrice;
        this.listPrice = listPrice;
        Color = color;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", modelName='" + modelName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", productSubcategoryName='" + productSubcategoryName + '\'' +
                ", dealerPrice=" + dealerPrice +
                ", listPrice=" + listPrice +
                ", Color='" + Color + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductSubcategoryName() {
        return productSubcategoryName;
    }

    public void setProductSubcategoryName(String productSubcategoryName) {
        this.productSubcategoryName = productSubcategoryName;
    }

    public Float getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(Float dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    public Float getListPrice() {
        return listPrice;
    }

    public void setListPrice(Float listPrice) {
        this.listPrice = listPrice;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
