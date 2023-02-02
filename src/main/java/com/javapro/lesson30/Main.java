package com.javapro.lesson30;

public class Main {
    public static void main(String[] args) {
       ProductReader productReader = new ProductReader();
        System.out.println(productReader.readAll());
        productReader.averagePrice();
    }
}
