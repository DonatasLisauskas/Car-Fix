package Visitor_Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DaoVisitor implements DaoPart {

    private static final Logger LOGGER = LogManager.getLogger(DaoVisitor.class);

    @Override
    public void accept(VisitPart visitPart, Visitors visitors) throws IOException {
        try {
            visitPart.visit(visitors);
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }
}
