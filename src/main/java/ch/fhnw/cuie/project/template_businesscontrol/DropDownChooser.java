package ch.fhnw.cuie.project.template_businesscontrol;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;


class DropDownChooser extends VBox {
    private static final String FONTS_CSS = "/fonts/fonts.css";
    private static final String STYLE_CSS = "dropDownChooser.css";

    private final BusinessControl businessControl;

    private Label tobeReplacedLabel;

    DropDownChooser(BusinessControl businessControl) {
        this.businessControl = businessControl;
        initializeSelf();
        initializeParts();
        layoutParts();
        setupBindings();
    }

    private void initializeSelf() {
        getStyleClass().add("drop-down-chooser");

        String fonts = getClass().getResource(FONTS_CSS).toExternalForm();
        getStylesheets().add(fonts);

        String stylesheet = getClass().getResource(STYLE_CSS).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeParts() {
        tobeReplacedLabel = new Label("to be replaced");
    }

    private void layoutParts() {
        getChildren().addAll(tobeReplacedLabel);
    }

    private void setupBindings() {
    }
}
