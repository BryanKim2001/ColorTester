package com.example.colortester;

import javafx.fxml.FXMLLoader;

import java.awt.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.FontWeight;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;

import static javafx.scene.text.Font.font;

// Color Tester Class
// Version 1.1
public class HelloApplication extends Application {
    private int grayScale = 0;
    private Color c = Color.BLACK;
    private Label rgbLabel = new Label("0");

    private double width = 0;
    private double height = 0;

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.setFullScreen(true);
        //GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = Screen.getPrimary().getBounds().getWidth();
        //height = gd.getDisplayMode().getHeight();
        height = Screen.getPrimary().getBounds().getHeight();
        System.out.println("Resolution: " + width + " x " + height);
        final double tenPer = width/10;
        final double twentyPer = width/ 5;
        stage.setWidth(width);
        stage.setHeight(height);

        // Global Exit Button
        Button exitBtn = new Button("Exit Program");
        exitBtn.setPrefWidth(tenPer);
        exitBtn.setPrefHeight(height/25);
        exitBtn.setStyle( "-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 40%; -fx-font-family: Arial; -fx-font-size: 200%");
        exitBtn.setOnAction(e -> {
                Platform.exit();
        });
        exitBtn.setPrefWidth(twentyPer);
        // Starting Scene
        Label title = new Label("Monitor Color Testing Program");
        title.setFont(font("Arial"));
        title.setStyle("-fx-font-size: 500%; -fx-font-weight: bold");
        title.setPadding(new Insets(0, 0, -10, 0));
        Label title2 = new Label("By: OTnCon4");
        title2.setFont(font("Arial"));
        title2.setStyle("-fx-font-size: 250%; -fx-font-weight: bold");
        title2.setPadding(new Insets(0, 0, 30, 0));
        Label directions = new Label();
        directions.setText("Directions: Click on any test to begin. Use L/R arrow keys to go through each test screen.");
        directions.setFont(font("Arial"));
        directions.setStyle("-fx-font-size: 200%");
        Label directions2 = new Label("Press ESC when finished with a test.");
        directions2.setFont(font("Arial"));
        directions2.setStyle("-fx-font-size: 200%");
        HBox horizontalSpace = new HBox();
        horizontalSpace.setPadding(new Insets(0, 0, 20, 0));
        Button showRGB = new Button("Test RGB");
        showRGB.setPrefWidth(twentyPer);
        showRGB.setPrefHeight(height/25);
        showRGB.setStyle( "-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 40%; -fx-font-family: Arial; -fx-font-size: 200%");
        Button showGrayscale = new Button("Test Grayscale");
        showGrayscale.setStyle( "-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 40%; -fx-font-family: Arial; -fx-font-size: 200%");
        showGrayscale.setPrefWidth(twentyPer);
        showGrayscale.setPrefHeight(height/25);
        Button showGradient = new Button("Test Gradient");
        showGradient.setStyle( "-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 40%; -fx-font-family: Arial; -fx-font-size: 200%");
        showGradient.setPrefWidth(twentyPer);
        showGradient.setPrefHeight(height/25);
        Button showUniformity = new Button("Test Uniformity");
        showUniformity.setStyle( "-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 40%; -fx-font-family: Arial; -fx-font-size: 200%");
        showUniformity.setPrefWidth(twentyPer);
        showUniformity.setPrefHeight(height/25);

        VBox startVBox = new VBox();
        startVBox.getChildren().addAll(title, title2, showRGB, showGrayscale, showGradient, showUniformity, exitBtn, horizontalSpace, directions, directions2);
        startVBox.setAlignment(Pos.CENTER);
        startVBox.setSpacing(25);
        BackgroundFill startFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background startBG = new Background(startFill);
        startVBox.setBackground(startBG);
        Scene scene = new Scene(startVBox, width, height);
        stage.setScene(scene);

        // Red Scene
        HBox redBox = new HBox();
        BackgroundFill redBGFill = new BackgroundFill(Color.rgb(255, 0, 0), CornerRadii.EMPTY, Insets.EMPTY);
        Background redBG = new Background(redBGFill);
        redBox.setBackground(redBG);

        // Blue Scene
        HBox blueBox = new HBox();
        BackgroundFill blueBGFill = new BackgroundFill(Color.rgb(0, 0, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background blueBG = new Background(blueBGFill);
        blueBox.setBackground(blueBG);

        // Green Scene
        HBox greenBox = new HBox();
        BackgroundFill greenBGFill = new BackgroundFill(Color.rgb(0, 255, 0), CornerRadii.EMPTY, Insets.EMPTY);
        Background greenBG = new Background(greenBGFill);
        greenBox.setBackground(greenBG);

        // Black Scene
        HBox blackBox = new HBox();
        BackgroundFill blackBGFill = new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY);
        Background blackBG = new Background(blackBGFill);
        blackBox.setBackground(blackBG);

        // White Scene
        HBox whiteBox = new HBox();
        BackgroundFill whiteBGFill = new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background whiteBG = new Background(whiteBGFill);
        whiteBox.setBackground(whiteBG);

        // GrayScale Scene
        rgbLabel.setTextFill(Color.WHITE);
        rgbLabel.setFont(font("Arial"));
        rgbLabel.setStyle("-fx-font-size: 300%; -fx-font-weight: bold");
        BackgroundFill labelFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background labelBG = new Background(labelFill);
        rgbLabel.setBackground(labelBG);
        HBox grayhbox = new HBox();
        grayhbox.getChildren().add(rgbLabel);
        BackgroundFill grayBGFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background grayBG = new Background(grayBGFill);
        grayhbox.setBackground(grayBG);
        grayhbox.setSpacing(10);
        grayhbox.setAlignment(Pos.CENTER);

        // 8-panel Gradient Scene
        HBox grad8 = new HBox();
        double rectWidth = width/8;
        int colorChange = 36;
        int currRGBValue = 0;
        Rectangle r1 = new Rectangle(0, 0, rectWidth, height);
        r1.setFill(Color.BLACK);
        grad8.getChildren().add(r1);
        Rectangle r2 = new Rectangle(rectWidth * 7, 0, rectWidth, height);
        r2.setFill(Color.WHITE);
        for (int i = 1; i < 7; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rectWidth * i, 0, rectWidth, height);
            if (i % 2 == 1) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(currRGBValue, currRGBValue, currRGBValue));
            grad8.getChildren().add(r1);
        }
        grad8.getChildren().add(r2);

        // 16-panel Gradient Scene
        HBox grad16 = new HBox();
        double rect16Width = width/16;
        colorChange = 17;
        r1 = new Rectangle(0, 0, rect16Width, height);
        r1.setFill(Color.BLACK);
        grad16.getChildren().add(r1);
        r2 = new Rectangle(rect16Width * 15, 0, rect16Width, height);
        r2.setFill(Color.WHITE);
        for (int i = 1; i < 15; i++) {
            r1 = new Rectangle(rect16Width * i, 0, rect16Width, height);
            r1.setFill(Color.rgb(colorChange*i, colorChange*i, colorChange*i));
            grad16.getChildren().add(r1);
        }
        grad16.getChildren().add(r2);

        // 32-panel Gradient Scene
        HBox grad32 = new HBox();
        double rect32Width = width/32;
        currRGBValue = 0;
        colorChange = 8;
        r1 = new Rectangle(0, 0, rect32Width, height);
        r1.setFill(Color.BLACK);
        grad32.getChildren().add(r1);
        r2 = new Rectangle(rect32Width * 31, 0, rect32Width, height);
        r2.setFill(Color.WHITE);
        for (int i = 1; i < 31; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rect32Width * i, 0, rect32Width, height);
            if (i % 4 == 0) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(currRGBValue, currRGBValue, currRGBValue));
            grad32.getChildren().add(r1);
        }
        grad32.getChildren().add(r2);

        // 64-panel Gradient Scene
        HBox grad64 = new HBox();
        double rect64Width = width/64;
        currRGBValue = 0;
        colorChange = 4;
        r1 = new Rectangle(0, 0, rect64Width, height);
        r1.setFill(Color.BLACK);
        grad64.getChildren().add(r1);
        r2 = new Rectangle(rect64Width * 63, 0, rect64Width, height);
        r2.setFill(Color.WHITE);
        for (int i = 1; i < 63; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rect64Width * i, 0, rect64Width, height);
            if (i % 16 == 0) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(currRGBValue, currRGBValue, currRGBValue));
            grad64.getChildren().add(r1);
        }
        grad64.getChildren().add(r2);


        // 32-panel Red Gradient Scene
        HBox redGrad = new HBox();
        rect32Width = width/32;
        currRGBValue = 0;
        colorChange = 8;
        r1 = new Rectangle(0, 0, rect32Width, height);
        r1.setFill(Color.BLACK);
        redGrad.getChildren().add(r1);
        r2 = new Rectangle(rect32Width * 31, 0, rect32Width, height);
        r2.setFill(Color.RED);
        for (int i = 1; i < 31; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rect32Width * i, 0, rect32Width, height);
            if (i % 4 == 0) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(currRGBValue, 0, 0));
            redGrad.getChildren().add(r1);
        }
        redGrad.getChildren().add(r2);

        // 32-panel Green Gradient Scene
        HBox greenGrad = new HBox();
        rect32Width = width/32;
        currRGBValue = 0;
        colorChange = 8;
        r1 = new Rectangle(0, 0, rect32Width, height);
        r1.setFill(Color.BLACK);
        greenGrad.getChildren().add(r1);
        r2 = new Rectangle(rect32Width * 31, 0, rect32Width, height);
        r2.setFill(Color.LIME);
        for (int i = 1; i < 31; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rect32Width * i, 0, rect32Width, height);
            if (i % 4 == 0) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(0, currRGBValue, 0));
            greenGrad.getChildren().add(r1);
        }
        greenGrad.getChildren().add(r2);

        // 32-panel Blue Gradient Scene
        HBox blueGrad = new HBox();
        rect32Width = width/32;
        currRGBValue = 0;
        colorChange = 8;
        r1 = new Rectangle(0, 0, rect32Width, height);
        r1.setFill(Color.BLACK);
        blueGrad.getChildren().add(r1);
        r2 = new Rectangle(rect32Width * 31, 0, rect32Width, height);
        r2.setFill(Color.BLUE);
        for (int i = 1; i < 31; i++) {
            currRGBValue += colorChange;
            r1 = new Rectangle(rect32Width * i, 0, rect32Width, height);
            if (i % 4 == 0) {
                currRGBValue++;
            }
            r1.setFill(Color.rgb(0, 0, currRGBValue));
            blueGrad.getChildren().add(r1);
        }
        blueGrad.getChildren().add(r2);

        // Uniformity Scene
        Circle circle;
        Group pane = new Group();
        for (int r = 1; r <= 5; r+=2) {
            for (int c = 1; c <= 5; c+=2) {
                circle = new Circle(width * r / 6, height * c / 6, 115.0f);
                circle.setRadius(tenPer * 3 / 5);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setStrokeWidth(4.0);
                pane.getChildren().add(circle);
            }
        }

        // Routing
        showRGB.setOnAction(e -> {
            scene.setRoot(redBox);
            scene.setOnMouseClicked((MouseEvent mouse) -> {
                if (scene.getRoot().equals(redBox)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(greenBox);
                    }
                } else if (scene.getRoot().equals(greenBox)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(blueBox);
                    }
                } else if (scene.getRoot().equals(blueBox)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(whiteBox);
                    }
                } else if (scene.getRoot().equals(whiteBox)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(blackBox);
                    }
                } else if (scene.getRoot().equals(blackBox)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(redBox);
                    }
                }
                if (mouse.getButton().equals(MouseButton.SECONDARY)) {
                    scene.setRoot(startVBox);
                }
            });
        });

        showGrayscale.setOnAction(e -> {
            scene.setRoot(grayhbox);
            scene.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    increaseGrayscale(grayhbox);
                } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                    decreaseGrayscale(grayhbox);
                }
            });

            scene.setOnKeyPressed((KeyEvent event) -> {
//                if (event.getCode().equals(KeyCode.RIGHT)) {
//                    increaseGrayscale(grayhbox);
//                } else if (event.getCode().equals(KeyCode.LEFT)) {
//                    decreaseGrayscale(grayhbox);
//                }
                if (event.getCode().equals(KeyCode.ESCAPE)) {
                    scene.setRoot(startVBox);
                }
            });
        });

        showGradient.setOnAction(e -> {
           scene.setRoot(grad8);
            scene.setOnMouseClicked((MouseEvent mouse) -> {
                if (scene.getRoot().equals(grad8)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(grad16);
                    }
                } else if (scene.getRoot().equals(grad16)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(grad32);
                    }
                } else if (scene.getRoot().equals(grad32)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(grad64);
                    }
                } else if (scene.getRoot().equals(grad64)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(redGrad);
                    }
                } else if (scene.getRoot().equals(redGrad)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(blueGrad);
                    }
                } else if (scene.getRoot().equals(blueGrad)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(greenGrad);
                    }
                } else if (scene.getRoot().equals(greenGrad)) {
                    if (mouse.getButton().equals(MouseButton.PRIMARY)) {
                        scene.setRoot(grad8);
                    }
                }
                if (mouse.getButton().equals(MouseButton.SECONDARY)) {
                    scene.setRoot(startVBox);
                }
            });
        });

        showUniformity.setOnAction(e -> {
           scene.setRoot(pane);
           scene.setOnKeyPressed((KeyEvent event) -> {
                if (event.getCode().equals(KeyCode.ESCAPE)) {
                    scene.setRoot(startVBox);
                }
            });
           scene.setOnMouseClicked((MouseEvent mouse) -> {
               if (mouse.getButton().equals(MouseButton.PRIMARY) || mouse.getButton().equals(MouseButton.SECONDARY)) {
                   scene.setRoot(startVBox);
               }
            });
        });

        // Start the Test
        stage.show();
    }

    private void increaseGrayscale(HBox hbox) {
        if (grayScale >= 250) {
            grayScale = 0;
        } else if (grayScale < 30) {
            grayScale++;
        } else {
            grayScale+=10;
        }
        c = Color.rgb(grayScale, grayScale, grayScale);
        BackgroundFill background_fill1 = new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(background_fill1);
        hbox.setBackground(background1);
        rgbLabel.setText(Integer.toString(grayScale));
    }

    private void decreaseGrayscale(HBox hbox) {
        if (grayScale < 1) {
            grayScale = 255;
        } else if (grayScale <= 30) {
            grayScale--;
        } else {
            grayScale-=10;
        }
        c = Color.rgb(grayScale, grayScale, grayScale);
        rgbLabel.setText(Integer.toString(grayScale));
        BackgroundFill background_fill1 = new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(background_fill1);
        hbox.setBackground(background1);
    }

    public static void main(String[] args) {
        launch();
    }
}