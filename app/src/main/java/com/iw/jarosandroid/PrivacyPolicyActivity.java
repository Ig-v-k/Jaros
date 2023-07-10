package com.iw.jarosandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public final class PrivacyPolicyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_privacy_policy);

        WebView web = findViewById(R.id.webView);
        web.loadUrl("https://dropbox.com/s/bc08n9h8wbj1892/jarosandroid_pp.md?dl=0");
    }
}
