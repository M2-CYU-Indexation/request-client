package fr.m2_cyu_indexation.ui;

/**
 * An enum storing all panels with
 *
 * @author Aldric Vitali Silvestre
 */
public enum WindowPanel {
    HOME("HOME"),
    REQUEST_SELECT("REQUEST_SELECT");

    private final String windowName;

    WindowPanel(String windowName) {
        this.windowName = windowName;
    }

    public String windowName() {
        return windowName;
    }
}
