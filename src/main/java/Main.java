import JavaFX.Actions;
import Visitor_Pattern.CarDaoPartDisplayVisitor;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        /*HibernateUtil.getSessionFactory();
        HibernateUtil.shutdown();*/

        Main.launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        /*new Actions().selectTableFromDataBase(stage);*/
        CarDaoPartDisplayVisitor carDaoPartDisplayVisitor = new CarDaoPartDisplayVisitor();

        carDaoPartDisplayVisitor.create(stage);
    }
}
