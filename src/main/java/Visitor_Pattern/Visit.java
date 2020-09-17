package Visitor_Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class Visit extends VisitPart {

    private static final Logger LOGGER = LogManager.getLogger(Visit.class);

    @Override
    public void visit(Visitors visitors) throws IOException {

        switch (visitors) {
            case CAR:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Car_DB_FXML/CrudCar.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudCar.fxml is opened!\u001B[0m");
                }
                break;
            case CAR_SERVICE:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Car_Service_DB_FXML/CrudCarService.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudCarService.fxml is opened!\u001B[0m");
                }
                break;
            case CUSTOMER:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Customer_DB_FXML/CrudCustomer.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudCustomer.fxml is opened!\u001B[0m");
                }
                break;
            case FAILURE:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Failure_DB_FXML/CrudFailure.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudFailure.fxml is opened!\u001B[0m");
                }
                break;
            case DETAIL:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Detail_DB_FXML/CrudDetail.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudDetail.fxml is opened!\u001B[0m");
                }
                break;
            case WORK:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Work_DB_FXML/CrudWork.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudWork.fxml is opened!\u001B[0m");
                }
                break;
            case REGISTRATION:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Registration_DB_FXML/CrudRegistration.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudRegistration.fxml is opened!\u001B[0m");
                }
                break;
            case SCHEDULE:
                try {
                    LoaderFXML.loadFXML("/JavaFX/Schedule_DB_FXML/CrudSchedule.fxml");
                } catch (IOException ex) {
                    LOGGER.error(ex);
                } finally {
                    LOGGER.info("\u001B[33mVisitor visit: CrudSchedule.fxml is opened!\u001B[0m");
                }
                break;
        }
    }
}
