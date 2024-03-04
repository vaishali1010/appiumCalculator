package Screens;

import Base.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Calculator {

    public final String PACKAGE_ID="com.google.android.calculator";
    AndroidDriver driver;
    Utility util;
    private By plus=By.id(PACKAGE_ID+":id/op_add");
    private By minus=By.id(PACKAGE_ID+":id/op_sub");
    private By multiply=By.id(PACKAGE_ID+":id/op_mul");
    private By divide=By.id(PACKAGE_ID+":id/op_div");
    private By equals=By.id(PACKAGE_ID+":id/eq");
    private By clear=By.id(PACKAGE_ID+":id/clr");
    private By result=By.id(PACKAGE_ID+":id/result_final");
    private By digit0=By.id(PACKAGE_ID+":id/digit_0");
    private By digit1=By.id(PACKAGE_ID+":id/digit_1");
    private By digit2=By.id(PACKAGE_ID+":id/digit_2");
    private By digit3=By.id(PACKAGE_ID+":id/digit_3");
    private By digit4=By.id(PACKAGE_ID+":id/digit_4");
    private By digit5=By.id(PACKAGE_ID+":id/digit_5");
    private By digit6=By.id(PACKAGE_ID+":id/digit_6");
    private By digit7=By.id(PACKAGE_ID+":id/digit_7");
    private By digit8=By.id(PACKAGE_ID+":id/digit_8");
    private By digit9=By.id(PACKAGE_ID+":id/digit_9");

    public Calculator(AndroidDriver driver) {
        this.driver = driver;
        util = new Utility(driver);
    }

    public String sum(){
        util.doClick(digit2);
        util.doClick(plus);
        util.doClick(digit4);
        util.doClick(equals);
        return util.getElement(result).getText();
    }

    public String sub(){
        util.doClick(digit8);
        util.doClick(minus);
        util.doClick(digit5);
        util.doClick(equals);
        return util.getElement(result).getText();
    }

    public String multi(){
        util.doClick(digit7);
        util.doClick(multiply);
        util.doClick(digit6);
        util.doClick(equals);
        return util.getElement(result).getText();
    }

    public String divide(){
        util.doClick(digit9);
        util.doClick(divide);
        util.doClick(digit3);
        util.doClick(equals);
        return util.getElement(result).getText();
    }

    public void clearResult(){
        util.doClick(clear);
    }
}
