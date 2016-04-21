package mx.edu.utng.primefaceslfar.ui.a_tema_i;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mx.edu.utng.primefaceslfar.R;

public class FragmentoWebComponentesVideo extends Fragment {
    WebView wv;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.web_fragment, container, false);
        WebView displayVideo = (WebView)view.findViewById(R.id.webView1);
        String frameVideo = "<html><body>Youtube video .. <br><center> <iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/v2t0CuHTajQ\" frameborder=\"0\" allowfullscreen></iframe></body></html>";


        displayVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayVideo.loadData(frameVideo, "text/html", "utf-8");
        return view;
    }

}