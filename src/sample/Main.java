package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<String> directories= new ArrayList<>();
    public static ArrayList<Files> allFiles= new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        File file=new File("J:\\movies\\sample");
        search(file);
        for (Files c: allFiles){
            System.out.println(c.getPath());
        }
    }

    //add the directories and files seperately to the arraylist
    public static void search(File dir){
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {


                    search(file);
                } else {
                    Files fil = new Files();
                    String name=file.getName();
                    long size=file.length();
                    fil.setName(name);
                    fil.setTotalSpace(size);
                    fil.setPath(file.getCanonicalPath());
                    allFiles.add(fil);


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
