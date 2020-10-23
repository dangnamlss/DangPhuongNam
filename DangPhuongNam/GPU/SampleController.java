package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;


public class SampleController extends DictionaryManagement {
    ArrayList<Word> dic;

    {
        try {
            dic = super.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField find;
    @FXML
    private TextField target;
    @FXML
    private TextField explain;
    @FXML
    private TextField type;
    @FXML
    private TextField pronun;

    @FXML
    public void Submit(ActionEvent event) {
        String wordTarget = find.getText();
        String wordExplain = null;
        String wordPronun = null;
        String wordType = null;
        boolean notExist = true;
        for (int i = 0; i < dic.size(); i++) {
            if (wordTarget.equals(dic.get(i).getWord_target())) {
                notExist = false;
                wordTarget = dic.get(i).getWord_target();
                wordExplain = dic.get(i).getWord_explain();
                wordPronun = dic.get(i).getWord_pronun();
                wordType = dic.get(i).getWord_type();
            }
        }
        if (!notExist) {
            target.setText(wordTarget);
            explain.setText(wordExplain);
            pronun.setText(wordPronun);
            type.setText(wordType);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Your word is not in the dictionary");
            alert.showAndWait();
        }
    }


    @FXML
    public void Add(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add Word");
        dialog.setHeaderText("Add Word");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        TextField target = new TextField();

        TextField pronun = new TextField();

        TextField type = new TextField();

        TextField explain = new TextField();

        target.setPromptText("Enter word");

        pronun.setPromptText("Pronunciation");

        type.setPromptText("Type");

        explain.setPromptText("Explain");


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        gridPane.add(new Label("Added word"), 0, 0);
        gridPane.add(target, 1, 0);
        gridPane.add(new Label("Pronuciation"), 0, 1);
        gridPane.add(pronun, 1, 1);
        gridPane.add(new Label("Type"), 0, 2);
        gridPane.add(type, 1, 2);
        gridPane.add(new Label("Explain"), 0, 3);
        gridPane.add(explain, 1, 3);

        dialog.getDialogPane().setContent(gridPane);
        dialog.close();

        Optional<ButtonType> result = dialog.showAndWait();
        result.ifPresent(response -> {
            if (response == ButtonType.OK) {
                String newTarget = target.getText();
                String newType = type.getText();
                String newPronun = pronun.getText();
                String newExplain = explain.getText();
                Word word = new Word(newTarget, newType, newPronun, newExplain);
                dic.add(word);

                try {
                    FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryGPU\\data\\wordAndMeaning");
                    for (int i = 0; i < dic.size(); i++) {
                        String string = dic.get(i).getWord_target() + "\t" + dic.get(i).getWord_type()
                                + "\t" + dic.get(i).getWord_pronun() + "\t" + dic.get(i).getWord_explain() + "\n";
                        fw.write(string);
                    }
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Add word");
                alert.setContentText("Success !!!");

                alert.showAndWait();
            }
        });

    }

    @FXML
    public void Edit(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Enter word");
        dialog.setHeaderText("Edit Word");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        TextField target = new TextField();

        TextField pronun = new TextField();

        TextField type = new TextField();

        TextField explain = new TextField();

        target.setPromptText("Enter word");

        pronun.setPromptText("Enter pronunciation");

        type.setPromptText("Enter Type");

        explain.setPromptText("Enter explain");


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        gridPane.add(new Label("Edit word"), 0, 0);
        gridPane.add(target, 1, 0);
        gridPane.add(new Label("Pronuciation"), 0, 1);
        gridPane.add(pronun, 1, 1);
        gridPane.add(new Label("Type"), 0, 2);
        gridPane.add(type, 1, 2);
        gridPane.add(new Label("Explain"), 0, 3);
        gridPane.add(explain, 1, 3);

        dialog.getDialogPane().setContent(gridPane);
        dialog.close();

        Optional<ButtonType> result = dialog.showAndWait();
        result.ifPresent(response -> {

            if (response == ButtonType.OK) {
                boolean notExist = true;
                String newTarget = target.getText();
                String newPronun = pronun.getText();
                String newType = type.getText();
                String newExplain = explain.getText();
                for (int i = 0; i < dic.size(); i++) {
                    if (newTarget.equals(dic.get(i).getWord_target())) {
                        notExist = false;
                        dic.get(i).setWord_type(newType);
                        dic.get(i).setWord_pronun(newPronun);
                        dic.get(i).setWord_explain(newExplain);

                        try {
                            FileWriter fileWriter = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryGPU\\data\\wordAndMeaning");
                            for (int j = 0; j < dic.size(); j++) {
                                String word = dic.get(j).getWord_target() + "\t"
                                        + dic.get(j).getWord_type() + "\t"
                                        + dic.get(j).getWord_pronun() + "\t"
                                        + dic.get(j).getWord_explain() + "\n";
                                fileWriter.write(word);
                            }
                            fileWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                }
                if (!notExist) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Edit successfully");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Not exist in my dictionary!");
                    alert.showAndWait();
                }
            }
        });
    }

    @FXML
    public void Erase(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Delete Word");
        dialog.setHeaderText("Delete Word");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        TextField target = new TextField();
        target.setPromptText("Enter word");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        gridPane.add(new Label("Delete word"), 0, 0);
        gridPane.add(target, 1, 0);

        dialog.getDialogPane().setContent(gridPane);
        dialog.close();

        Optional<ButtonType> result = dialog.showAndWait();
        result.ifPresent(respond -> {
            if (respond == ButtonType.OK) {
                boolean notExist = true;
                try {
                    String deleteTarget = target.getText();
                    for (int i = 0; i < dic.size(); i++) {
                        if (deleteTarget.equals(dic.get(i).getWord_target())) {
                            notExist = false;
                            dic.remove(i);
                        }
                    }
                    FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryGPU\\data\\wordAndMeaning");
                    for (int j = 0; j < dic.size(); j++) {
                        String newListWord = dic.get(j).getWord_target() + "\t" + dic.get(j).getWord_type() + "\t"
                                + dic.get(j).getWord_pronun() + "\t" + dic.get(j).getWord_explain() + "\n";
                        fw.write(newListWord);
                    }
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (!notExist) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Delete successfully!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Word is not exist in my dictionary");
                }
            }

        });
    }

}