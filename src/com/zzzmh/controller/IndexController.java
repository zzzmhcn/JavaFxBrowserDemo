package com.zzzmh.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * @author zzzmh
 */
public class IndexController {

    public TextField url;
    public WebView webview;
    public static String homePageUrl = "https://www.baidu.com";


    /**
     * 初始化
     */
    public void init() {
        // webview 加入监听器 状态改变后 自动把新的url回显到文本输入框
        webview.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                url.setText(webview.getEngine().getLocation());
            }
        });
        // 跳转首页
        home();
    }

    /**
     * 后退
     */
    public void prev() {
        // 必须不是第一个页 才可以后退 否则会出现
        if (webview.getEngine().getHistory().getCurrentIndex() > 0) {
            webview.getEngine().getHistory().go(-1);
        }
    }

    /**
     * 前进
     */
    public void next() {
        // 前进必须前面还有页面
        if(webview.getEngine().getHistory().currentIndexProperty().getValue()
                < webview.getEngine().getHistory().getEntries().size() - 1){
            webview.getEngine().getHistory().go(1);
        }
    }

    /**
     * 刷新
     */
    public void refresh() {
        // 重新加载当前引擎
        webview.getEngine().reload();
    }

    /**
     * 首页
     */
    public void home() {
        // 跳转默认首页
        goTo(homePageUrl);
    }


    /**
     * 跳转
     */
    public void forward() {
        // 跳转到输入的url （本方法关联跳转按钮）
        goTo(url.getText().startsWith("http") ? url.getText() : "http://" + url.getText());
    }

    /**
     * 跳转的通用方法
     */
    public void goTo(String urlString) {
        webview.getEngine().load(urlString);
    }

}
