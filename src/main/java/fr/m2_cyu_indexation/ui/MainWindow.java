package fr.m2_cyu_indexation.ui;

import com.formdev.flatlaf.FlatLightLaf;
import fr.m2_cyu_indexation.ui.sub_panels.AbstractSubPanel;
import fr.m2_cyu_indexation.ui.sub_panels.menu.MenuPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aldric Vitali Silvestre
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        super("Requests Client");
        init();
        switchPanel(new MenuPanel(this));
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(GuiPreferences.WIDTH, GuiPreferences.HEIGHT));
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void switchPanel(AbstractSubPanel panel) {
        getContentPane().removeAll();
        panel.setPreferredSize(new Dimension(GuiPreferences.WIDTH, GuiPreferences.HEIGHT));
        pack();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().revalidate();
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
