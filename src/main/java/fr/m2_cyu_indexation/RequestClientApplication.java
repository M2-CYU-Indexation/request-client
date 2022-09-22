package fr.m2_cyu_indexation;

import com.formdev.flatlaf.FlatLightLaf;
import fr.m2_cyu_indexation.config.Config;
import fr.m2_cyu_indexation.engine.dao.ImageDao;
import fr.m2_cyu_indexation.engine.persistence.oracle.OracleConnectionHandler;
import fr.m2_cyu_indexation.engine.persistence.oracle.OracleImageDao;
import fr.m2_cyu_indexation.ui.MainWindow;

import javax.swing.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class RequestClientApplication {

    public static void main(String[] args) {

        Config config = new Config();
        // Dependency injection part
        try (OracleConnectionHandler connectionHandler = OracleConnectionHandler.fromConfig(config.getOracleConfig())){
            ImageDao dao = new OracleImageDao(connectionHandler);

            // This provides a more modern look and feel to the UI
            FlatLightLaf.setup();

            SwingUtilities.invokeLater(() -> new MainWindow());

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}