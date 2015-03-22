/**
 * ServerUnitTests.java
 * JRE v1.8.0_40
 * 
 * Created by William Myers on Mar 22, 2015.
 * Copyright (c) 2015 William Myers. All Rights reserved.
 */
package server;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerUnitTests.
 */
public class ServerUnitTests {
    /** The logger. */
    private static Logger logger;
public final static String LOG_NAME = "serverTest";
    /**
     * Teardown.
     */
    @After
    public void teardown() {

    }

    /**
     * Test_1.
     */
    @Test
    public void test_1() {
        assertEquals("OK", "OK");
        assertTrue(true);
        assertFalse(false);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            final FileInputStream is = new FileInputStream("logging.properties");
            LogManager.getLogManager().readConfiguration(is);
            logger = Logger.getLogger(LOG_NAME);
        } catch (final IOException e) {
            Logger.getAnonymousLogger().severe("ERROR: unable to load logging propeties file...");
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        logger.info("Running all server tests...");
        String[] testClasses =
                new String[] {"server.ServerUnitTests", "server.database.BatchDAOUnitTest",
                        "server.database.FieldDAOUnitTest", "server.database.ProjectDAOUnitTest",
                        "server.database.RecordDAOUnitTest", "server.database.UserDAOUnitTest",
                        "server.ImporterUnitTest"};
        org.junit.runner.JUnitCore.main(testClasses);
    }
}
