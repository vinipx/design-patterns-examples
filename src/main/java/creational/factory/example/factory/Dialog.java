package creational.factory.example.factory;

import creational.factory.example.button.Button;

// Base factory class. Usually contains also business logic which require "products" to be created.
public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButtonFactory();
        okButton.render();
    }

    // All Subclasses are required to override ths method in order to create desired button objects.
    public abstract Button createButtonFactory();
}
