package com.iw.jarosandroid.product;

import com.iw.jarosandroid.Product;

public final class JsonProduct implements Product {

    private final int id;
    private final String name;
    private final String category;
    private final String ingredients;
    private final double pln;
    private final boolean favorite;

    public JsonProduct(int id, String name, String category, String ingredients, double pln, boolean favorite) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.pln = pln;
        this.favorite = favorite;
    }

    @Override
    public int id() {
        return id;
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

    @Override
    public boolean favorite() {
        return favorite;
    }

    @Override
    public void update(String name, String category, String ingredients, double pln, boolean favorite) {}
}
