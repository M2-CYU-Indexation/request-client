package fr.m2_cyu_indexation.engine.persistence.oracle;

import fr.m2_cyu_indexation.engine.dao.ImageDao;

/**
 * A dao implementation using Jdbc on Oracle database.
 *
 * @author Aldric Vitali Silvestre
 */
public class OracleImageDao implements ImageDao {

    private final OracleConnectionHandler connectionHandler;

    public OracleImageDao(OracleConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }


}
