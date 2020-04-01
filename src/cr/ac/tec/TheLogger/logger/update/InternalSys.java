package CR.AC.TEC.TheLogger.logger.update;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InternalSys {
    private final static Logger LOGGER = Logger.getLogger("CR.AC.TEC.TheLogger.logger.update.InternalSys");

    public void llamadaSistema(){
        LOGGER.log(Level.WARNING, "Ocurrio un error de acceso en 0xFF");
    }
}