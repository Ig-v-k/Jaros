package com.iw.jarosandroid.product;

import com.iw.jarosandroid.Product;
import org.jetbrains.annotations.NotNull;

public final class SimpleProduct implements Product {

    private final int id;
    private final String name;
    private final String ingredients;
    private final String category;
    private final double pln;
    private final String image;

    public SimpleProduct(int id, String name, String ingredients, String category, double pln, String image) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.pln = pln;
        this.image = image;
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
    public String ingredients() {
        return ingredients;
    }

    @Override
    public String category() {
        return category;
    }

    @Override
    public double pln() {
        return pln;
    }

    @Override
    public String image() {
        return image;
    }

    @NotNull
    @Override
    public String toString() {
        return name;
    }
}
