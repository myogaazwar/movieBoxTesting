package utilities.JavascriptsUtill;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Utility;

public class JavaScriptUtility extends Utility {
    public static void scrollToElementJS(By locator) {
        WebElement element = Utility.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String jsScript = "arguments[0].scrollIntoView()";

        JavascriptExecutor executor = (JavascriptExecutor) Utility.driver;
        executor.executeScript(jsScript, element);
    }
}
