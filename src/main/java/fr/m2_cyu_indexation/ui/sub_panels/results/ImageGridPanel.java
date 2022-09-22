package fr.m2_cyu_indexation.ui.sub_panels.results;

import fr.m2_cyu_indexation.ui.GuiPreferences;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class ImageGridPanel extends AbstractSubPanel {


    public static final Dimension CENTER_DIMENSIONS = ResultPanel.CENTER_DIMENSIONS;
    public static final Dimension ITEM_DIMENSIONS = new Dimension(CENTER_DIMENSIONS.width / 3 - CENTER_DIMENSIONS.width / 20,
                                                                  CENTER_DIMENSIONS.height / 2
    );

    public ImageGridPanel(MainWindow context) {
        super(context);
        init();
    }

    private void init() {
        setLayout(new GridLayout(0, 3, CENTER_DIMENSIONS.width / 20, CENTER_DIMENSIONS.height / 10));
        for (int i = 0; i < 30; i++) {
            ImgGridItem imgGridItem = new ImgGridItem(context, "" + i + ".jpg");
            imgGridItem.setPreferredSize(ITEM_DIMENSIONS);
            add(imgGridItem);
        }
    }
}
