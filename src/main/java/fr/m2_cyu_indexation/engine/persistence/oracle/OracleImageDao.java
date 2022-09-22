package fr.m2_cyu_indexation.engine.persistence.oracle;

import fr.m2_cyu_indexation.engine.business.request.most_color.DominantColorType;
import fr.m2_cyu_indexation.engine.business.request.most_color.RecessiveColorType;
import fr.m2_cyu_indexation.engine.business.response.ImageResponse;
import fr.m2_cyu_indexation.engine.dao.ImageDao;

import java.util.List;

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


    @Override
    public List<ImageResponse> findByDominantColor(DominantColorType dominantColorType,
                                                   RecessiveColorType recessiveColorType) {
        return null;
    }

    @Override
    public List<ImageResponse> findGreyscaleImages() {
        return null;
    }

    @Override
    public List<ImageResponse> findSimilarImages(String imageName) {
        return null;
    }

    @Override
    public List<ImageResponse> findTexturedImages() {
        return null;
    }

    @Override
    public List<ImageResponse> findImagesWithCenteredInterest() {
        return null;
    }

    @Override
    public byte[] downloadImageData(String imageName) {
        return new byte[0];
    }
}
