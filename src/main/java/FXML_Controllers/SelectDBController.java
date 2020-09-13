package FXML_Controllers;

import Visitor_Pattern.Visit;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoVisitor;
import Visitor_Pattern.Visitors;
import javafx.fxml.FXML;

import java.io.IOException;

public class SelectDBController {

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
    @FXML
    private void detailButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.DETAIL);
    }
    @FXML
    private void workButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        daoPart.accept(new Visit(), Visitors.WORK);
    }
}