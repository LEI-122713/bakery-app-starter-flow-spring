package com.vaadin.starter.bakery.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

/**
 * {@code GridComponent} is a custom Vaadin {@link Grid} that displays integers
 * and provides a button in each row. When clicked, the button opens a
 * {@link RouteChangingDialog}.
 * <p>
 * This component is a Spring-managed bean with UI scope, meaning its lifecycle
 * is tied to the UI instance.
 */
@SpringComponent
@UIScope
public class GridComponent extends Grid<Integer> {

    /**
     * Constructs a new {@code GridComponent}. Initializes the grid with
     * a set of integer items and adds a column that renders a button for
     * each integer value.
     */
    public GridComponent() {
        setItems(0, 1);
        addComponentColumn(i -> createButton(i));
    }

    /**
     * Creates a button for the given integer value. The button's label includes
     * the integer, and clicking the button will open a new instance of
     * {@link RouteChangingDialog}.
     *
     * @param i the integer value associated with the button
     * @return a Vaadin {@link Button} component bound to the given integer
     */
    private Button createButton(Integer i) {
        return new Button("Test Button " + i, e -> {
            RouteChangingDialog dialog = new RouteChangingDialog();
            dialog.open();
        });
    }

}
