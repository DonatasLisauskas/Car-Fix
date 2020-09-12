package FXML_Controllers;

import Visitor_Pattern.Visit;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.Visitors.DaoVisitor;
import Visitor_Pattern.Visitors.Visitors;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SelectDBController {

    @FXML
    private TextField textField;
    @FXML
    private Label label;

    @FXML
    private void carDaoButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.CAR);
    }
    @FXML
    private void carServiceButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.CAR_SERVICE);
    }
    @FXML
    private void customerButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.CUSTOMER);
    }
    @FXML
    private void failureButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.FAILURE);
    }
}