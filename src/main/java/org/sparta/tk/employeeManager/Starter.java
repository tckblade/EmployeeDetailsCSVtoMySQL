package org.sparta.tk.employeeManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class Starter
{

    static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    static Logger log = Logger.getLogger(Starter.class.getName());
    public static void main( String[] args )
    {
        initialiseLogging();
        log.debug("Application Started");
    }
    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }
}
