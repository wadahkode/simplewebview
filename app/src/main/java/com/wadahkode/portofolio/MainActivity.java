package com.wadahkode.portofolio;

import android.app.Activity;
//import android.app.AlertDialog;
import android.content.Intent;
//import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.URLUtil;
//import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
//import android.widget.Toast;
import com.wadahkode.portofolio.R;

public class MainActivity extends Activity {
	private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView webView = (WebView) findViewById(R.id.webview);
        mWebView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient() {
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {
            	if( URLUtil.isNetworkUrl(url) ) {
                	return false;
            	}
            	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            	startActivity( intent );
            	return true;
        	}
        });
        
        // Memuat halaman web eksternal
        //webView.loadUrl("https://wadahkode.github.io/portofolio");
        webView.loadUrl("file:///storage/emulated/0/www/appjs/docs/index.html");
    }
    
    @Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.getAction() == KeyEvent.ACTION_DOWN) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    finish();
                }
                return true;
        }

    }
    return super.onKeyDown(keyCode, event);
}
}
