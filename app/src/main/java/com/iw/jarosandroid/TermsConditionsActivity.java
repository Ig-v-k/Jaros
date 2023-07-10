package com.iw.jarosandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public final class TermsConditionsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_privacy_policy);

        WebView web = findViewById(R.id.webView);
        web.loadUrl("https://dropbox.com/s/liyu0opojezpsz2/jarosandroid_tc.md?dl=0");
    }
}
