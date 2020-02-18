package com.konnectco.login;


	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import com.aventstack.extentreports.Status;
			
	public class WebActions extends Login{
		public void launch()
		{
			try {
				System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");

				driver=new ChromeDriver();

				test1.log(Status.INFO, "Launched browser successfully");
			}
			catch(Exception e)
			{
				test1.fail("Failed to launch chrome driver");
			}
		}


		public void navigate(String url)
		{
			try {
				driver.get(url);

				driver.manage().window().maximize();

				WebElement ele=driver.findElement(By.linkText("//header[@class='logo']/img"));

				String headerlogo=ele.getAttribute("src");

				if(headerlogo.toLowerCase().contains("konnectco"))
				{
					test1.log(Status.INFO, "Successfully validated konnectco qa site launch");
				}
				else
				{
					test1.fail("Failed to launch Konnectco qa site");
					throw new Exception("Failed to launch Konnecto qa site");
				}
			}
			catch(Exception e)
			{

			}

		}

		public void enterText(String xpath, String text)
		{

			try {
				driver.findElement(By.xpath(xpath)).clear();

				driver.findElement(By.xpath(xpath)).sendKeys(text);

				test1.log(Status.INFO, "Successfully Entered Text: "+text);
			}
			catch(Exception e)
			{
				test1.fail("Failed to Enter Text "+text);
			}
		}

		public void click(String xpath)
		{
			try {

				driver.findElement(By.xpath(xpath)).click();
				test1.log(Status.INFO, "Successfully Clicked on web element");
			}
			catch(Exception e)
			{
				test1.fail("Failed to click on web element");
			}
		}

		public void driverwait(int time)
		{
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}

		public void quit()
		{
			driver.quit();
		}

		public void selectFromDropDown(String xpath, String text)
		{
			WebElement ele=driver.findElement(By.xpath(xpath));
			Select dp=new Select(ele);
			dp.selectByVisibleText(text);
		}

		public boolean verifyElementPresent(String xpath)
		{
			boolean flag=false;

			if(driver.findElement(By.xpath(xpath)).isDisplayed())
			{
				flag=true;
			}else
			{
				flag=false;
			}
			return flag;

		}

	}