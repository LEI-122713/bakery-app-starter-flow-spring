package com.vaadin.starter.bakery.ui.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

/**
 * A custom {@link Dialog} that manages navigation history when opened or closed.
 * <p>
 * This dialog adds a "Back" button that, when clicked, navigates the browser
 * history one step back and closes the dialog. Additionally, when the dialog
 * is opened, it pushes a new state ("home") into the browser history.
 * </p>
 *
 * <h2>Behavior</h2>
 * <ul>
 *   <li><strong>Back button:</strong> Navigates back in the browser history
 *   and closes the dialog.</li>
 *   <li><strong>On open:</strong> Pushes a new state called {@code "home"}
 *   into the history stack.</li>
 * </ul>
 *
 * This component is useful for scenarios where a modal dialog also needs to
 * interact with browser navigation, ensuring a consistent user experience.
 */
public class RouteChangingDialog extends Dialog {

    /**
     * Creates a new {@code RouteChangingDialog} with a "Back" button and a
     * listener for opened state changes.
     * <p>
     * - The "Back" button triggers {@link UI#getCurrent()} navigation one step back
     *   in history and closes the dialog.
     * - When the dialog is opened, it pushes a {@code "home"} state into the
     *   browser's history stack.
     * </p>
     */
    public RouteChangingDialog() {
        Button backButton = new Button("Back", e -> {
            UI.getCurrent().getPage().getHistory().back();
            close();
        });
        add(backButton);

        addOpenedChangeListener(e -> {
            if (isOpened()) {
                UI.getCurrent().getPage().getHistory().pushState(null, "home");
            }
        });
    }
}
