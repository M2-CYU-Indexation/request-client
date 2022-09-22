package fr.m2_cyu_indexation.engine.persistence.oracle;

import fr.m2_cyu_indexation.config.OracleConfig;
import oracle.jdbc.OracleConnection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The holder of the connection to the oracle database.
 *
 * @apiNote The class is intended to be used in a try-with-resources block in order to have the
 * connection to automatically close whatever happens.
 *
 * @author Aldric Vitali Silvestre
 */
public class OracleConnectionHandler implements AutoCloseable {

    private OracleConnection connection;

    public OracleConnectionHandler(String username, String password, String ip, int port, String sid) throws SQLException {
        System.out.println("Create connection to oracledb");
        // Oracle driver implementation always returns a OracleConnection instance,
        // but no way to avoid the cast here
        connection = (OracleConnection) DriverManager.getConnection(
                createUrl(ip, port, sid),
                username,
                password
        );
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public PreparedStatement createPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public static OracleConnectionHandler fromConfig(OracleConfig config) throws SQLException {
        return new OracleConnectionHandler(
                config.getUsername(),
                config.getPassword(),
                config.getIpAddress(),
                config.getPort(),
                config.getSid()
        );
    }

    private String createUrl(String ip, int port, String sid) {
        return "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close oracledb connection");
        connection.close();
    }
}
