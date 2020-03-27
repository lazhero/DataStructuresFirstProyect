package CR.AC.TEC.Datos1.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Control {
    private final static Logger LOGGER = Logger.getLogger("CR.AC.TEC.Datos1.logger.Control");

    public void controlar() {
        LOGGER.log(Level.INFO, "Succes Process");
    }
}