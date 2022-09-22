package fr.m2_cyu_indexation.ui.sub_panels.results;

import fr.m2_cyu_indexation.ui.GuiPreferences;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class ResultPanel extends AbstractSubPanel {

    public static final Dimension TOP_DIMENSIONS = new Dimension(GuiPreferences.WIDTH, GuiPreferences.HEIGHT / 6);

    public static final Dimension CENTER_DIMENSIONS = new Dimension(GuiPreferences.WIDTH,
                                                                    4 * GuiPreferences.HEIGHT / 6
    );
    public static final Dimension BOTTOM_DIMENSIONS = new Dimension(GuiPreferences.WIDTH, GuiPreferences.HEIGHT / 6);

    public ResultPanel(MainWindow context) {
        super(context);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        StatsPanel statsPanel = new StatsPanel(context);
        statsPanel.setPreferredSize(TOP_DIMENSIONS);
        add(statsPanel, BorderLayout.NORTH);

        ImageGridPanel imageGridPanel = new ImageGridPanel(context);
        JScrollPane scrollPane = new JScrollPane(imageGridPanel,
                                                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setPreferredSize(CENTER_DIMENSIONS);
        add(scrollPane, BorderLayout.CENTER);

        ReturnButtonPanel returnButtonPanel = new ReturnButtonPanel(context);
        returnButtonPanel.setPreferredSize(BOTTOM_DIMENSIONS);
        add(returnButtonPanel, BorderLayout.SOUTH);
    }
}
