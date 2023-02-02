package com.javapro.lesson30;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductReader {
    private final List<ProductSame> productSames = new ArrayList<>();

    public List<ProductSame> readAll() {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
             Statement statement = connection.createStatement()) {


            ResultSet resultSet = statement.executeQuery("select * from my_store.order1 UNION ALL select * from my_store.order2;");

            while (resultSet.next()) {
                ProductSame productSame = fillProductSame(resultSet);
                productSames.add(productSame);
            }

            return productSames;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }


    private static ProductSame fillProductSame(ResultSet resultSet) throws SQLException {
        // Retrieve by column name
        ProductSame productSame = new ProductSame();


        String name = resultSet.getString("name");
        productSame.setName(name);
        System.out.print(" name: " + name);

        String product = resultSet.getString("product");
        productSame.setProduct(product);
        System.out.print(", product: " + product);

        int price = resultSet.getInt("price");
        productSame.setPrice(price);
        System.out.print(", price: " + price);
        int quality = resultSet.getInt("quality");
        productSame.setQuality(quality);
        System.out.print(", quality: " + quality);


        System.out.println();
        return productSame;
    }
 public void averagePrice(){
        List<ProductSame> atb;
        atb  = productSames.stream().
                filter(productSames -> productSames.getName().equals("АТБ")&&productSames.getProduct().equals("Гречка")).toList();

     System.out.println(atb);
 }

}


