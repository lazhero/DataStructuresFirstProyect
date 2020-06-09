package cr.ac.tec.TheLogger.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {
    private final static Logger LOGGER = Logger.getLogger("CR.AC.TEC.TheLogger.logger.Utilidades");

    /**
     *
     */
    public void funcionDudosa(){
        LOGGER.log(Level.SEVERE, "ERROR");
    }
}
