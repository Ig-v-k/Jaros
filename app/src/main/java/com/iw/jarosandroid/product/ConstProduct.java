package com.iw.jarosandroid.product;

import com.iw.jarosandroid.Product;

public final class ConstProduct implements Product {

    private final Product origin;
    private final String name;
    private final String category;
    private final String ingredients;
    private final double pln;

    public ConstProduct(Product origin, String name, String category, String ingredients, double pln) {
        this.origin = origin;
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.pln = pln;
    }

    @Override
    public int id() {
        return origin.id();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String category() {
        return category;
    }

    @Override
    public String ingredients() {
        return ingredients;
    }

    @Override
    public double pln() {
        return pln;
    }
}
