package fr.m2_cyu_indexation.ui.sub_panels.request;

import fr.m2_cyu_indexation.ui.MainWindow;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;

import javax.swing.*;

/**
 * @author Aldric Vitali Silvestre
 */
public abstract class AbstractRequestFormPanel extends AbstractSubPanel {

    public AbstractRequestFormPanel(MainWindow context) {
        super(context);
    }

    public abstract void submitForm();
}
