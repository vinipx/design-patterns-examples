package creational.factory.example.factory;

import creational.factory.example.button.Button;
import creational.factory.example.button.LinuxButton;

public class LinuxDialog extends Dialog {
    @Override
    public Button createButtonFactory() {
        return new LinuxButton();
    }
}
