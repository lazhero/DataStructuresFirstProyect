package cr.ac.tec.TheLogger;

import cr.ac.tec.TheLogger.logger.Control;
import cr.ac.tec.TheLogger.logger.Utilidades;
import cr.ac.tec.TheLogger.logger.update.InternalSys;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;




public class Loggger {

    private final static Logger LOG_RAIZ = Logger.getLogger("CR.AC.TEC.TheLogger");
    private final static Logger LOG_SUBNIVEL = Logger.getLogger("CR.AC.TEC.TheLogger.logger");
    private final static Logger LOG_UNDER = Logger.getLogger("CR.AC.TEC.TheLogger.logger.update");
    private final static Logger LOGGER = Logger.getLogger("CR.AC.TEC.TheLogger.Loggger");

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {

            Handler consoleHandler = new ConsoleHandler();

            Handler fileHandler = new FileHandler("./CR.AC.TEC.TheLogger.log", false);

            SimpleFormatter simpleFormatter = new SimpleFormatter();

            fileHandler.setFormatter(simpleFormatter);

            LOG_RAIZ.addHandler(consoleHandler);
            LOG_RAIZ.addHandler(fileHandler);

            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);

            LOGGER.log(Level.INFO, "Bitacora inicializada");


            Utilidades util = new Utilidades();
            Control control = new Control();
            InternalSys internalSys = new InternalSys();


            LOGGER.log(Level.INFO, "Llamadas a los componentes del sistema");

            util.funcionDudosa();
            control.controlar();
            internalSys.llamadaSistema();

            LOGGER.log(Level.INFO, "Probando manejo de excepciones");

            try {
                throw new Exception("ERROR DE CONTROL DE FLUJO DE PROGRAMA");
            } catch (Exception e) {

                LOGGER.log(Level.SEVERE, Loggger.getStackTrace(e));
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error de IO");
        } catch (SecurityException ex) {
            LOGGER.log(Level.SEVERE, "Error de Seguridad");
            
        }
    }

    /**
     *
     * @param e
     * @return
     */
    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}