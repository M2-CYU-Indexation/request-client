package fr.m2_cyu_indexation.ui.sub_panels.results;

import fr.m2_cyu_indexation.ui.GuiPreferences;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Aldric Vitali Silvestre
 */
public class ImgGridItem extends AbstractSubPanel {

    public static final Dimension ITEM_DIMENSIONS = ImageGridPanel.ITEM_DIMENSIONS;
    public static final Dimension IMAGE_DIMENSIONS = new Dimension(ITEM_DIMENSIONS.width, 3 * ITEM_DIMENSIONS.height / 4);
    public static final Dimension NAME_DIMENSIONS = new Dimension(ITEM_DIMENSIONS.width, ITEM_DIMENSIONS.height / 4);
    public static final Font NAME_FONT = GuiPreferences.BASE_FONT.deriveFont((float) (NAME_DIMENSIONS.width / 30.0));

    private JLabel nameLabel;
    private JLabel imageLabel;
    private ImageIcon imageIcon;
    private BufferedImage image;

    public ImgGridItem(MainWindow context, String name) {
        super(context);
        init(name);
    }

    private void init(String name) {
        setLayout(new BorderLayout());
        image = new BufferedImage(IMAGE_DIMENSIONS.width, IMAGE_DIMENSIONS.height, BufferedImage.TYPE_3BYTE_BGR);
        Color color = randomColor();
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, color.getRGB());
            }
        }
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(IMAGE_DIMENSIONS);
        add(imageLabel, BorderLayout.CENTER);

        nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(NAME_FONT);
        nameLabel.setPreferredSize(NAME_DIMENSIONS);
        add(nameLabel, BorderLayout.SOUTH);
    }

    private Color randomColor() {
        float hue = (float) Math.random();
        int rgb = Color.HSBtoRGB(hue, 0.5f, 0.5f);
        return new Color(rgb);
    }
}
