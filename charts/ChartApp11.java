package com.projavafx.charts;

import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChartApp11 extends Application {

    @Override
    public void start(Stage primaryStage) {
        CategoryAxis xAxis = new CategoryAxis();
        IntStream.range(2011,2020).forEach(t -> xAxis.getCategories().add(String.valueOf(t)));
        NumberAxis yAxis = new NumberAxis();
        StackedBarChart stackedBarChart = new StackedBarChart(xAxis, yAxis, getChartData());
        stackedBarChart.setTitle("speculations");
        primaryStage.setTitle("StackedBarChart example");

        StackPane root = new StackPane();
        root.getChildren().add(stackedBarChart);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private ObservableList<XYChart.Series<String, Double>> getChartData() {
        double javaValue = 15.57;
        double cValue = 6.97;
        double cppValue = 4.55;
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        Series<String, Double> java = new Series<>();
        Series<String, Double> c = new Series<>();
        Series<String, Double> cpp = new Series<>();
        for (int i = 2017; i < 2027; i++) {
            java.getData().add(new XYChart.Data(Integer.toString(i), javaValue));
            javaValue = javaValue + 2 * Math.random() - 1;
            c.getData().add(new XYChart.Data(Integer.toString(i), cValue));
            cValue = cValue + Math.random() - .5;
            cpp.getData().add(new XYChart.Data(Integer.toString(i), cppValue));
            cppValue = cppValue + 2 * Math.random() - 1;
        }
        java.setName("java");
        c.setName("C");
        cpp.setName("C++");
        answer.addAll(java, c, cpp);
        return answer;
    }
}

