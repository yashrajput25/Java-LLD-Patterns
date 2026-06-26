package Creational_Design_Patterns;


interface Button{
    public void useButton();
}

interface Checkbox{
    public void useCheckbox();
}

class WindowsButton implements Button{
    public void useButton(){
        System.out.println("Using windows button");
    }
}


class WindowsCheckbox implements Checkbox{

    public void useCheckbox() {
        System.out.println("Using windows checkbox");
    }
}

class MacButton implements Button{
    @Override
    public void useButton() {
        System.out.println("Using Mac button");
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void useCheckbox() {
        System.out.println("Using Mac Checkbox");
    }
}


interface GUIFactory{
    public Button createButton();
    public Checkbox createCheckbox();
}


class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}


class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}


class GUIService{

    private Button button;
    private Checkbox checkbox;

    public GUIService(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render(){
        button.useButton();
        checkbox.useCheckbox();
    }
}



public class abstractFactoryPattern1 {
    public static void main (String[] args){
        GUIService app = new GUIService(new WindowsFactory());
        app.render();
    }
}
