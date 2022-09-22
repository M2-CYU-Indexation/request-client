package fr.m2_cyu_indexation.ui.sub_panels.results;

import fr.m2_cyu_indexation.ui.GuiPreferences;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;
import fr.m2_cyu_indexation.ui.sub_panels.menu.MenuPanel;
import fr.m2_cyu_indexation.ui.sub_panels.request.RequestPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class ReturnButtonPanel extends AbstractSubPanel {

    public static final Dimension DIMENSIONS = ResultPanel.BOTTOM_DIMENSIONS;

    public static final Font BUTTON_FONT = GuiPreferences.BASE_FONT.deriveFont((float) (GuiPreferences.WIDTH / 80.0));

    public ReturnButtonPanel(MainWindow context) {
        super(context);
        setLayout(new BorderLayout());
        add(createMenuButton(), BorderLayout.CENTER);
    }

    public JButton createMenuButton() {
        JButton button = new JButton("Cancel");
        button.setFont(BUTTON_FONT);
        button.setPreferredSize(DIMENSIONS);
        button.addActionListener(event -> {
            context.switchPanel(new MenuPanel(context));
        });
        return button;
    }
}
