package com.hillel.page;

import com.hillel.core.CommonMethods;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class QAAutomation {
    CommonMethods commonMethods = new CommonMethods();


    public void waitFor(){
        commonMethods.WaitFor("//span[@class='course-descriptor_course-text']");
    }
    public void backToHomePage(){
        commonMethods.BackToHomePage("//a[@class='site-logo-link']");
    }
}
