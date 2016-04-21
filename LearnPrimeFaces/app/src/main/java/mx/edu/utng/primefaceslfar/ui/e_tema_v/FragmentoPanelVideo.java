package mx.edu.utng.primefaceslfar.ui.e_tema_v;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mx.edu.utng.primefaceslfar.R;

public class FragmentoPanelVideo extends Fragment {
    WebView wv;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.web_fragment, container, false);

        wv=(WebView)view.findViewById(R.id.webView1);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://youtu.be/skWWNwXNWwM?list=PLvimn1Ins-41Dn6vhYzB0Kv90_2eFIdXG");

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        return view;
    }

}