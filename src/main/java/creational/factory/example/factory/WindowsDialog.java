package creational.factory.example.factory;

import creational.factory.example.button.Button;
import creational.factory.example.button.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButtonFactory() {
        return new WindowsButton();
    }
}
