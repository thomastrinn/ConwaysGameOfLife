package com.thomas.gameoflife;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;

public class GameOfLifeApplication extends Application {

    private static final int SCENE_HEIGHT = 400;
    private static final int SCENE_WIDTH = 500;

    private Timer timer;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conway's Game of Life");

        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);

        Canvas canvas = new Canvas();

        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        final List<Cell> cells = loadCells("gosper_glider_gun.json");
        timer = new Timer();

        timer.schedule(new CellDrawerTask(primaryStage, gc, cells), 0, 60);

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        timer.cancel();
    }
    
    private List<Cell> loadCells(String name) throws IOException {
         InputStream resource = getClass().getClassLoader().getResourceAsStream(name);
         String json = IOUtils.toString(resource);
         
         Type cellListType = new TypeToken<List<Cell>>(){}.getType();
         return new Gson().fromJson(json, cellListType);
     }
}
