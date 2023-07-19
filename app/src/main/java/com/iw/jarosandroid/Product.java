package com.iw.jarosandroid;

public interface Product {
    int id();
    String name();
    String category();
    String ingredients();
    double pln();
    boolean favorite();
    void update(String name, String category, String ingredients, double pln, boolean favorite);
}
