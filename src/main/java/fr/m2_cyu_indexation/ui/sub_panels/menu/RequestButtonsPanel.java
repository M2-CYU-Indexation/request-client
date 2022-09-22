package fr.m2_cyu_indexation.ui.sub_panels.menu;

import fr.m2_cyu_indexation.ui.GuiPreferences;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;
import fr.m2_cyu_indexation.ui.sub_panels.request.RequestPanel;
import fr.m2_cyu_indexation.ui.sub_panels.request.MostColorRequestPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * @author Aldric Vitali Silvestre
 */
public class RequestButtonsPanel extends AbstractSubPanel {

    public static final Font BUTTON_FONT = GuiPreferences.BASE_FONT.deriveFont((float) (GuiPreferences.WIDTH / 80.0));

    public RequestButtonsPanel(MainWindow context) {
        super(context);
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        add(createRequestButton("Request color dominance", this::createMostColorRequestPanel));
        add(createVerticalSpacing());

    }

    private Component createVerticalSpacing() {
        return Box.createVerticalGlue();
    }

    private JButton createRequestButton(String name, Supplier<RequestPanel> panelSupplier) {
        JButton button = new JButton(name);
        button.setFont(BUTTON_FONT);
        button.addActionListener(event -> {
            context.switchPanel(panelSupplier.get());
        });
        return button;
    }

    private RequestPanel createMostColorRequestPanel() {
        return new RequestPanel(
                context,
                "Most color request",
                new MostColorRequestPanel(context)
        );
    }
}
