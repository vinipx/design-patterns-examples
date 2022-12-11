package creational.factory.example;

import creational.factory.example.factory.Dialog;
import creational.factory.example.factory.LinuxDialog;
import creational.factory.example.factory.WindowsDialog;

public class FactoryExample {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runApplication();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new LinuxDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runApplication() {
        dialog.renderWindow();
    }
}