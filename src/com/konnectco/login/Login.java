package com.konnectco.login;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentTabularReporter;

public class Login {

	static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test1;
	static ExtentReports extent;

	public static WebDriver driver=null;

	@Test
	public void kLogin() throws Exception
	{
		System.out.println("Welcome");
		{
			System.out.println("Welcome to TestNG");

			WebActions actions=new WebActions();

			htmlReporter=new ExtentHtmlReporter(".//TestReport//extentreport.html");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			test1=extent.createTest("Launch Konnect");

			actions.launch();

			actions.navigate("http://qa.konnectco.com/");

			actions.driverwait(3);

			String mainWindow=driver.getWindowHandle();

			actions.enterText("//input[@id='UserName']", "swetha.ravula@freyrsolutions.com");

			actions.click("//input[@id='btnNext']");

			//actions.driverwait(3);

			Thread.sleep(4000);

			actions.selectFromDropDown("//div[@class='form-group']/select", "freyrsolutions.com");

			actions.enterText("//input[@id='Password1']", "123456");


			actions.click("//input[@id='btnSave']");

			//actions.driverwait(3);

			Thread.sleep(4000);

			actions.click("//a[contains(.,'My Leaves')]");

			String currentWindow=driver.getWindowHandle();

			if(!currentWindow.equals(mainWindow))
			{
				driver.close();
				driver.switchTo().window(mainWindow);
			}

			//actions.driverwait(2);

			Thread.sleep(4000);

			actions.click("//a[contains(.,'+ Apply Leave')]");

			Thread.sleep(4000);

			actions.click("//label[contains(.,'Leave Year')]/..//span[@class='k-select']");

			//actions.click("//li[contains(.,'LY - 01-Jan-2019 to 31-Dec-2019')]");

			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'LY - 01-Jan-2020 to 31-Dec-2020')]")));


			actions.click("//label[contains(.,'Select Month')]/..//span[@class='k-select']");

			//actions.click("//li[contains(.,'Apr - 2020')]");

			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'Apr - 2020')]")));


			//actions.selectFromDropDown("//select[@id='ddlMonth']", "May - 2020");

			actions.click("//label[contains(.,'Leave Type')]/..//span[@class='k-select']");

			//actions.click("//li[contains(.,'Casual - 0')]");

			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'Casual - 0')]")));

			Thread.sleep(4000);

			//actions.click("//div[@class='date-selection']/label[contains(.,'01')]");

			actions.enterText("//div[contains(.,'Reason')]/textarea", "Personal Day Off");

			actions.click("//label[text()='From']//following-sibling::input[contains(@class,'leaveDatePicker')]");

			actions.selectFromDropDown("//select[@class='ui-datepicker-month']", "Apr");

			actions.selectFromDropDown("//select[@class='ui-datepicker-year']", "2020");

			actions.click("//table[@class='ui-datepicker-calendar']//tr[3]//td[contains(.,'12')]");


			actions.click("//label[text()='To']//following-sibling::input[contains(@class,'leaveDatePicker')]");

			actions.selectFromDropDown("//select[@class='ui-datepicker-month']", "Apr");

			actions.selectFromDropDown("//select[@class='ui-datepicker-year']", "2020");

			actions.click("//table[@class='ui-datepicker-calendar']//tr[3]//td[contains(.,'14')]");

			actions.click("//button[contains(text(),'Apply')]");


			actions.quit();



			extent.flush();	

		}

	}
}
