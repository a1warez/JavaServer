package ru.test.HW.dz3;



class PrimaryButton implements Button {
    @Override
    public void onClick() {
        System.out.println("Нажата основная кнопка");
    }
}

class SecondaryButton implements Button {
    @Override
    public void onClick() {
        System.out.println("Нажата дополнительная кнопка");
    }
}

abstract class ButtonCreator {
    public abstract Button createButton();
}

class PrimaryButtonCreator extends ButtonCreator {
    @Override
    public Button createButton() {
        return new PrimaryButton();
    }
}

class SecondaryButtonCreator extends ButtonCreator {
    @Override
    public Button createButton() {
        return new SecondaryButton();
    }
}

public class FactoryMethodSimpleExample {
    public static void main(String[] args) {
        ButtonCreator primaryCreator = new PrimaryButtonCreator();
        Button primaryButton = primaryCreator.createButton();
        primaryButton.onClick();

        ButtonCreator secondaryCreator = new SecondaryButtonCreator();
        Button secondaryButton = secondaryCreator.createButton();
        secondaryButton.onClick();
    }
}

