package com.zzzmh;

import com.zzzmh.controller.IndexController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // fxml加载器
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view/index.fxml"));
        // fxml加载到 根节点
        Parent root = fxmlLoader.load();
        // 设置标题
        primaryStage.setTitle("极简牛腩器 (Simple Browser)");
        // 设置默认宽高 并加入根节点
        primaryStage.setScene(new Scene(root, 1280, 720));
        // 显示窗口
        primaryStage.show();
        // 获取IndexController
        IndexController controller = (IndexController)fxmlLoader.getController();
        // 执行IndexController中的初始化方法
        controller.init();
    }

    /**
     * 入口方法
     * 执行本方法启动整个程序
     */
    public static void main(String[] args) {
        launch(args);
    }
}
