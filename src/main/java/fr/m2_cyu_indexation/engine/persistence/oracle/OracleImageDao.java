package fr.m2_cyu_indexation.engine.persistence.oracle;

import fr.m2_cyu_indexation.engine.business.request.most_color.DominantColorType;
import fr.m2_cyu_indexation.engine.business.request.most_color.RecessiveColorType;
import fr.m2_cyu_indexation.engine.business.response.ImageResponse;
import fr.m2_cyu_indexation.engine.dao.ImageDao;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String dominantpart = "";
        String recessivepart = "";
        switch (dominantColorType){
            case RED:
                dominantpart = "redRatio > 0.5 ";
                break;
            case BLUE:
                dominantpart = "blueRatio > 0.5 ";
                break;
            case GREEN:
                dominantpart = "greenRatio > 0.5 ";
                break;
        }

        switch (recessiveColorType){
            case RED:
                recessivepart = " AND redRatio < 0.2 ";
                break;
            case BLUE:
                recessivepart = " AND blueRatio < 0.2 ";
                break;
            case GREEN:
                recessivepart = " AND greenRatio < 0.2 ";
                break;
        }
        String query = "select imageName, nbOutlinePixel, averageColor from imageTable where "+dominantpart + " " + recessivepart+";";
        List<ImageResponse> responseList = new ArrayList<ImageResponse>();

        try (
                PreparedStatement statement = connectionHandler.createPreparedStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            statement.execute();
            while (resultSet.next()){
                ImageResponse resp = new ImageResponse(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                responseList.add(resp);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return List.of();
        }

        return responseList;
    }

    @Override
    public List<ImageResponse> findGreyscaleImages() {
        String query = "select imageName, nbOutlinePixel, averageColor from imageTable where isRGB = 0;";
        List<ImageResponse> responseList = new ArrayList<ImageResponse>();

        try (
                PreparedStatement statement = connectionHandler.createPreparedStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            statement.execute();
            while (resultSet.next()){
                ImageResponse resp = new ImageResponse(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                responseList.add(resp);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return List.of();
        }

        return responseList;

    }

    @Override
    public List<ImageResponse> findSimilarImages(String imageName) {

        String query = "select imageName, nbOutlinePixel, averageColor from imageTable where distanceimagemetadatas(\'"+imageName+"\', imagename) < 50;";
        List<ImageResponse> responseList = new ArrayList<ImageResponse>();

        try (
                PreparedStatement statement = connectionHandler.createPreparedStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            statement.execute();
            while (resultSet.next()){
                ImageResponse resp = new ImageResponse(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                responseList.add(resp);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return List.of();
        }

        return responseList;
    }

    @Override
    public List<ImageResponse> findTexturedImages() {

        String query = "select imageName, nboutlinepixel, averageColor from imageTable where nboutlinepixel > 20000;";
        List<ImageResponse> responseList = new ArrayList<ImageResponse>();

        try (
                PreparedStatement statement = connectionHandler.createPreparedStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            statement.execute();
            while (resultSet.next()){
                ImageResponse resp = new ImageResponse(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                responseList.add(resp);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return List.of();
        }

        return responseList;
    }

    @Override
    public List<ImageResponse> findImagesWithCenteredInterest() {
        String query = "select imageName, nboutlinepixel, averageColor from imageTable where outlinesbarycenterx < width/2 + 10 AND outlinesbarycenterx > width/2 - 10 AND outlinesbarycentery < height/2 + 10 AND outlinesbarycentery > height/2 - 10 ;";
        List<ImageResponse> responseList = new ArrayList<ImageResponse>();

        try (
                PreparedStatement statement = connectionHandler.createPreparedStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            statement.execute();
            while (resultSet.next()){
                ImageResponse resp = new ImageResponse(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                responseList.add(resp);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return List.of();
        }

        return responseList;
    }

    @Override
    public byte[] downloadImageData(String imageName) {
        return new byte[0];
    }
}
