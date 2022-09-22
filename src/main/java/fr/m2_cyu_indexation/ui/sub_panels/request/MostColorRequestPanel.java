package fr.m2_cyu_indexation.ui.sub_panels.request;

import fr.m2_cyu_indexation.engine.business.request.most_color.DominantColorType;
import fr.m2_cyu_indexation.engine.business.request.most_color.RecessiveColorType;
import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.results.ResultPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class MostColorRequestPanel extends AbstractRequestFormPanel {

    public static final Dimension CENTER_DIMENSIONS = RequestPanel.CENTER_DIMENSIONS;

    private ButtonGroup dominantColorButtonGroup = new ButtonGroup();
    private ButtonGroup recessiveColorButtonGroup = new ButtonGroup();

    public MostColorRequestPanel(MainWindow context) {
        super(context);
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 0));
        JPanel leftPane = createLeftPane();
        JPanel rightPane = createRightPane();

        add(leftPane);
        add(rightPane);
    }

    private JPanel createLeftPane() {
        JPanel leftPane = new JPanel();
        leftPane.setLayout(new GridLayout(1, 0));
        leftPane.add(new JLabel("Dominant color"));

        JPanel dominantColorChoicePanel = new JPanel(new GridLayout(0, 1));

        boolean select = false;
        for (DominantColorType type : DominantColorType.values()) {
            JRadioButton radioButton;
            if (!select) {
                radioButton = new JRadioButton(type.name(), true);
                select = true;
            } else {
                radioButton = new JRadioButton(type.name());
            }

            radioButton.setActionCommand(type.name());

            dominantColorChoicePanel.add(radioButton);
            dominantColorButtonGroup.add(radioButton);
        }

        leftPane.add(dominantColorChoicePanel);
        return leftPane;
    }

    private JPanel createRightPane() {
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new GridLayout(1, 0));
        rightPane.add(new JLabel("Recessive color"));

        JPanel ressColorChoicePanel = new JPanel(new GridLayout(0, 1));

        boolean select = false;
        for (RecessiveColorType type : RecessiveColorType.values()) {
            JRadioButton radioButton;
            if (!select) {
                radioButton = new JRadioButton(type.name(), true);
                select = true;
            } else {
                radioButton = new JRadioButton(type.name());
            }

            radioButton.setActionCommand(type.name());

            ressColorChoicePanel.add(radioButton);
            recessiveColorButtonGroup.add(radioButton);
        }

        rightPane.add(ressColorChoicePanel);
        return rightPane;
    }

    @Override
    public void submitForm() {
        System.out.println("Submit most color request");
        String dominantColor = dominantColorButtonGroup.getSelection().getActionCommand();
        String recessiveColor = recessiveColorButtonGroup.getSelection().getActionCommand();
        // TODO pass request to the engine
        context.switchPanel(new ResultPanel(context));
        System.out.println(dominantColor + " " + recessiveColor);
    }
}
