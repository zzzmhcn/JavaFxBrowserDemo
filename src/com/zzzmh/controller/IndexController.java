package com.zzzmh.controller;

import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebErrorEvent;
import javafx.scene.web.WebView;

public class IndexController {

    public TextField url;
    public WebView webview;
    public static String homePageUrl = "https://www.bing.com";

    public void prev() {
        webview.getEngine().getHistory().go(-1);
        url.setText(webview.getEngine().getLocation());
    }

    public void next() {
        webview.getEngine().getHistory().go(1);
        url.setText(webview.getEngine().getLocation());
    }

    public void refresh() {
        webview.getEngine().reload();
    }

    public void home() {
        goTo(homePageUrl);
    }


    /**
     * 跳转
     */
    public void forward() {
        goTo(url.getText().startsWith("http") ? url.getText() : "http://" + url.getText());
    }

    public void goTo(String urlString) {
        url.setText(urlString);
        webview.getEngine().load(urlString);
    }
}
