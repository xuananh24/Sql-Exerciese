package org.example;

import org.example.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<ProductInventory> productInventories = new ArrayList<>();
    private ArrayList<ProductInventory> highestValueProductInventory = new ArrayList<>();
    private ArrayList<ProductInternetSale> productInternetSales = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public List<Customer> ex1GetUKCustomers() {
        String query = "SELECT " +
                "CONCAT(c.FirstName, ' ' , c.MiddleName, ' ' ,c.LastName) AS FullName, " +
                "c.BirthDate, " +
                "CASE " +
                "WHEN c.Gender = 'F' THEN 'Female' " +
                "WHEN c.Gender = 'M' THEN 'Male' " +
                "END AS Gender, " +
                "c.EmailAddress, " +
                "c.EnglishEducation AS Education, " +
                "c.Phone, " +
                "c.AddressLine1, " +
                "c.AddressLine1 " +
                "FROM DimCustomer AS c " +
                "INNER JOIN DimGeography AS g " +
                "ON c.GeographyKey = g.GeographyKey " +
                "WHERE CountryRegionCode = 'GB'";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void ex2GetTotalNumOfCustomerByCountry() {
        String query = "SELECT " +
                "g.EnglishCountryRegionName AS CountryName, " +
                "COUNT(c.CustomerKey) AS TotalCustomer " +
                "FROM DimCustomer AS c " +
                "INNER JOIN DimGeography AS g " +
                "ON c.GeographyKey = g.GeographyKey " +
                "GROUP BY g.EnglishCountryRegionName ";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("CountryName             TotalCustomer");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "             " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> ex3GetTop100ProductOfHighestSellingPrice() {
        String query = "SELECT TOP 100 " +
                "p.EnglishProductName AS ProductName, " +
                "p.ModelName, " +
                "p.ProductLine, " +
                "c.EnglishProductCategoryName AS ProductCategoryName, " +
                "sc.EnglishProductSubcategoryName AS ProductSubcategoryName, " +
                "p.DealerPrice, " +
                "p.ListPrice, " +
                "p.Color, " +
                "p.EnglishDescription AS Description " +
                "FROM DimProductSubcategory AS sc " +
                "JOIN DimProductCategory AS c " +
                "ON sc.ProductSubcategoryKey = c.ProductCategoryKey " +
                "JOIN DimProduct AS p " +
                "ON sc.ProductCategoryKey = c.ProductCategoryKey " +
                "ORDER BY p.ListPrice DESC";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getFloat(6),
                        resultSet.getFloat(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                ));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ex4CalculateTotalAmountOfTransactionsAccordingRegions() {
        String query = "SELECT PivotTable.AccountDescription, " +
                "[France], [Germany], [Australia] " +
                "FROM ( " +
                "SELECT  " +
                "a.AccountDescription, " +
                "o.OrganizationName, " +
                "f.Amount " +
                "FROM FactFinance AS f " +
                "JOIN DimAccount AS a ON f.AccountKey = a.AccountKey " +
                "JOIN DimOrganization AS o ON f.OrganizationKey = o.OrganizationKey " +
                ") AS FinanceTable " +
                "PIVOT ( " +
                "SUM(Amount) " +
                "FOR OrganizationName IN ([France], [Germany], [Australia])  " +
                ") AS PivotTable " +
                "ORDER BY PivotTable.AccountDescription";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("AccountDescription             France             Germany               Australia");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "             "
                        + resultSet.getFloat(2) + "              "
                        + resultSet.getFloat(3)+ "              "
                        + resultSet.getFloat(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductInventory> ex5GetLatestStockInformation() {
        String query = "SELECT " +
                "    p.ProductKey, " +
                "    p.EnglishProductName AS ProductName, " +
                "    p.ModelName, " +
                "    pc.EnglishProductCategoryName AS ProductCategoryName, " +
                "    ps.EnglishProductSubcategoryName AS ProductSubcategoryName, " +
                "    pin.UnitsBalance, " +
                "    pin.UnitCost " +
                "FROM DimProductCategory pc " +
                "JOIN DimProductSubcategory ps ON pc.ProductCategoryKey = ps.ProductCategoryKey " +
                "JOIN DimProduct p ON p.ProductSubcategoryKey = ps.ProductSubcategoryKey " +
                "    JOIN FactProductInventory pin ON p.ProductKey = pin.ProductKey " +
                "    JOIN ( " +
                "        SELECT " +
                "            ProductKey, " +
                "            MAX(MovementDate) AS LatestDate " +
                "        FROM " +
                "            FactProductInventory " +
                "        GROUP BY " +
                "            ProductKey " +
                "    ) AS latest ON pin.ProductKey = latest.ProductKey AND pin.MovementDate = latest.LatestDate " +
                "ORDER BY ProductKey";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productInventories.add(new ProductInventory(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)
                ));
            }
            return productInventories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductInventory> ex6GetTop10HighestInventoryValue() {
        String query = "SELECT " +
                "    p.ProductKey, " +
                "    p.EnglishProductName AS ProductName, " +
                "    p.ModelName, " +
                "    pc.EnglishProductCategoryName AS ProductCategoryName, " +
                "    ps.EnglishProductSubcategoryName AS ProductSubcategoryName, " +
                "    pin.UnitsBalance, " +
                "    pin.UnitCost " +
                "FROM DimProductCategory pc " +
                "JOIN DimProductSubcategory ps ON pc.ProductCategoryKey = ps.ProductCategoryKey " +
                "JOIN DimProduct p ON p.ProductSubcategoryKey = ps.ProductSubcategoryKey " +
                "    JOIN FactProductInventory pin ON p.ProductKey = pin.ProductKey " +
                "    JOIN ( " +
                "        SELECT " +
                "            ProductKey, " +
                "            MAX(MovementDate) AS LatestDate " +
                "        FROM " +
                "            FactProductInventory " +
                "        GROUP BY " +
                "            ProductKey " +
                "    ) AS latest ON pin.ProductKey = latest.ProductKey AND pin.MovementDate = latest.LatestDate " +
                "ORDER BY ProductKey";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                highestValueProductInventory.add(new ProductInventory(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)
                ));
            }
            return highestValueProductInventory;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductInternetSale> ex8GetProductInternetSaleByName() {
        String query = "SELECT " +
                "SalesOrderNumber, " +
                "SalesOrderLineNumber, " +
                "CONCAT(dc.FirstName, ' ', dc.MiddleName, ' ', dc.LastName) AS CustomerName, " +
                "dp.EnglishProductName AS ProductName, " +
                "OrderQuantity, " +
                "UnitPrice, " +
                "DiscountAmount, " +
                "SalesAmount, " +
                "ProductStandardCost, " +
                "TotalProductCost " +
                "FROM FactInternetSales AS fis " +
                "JOIN DimCustomer AS dc ON fis.CustomerKey = dc.CustomerKey " +
                "JOIN DimProduct AS dp ON fis.ProductKey = dp.ProductKey " +
                "WHERE dp.EnglishProductName = 'Road-150 Red, 48'";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productInternetSales.add(new ProductInternetSale(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getFloat(6),
                        resultSet.getFloat(7),
                        resultSet.getFloat(8),
                        resultSet.getFloat(9),
                        resultSet.getFloat(10)
                ));
            }
            return productInternetSales;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> ex9Get20InvoicesWithHighestTotalPayable() {
        String query = "SELECT DISTINCT TOP 20 " +
                "CONCAT(dc.FirstName, ' ', dc.MiddleName, ' ', dc.LastName) AS CustomerName, " +
                "fis.SalesOrderNumber, " +
                "dc.CustomerKey, " +
                "total.TotalOrderCost " +
                "FROM FactInternetSales AS fis " +
                "JOIN DimCustomer AS dc ON fis.CustomerKey = dc.CustomerKey " +
                "JOIN ( " +
                "SELECT  " +
                "SalesOrderNumber, SUM(TotalProductCost) AS TotalOrderCost " +
                "FROM FactInternetSales " +
                "GROUP BY SalesOrderNumber " +
                ") AS total ON fis.SalesOrderNumber = total.SalesOrderNumber  " +
                "ORDER BY TotalOrderCost DESC";

        try {
            Connection connection = ConnectJDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getFloat(4)
                ));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
