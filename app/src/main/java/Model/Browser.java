package Model;

import android.app.Activity;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Entity for encapsuling
 * Created by carlos on 28/07/15.
 */
public class Browser {
    public WebView _Self;
    public String _page="";//current page of the browser
    public static Function _cb;
    public static Activity act;
    //constructor
    public Browser(WebView Other,String url, Activity act){
        this._Self=Other;
        Browser.act=act;
        this._Self.loadUrl(url);
        this._page=url;
        //no restrictions
        this._Self.getSettings().setJavaScriptEnabled(true);
        //to not allow going outside
        this._Self.setWebViewClient(
                new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                }
        );
    }

    //go to previous page
    public void previousPage(){
        if(this._Self.canGoBack())
            this._Self.goBack();
    }

    //go to next page
    public void nextPage(){
        if(this._Self.canGoForward())
            this._Self.goForward();
    }

    //-----JS Zone----

        //normal JS execution
    public void console(String script){
        this._Self.loadUrl("javascript:"+script);
    }
        //waiting for values from JS console
    public void console(String script,Function cb ){
        Browser._cb=cb;
        this._Self.evaluateJavascript("javascript:"+script, new ValueCallback<String>() {
            public void onReceiveValue(String result) {
                    Browser._cb.Execute(new String []{result});
            }
        });
    }


}