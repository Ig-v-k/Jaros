package com.iw.jarosandroid.jaros;

import com.google.gson.Gson;
import com.iw.jarosandroid.Jaros;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.gson.Serialize;
import com.iw.jarosandroid.product.JsonProduct;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public final class JsonJaros implements Jaros {
    private final List<Product> products;

    public JsonJaros() {
        this(new ArrayList<>());
    }

    public JsonJaros(List<Product> products) {
        this.products = products;
    }

    @Override
    public Jaros from(Object from) {
        final BufferedReader br = (BufferedReader) from;
            return new Gson().newBuilder()
                    .registerTypeAdapter(Product.class, new Serialize<>(JsonProduct.class))
                    .registerTypeAdapter(Jaros.class, new Serialize<>(JsonJaros.class))
                    .create()
                    .fromJson(br, Jaros.class);
    }

    @Override
    public List<Product> products() {
        return products;
    }
}
