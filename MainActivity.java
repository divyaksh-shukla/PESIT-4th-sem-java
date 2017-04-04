package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class MainActivity extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane root = new GridPane();
        int height = (int) primaryStage.getMaxHeight();
        int width = (int) primaryStage.getMaxWidth();
        primaryStage.setTitle("Lift Project v1");

        Text textFloorOne = new Text("1");
        Text textFloorTwo = new Text("2");
        Text textFloorThree = new Text("3");
        Text textFloorFour = new Text("4");
        root.add(textFloorOne,0,0);
        root.add(textFloorTwo,0,1);
        root.add(textFloorThree,0,2);
        root.add(textFloorFour,0,3);

        int offset = 1;
        Separator separator = new Separator(Orientation.VERTICAL);
        root.add(separator,1,0);

        Button btnOne1 = new Button("1");
        Button btnTwo1 = new Button("2");
        Button btnThree1 = new Button("3");
        Button btnFour1 = new Button("4");
        root.add(btnOne1,1+offset,0);
        root.add(btnTwo1,2+offset,0);
        root.add(btnThree1,3+offset,0);
        root.add(btnFour1,4+offset,0);

        Button btnOne2 = new Button("1");
        Button btnTwo2 = new Button("2");
        Button btnThree2 = new Button("3");
        Button btnFour2 = new Button("4");
        root.add(btnOne2,1+offset,1);
        root.add(btnTwo2,2+offset,1);
        root.add(btnThree2,3+offset,1);
        root.add(btnFour2,4+offset,1);

        Button btnOne3 = new Button("1");
        Button btnTwo3 = new Button("2");
        Button btnThree3 = new Button("3");
        Button btnFour3 = new Button("4");
        root.add(btnOne3,1+offset,2);
        root.add(btnTwo3,2+offset,2);
        root.add(btnThree3,3+offset,2);
        root.add(btnFour3,4+offset,2);

        Button btnOne4 = new Button("1");
        Button btnTwo4 = new Button("2");
        Button btnThree4 = new Button("3");
        Button btnFour4 = new Button("4");
        root.add(btnOne4,1+offset,3);
        root.add(btnTwo4,2+offset,3);
        root.add(btnThree4,3+offset,3);
        root.add(btnFour4,4+offset,3);

        //primaryStage.setScene(new Scene(root, height, width));
        primaryStage.setScene(new Scene(root,300,270));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

