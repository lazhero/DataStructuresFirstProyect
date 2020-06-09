package cr.ac.tec.TheLogger.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Control {
    private final static Logger LOGGER = Logger.getLogger("CR.AC.TEC.TheLogger.logger.Control");

    /**
     *
     */
    public void controlar() {
        LOGGER.log(Level.INFO, "Succes Process");
    }
}