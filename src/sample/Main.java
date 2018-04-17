package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
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

    }

    //add the directories and files seperately to the arraylist
    public static void search(String pathname){
        File folder = new File(pathname);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {


                Files files = new Files();
                String name=listOfFiles[i].getName();
                long size=listOfFiles[i].length();
                files.setName(name);
                files.setTotalSpace(size);
                files.setPath(pathname+"\\"+name);
                allFiles.add(files);


            } else if (listOfFiles[i].isDirectory()) {
                directories.add((folder.getPath()+"\\"+listOfFiles[i].getName()));
            }
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
