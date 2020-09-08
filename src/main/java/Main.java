import JavaFX.Actions;
import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.Visitors.DaoVisitor;
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
        Actions actions = new Actions();
        actions.selectTableFromDataBase(stage, new CarDaoPartDisplayVisitor());
    }
}
