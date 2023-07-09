package com.iw.jarosandroid;

import java.util.List;

public interface Products {
    List<Product> list();
    void add(final String name, final String category, final String ingredients, final double pln, boolean favorite);
}
