package ru.test.HW.dz3;



class LightTheme implements Theme {
    @Override
    public void apply() {
        System.out.println("Применение световой темы");
    }
}


class DarkTheme implements Theme {
    @Override
    public void apply() {
        System.out.println("Применение темной темы");
    }
}


interface UIElement {
    void render();
}


class LightButton implements UIElement {
    @Override
    public void render() {
        System.out.println("Рендеринг светлой кнопки");
    }
}


class DarkButton implements UIElement {
    @Override
    public void render() {
        System.out.println("Рендеринг темной кнопки");
    }
}


interface UIFactory {
    Theme createTheme();
    UIElement createButton();
}


class LightUIFactory implements UIFactory {
    @Override
    public Theme createTheme() {
        return new LightTheme();
    }

    @Override
    public UIElement createButton() {
        return new LightButton();
    }
}


class DarkUIFactory implements UIFactory {
    @Override
    public Theme createTheme() {
        return new DarkTheme();
    }

    @Override
    public UIElement createButton() {
        return new DarkButton();
    }
}

// Пример использования
public class AbstractFactorySimpleExample {
    public static void main(String[] args) {
        UIFactory lightFactory = new LightUIFactory();
        Theme lightTheme = lightFactory.createTheme();
        UIElement lightButton = lightFactory.createButton();
        lightTheme.apply();
        lightButton.render();

        UIFactory darkFactory = new DarkUIFactory();
        Theme darkTheme = darkFactory.createTheme();
        UIElement darkButton = darkFactory.createButton();
        darkTheme.apply();
        darkButton.render();
    }
}