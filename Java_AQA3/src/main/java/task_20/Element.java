package task_20;

import org.openqa.selenium.WebElement;

public class Element {
    private final WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    public void click() {
        System.out.println("Clicking element: " + element);
        element.click();
    }

    public String getText() {
        return element.getText();
    }
}