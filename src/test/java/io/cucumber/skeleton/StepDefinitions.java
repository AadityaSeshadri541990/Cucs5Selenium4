package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.locators.RelativeLocator;


public class StepDefinitions {
    public static RemoteWebDriver driver;
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //************Get Element Screenshot************
        File f = driver.findElement(By.xpath("//input[@name='q']")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File(".//target//element.png"));

        //************Get Element Dimensions************
        int Height = driver.findElement(By.xpath("//input[@name='q']")).getRect().getHeight();
        int width = driver.findElement(By.xpath("//input[@name='q']")).getRect().getWidth();
        int X = driver.findElement(By.xpath("//input[@name='q']")).getRect().getX();
        int Y = driver.findElement(By.xpath("//input[@name='q']")).getRect().getY();
        System.out.println("Height---->"+Height+"width------->"+ width+"X------->"+ X+"Y------->"+Y);

        //************Open New Tabs on fly***************
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(3000);

        //*************Relative Locator*************
        //Clicking Business
        driver.findElement(RelativeLocator.withTagName("a").toRightOf(By.xpath("//*[contains(text(),'Adver')]"))).click();
        Thread.sleep(3000);


        driver.quit();
    }

    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("***********i_wait_hour**********");
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("***********my_belly_should_growl**********");
    }



}
