package com.iw.jarosandroid;

public interface Route {
    void forward(final Facet facet);
    void back();
    void replace(final Facet facet);
}
