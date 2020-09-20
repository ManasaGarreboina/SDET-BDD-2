package reuasableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.qameta.allure.Step;
import pom.Pojo;

public class SetDataForTrip {
	Pojo object = new Pojo();
	public String from_place,BROWSER;
	public String to_place;
	public WebDriver driver = object.getDriver();
	Logger log = Logger.getLogger(SetDataForTrip.class);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 public void getUrl(String url) {

	        object.setUrl(url);
	        driver.get(object.getUrl());

	    }

	    public void getDriver(String brow, Logger log) {
	        object.setBrowser(brow);
	        BROWSER = object.getBrowser();


	        if (BROWSER.equalsIgnoreCase("chrome")) {

	            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
	            driver = new ChromeDriver();
	            object.setDriver(driver);
	            driver = object.getDriver();
	            driver.manage().deleteAllCookies();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	            log.info("Chrome driver got loaded");

	        } else if (BROWSER.equalsIgnoreCase("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "C://Users//MA20089955//Downloads//FirefoxDriver//geckodriver.exe");
	            driver = new FirefoxDriver();
	            object.setDriver(driver);
	            driver = object.getDriver();
	            driver.manage().deleteAllCookies();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	            log.info("Firefox driver got loaded");
	        }

	    }
	@Step("Triptype is Selected as {0}....")
	public String getTriptype(String Triptype, Logger log) {
		String trip = object.setTriptype(Triptype);

		try {
			if (Triptype.equalsIgnoreCase("oneway")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.findElement(By.id("oneway")).click();
				log.info("oneway triptype is selected");

			} else if (Triptype.equalsIgnoreCase("roundTrip")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.findElement(By.id("roundTrip")).click();
				log.info("roundTrip oneway triptype is selected");
			}

		} catch (Exception e) {
			log.error("Trip Type is not selected");
		}

		return trip;

	}
	@Step("From is Selected as {0}....")
	public void getFrom(String from, Logger log) throws InterruptedException {

		try {

			driver.findElement(By.id("gosuggest_inputSrc")).click();
			driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(from);
			List<WebElement> cityes = new ArrayList<WebElement>(
					driver.findElements(By.xpath("//*[@id='react-autosuggest-1']/li")));
			if (cityes.size() > 1)
				cityes.get(0).click();
			else {
				log.error("Please enter a proper city");
			}
			log.info("From selected successfully");

		} catch (Exception e) {
			log.error("From selected failed");
		}

	}
	@Step("To is Selected as {0}....")
	public void getTo(String to, Logger log) throws InterruptedException {
		try {

			driver.findElement(By.id("gosuggest_inputDest")).click();
			driver.findElement(By.id("gosuggest_inputDest")).sendKeys(to);
			List<WebElement> cityes = new ArrayList<WebElement>(
					driver.findElements(By.xpath("//*[@id='react-autosuggest-1']/li")));
			if (cityes.size() > 1)
				cityes.get(0).click();
			else {
				log.error("Please enter a proper city");
			}
			log.info("To selected successfully");
		} catch (Exception e) {
			log.error("To selected failed");
			System.out.println(e);
		}

	}
	@Step("Departure is Selected as {0},{1}....")
	public void getDeparture(String departure_date, String departure_month, Logger log) throws InterruptedException {
		try {

			driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']")).click();
			while (true) {
				String monthOnPage = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']"))
						.getText();
				if (monthOnPage.equals(departure_month)) {
					break;
				} else {
					driver.findElement(By
							.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']"))
					.click();
				}

			}

			String d = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()='##']";
			d = d.replace("##", departure_date);
			driver.findElement(By.xpath(d)).click();
			log.info("Departure got selected successfully");
		} catch (Exception e) {
			log.info("Departure is not selected ");
		}

	}
	@Step("Return is Selected as {0},{1}....")
	public void getReturn(String return_date, String return_month, Logger log) throws InterruptedException {
		try {

			driver.findElement(By.xpath("//input[@type='text' and @placeholder='Return']")).click();
			while (true) {
				String monthOnPage = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']"))
						.getText();
				if (monthOnPage.equals(return_month)) {
					break;
				} else {
					driver.findElement(By
							.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']"))
					.click();
				}

			}

			String d = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()='##']";
			d = d.replace("##", return_date);
			driver.findElement(By.xpath(d)).click();
			log.info("Return got selected successfully");
		} catch (Exception e) {
			log.info("Return is not selected ");

		}

	}
	@Step("TravelDetails is Selected as {0},{1}....")
	public void getTravelDetails(String adults, String travelClass, Logger log) throws InterruptedException {
		try {

			driver.findElement(By.xpath("//*[@id='pax_label']")).click();
			int i = (Integer.parseInt(adults)) - 1;
			while (i > 0) {
				driver.findElement(By.xpath("//*[@id='adultPaxPlus']")).click();
				i--;
			}

			Select objSelect = new Select(driver.findElement(By.xpath("//*[@id='gi_class']")));
			objSelect.selectByVisibleText(travelClass.trim());

			log.info("Passenger details got selected successfully");
		} catch (Exception e) {
			log.info("Passenger details is not selected");

		}
	}
	@Step("Price is Sorted....")
	public void getPricesort(Logger log) {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='PRICE']/span/span")).click();
			driver.findElement(By.xpath("//*[@id='PRICE']/span/span")).click();
			log.info("price got sorted");
		} catch (Exception e) {
			log.error("price did not get sorted");

		}
	}
	@Step("Prices are Sorted....")
	public void getRoundwayPricesort(Logger log) {
		try {
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//*[@class='fltHpyRWrap dF justifyBetween marginT5']/div[1]/div/ul/li[4]/span/span"))
			.click();
			driver.findElement(
					By.xpath("//*[@class='fltHpyRWrap dF justifyBetween marginT5']/div[1]/div/ul/li[4]/span/span"))
			.click();
			driver.findElement(
					By.xpath("//*[@class='fltHpyRWrap dF justifyBetween marginT5']/div[2]/div/ul/li[4]/span/span"))
			.click();
			driver.findElement(
					By.xpath("//*[@class='fltHpyRWrap dF justifyBetween marginT5']/div[2]/div/ul/li[4]/span/span"))
			.click();
			log.info("price got sorted");
		} catch (Exception e) {
			log.error("price did not get sorted");

		}
	}
	@Step("Flight is Booked....")
	public void getBookFlight(Logger log) {
		try {

			driver.findElement(By
					.xpath("//*[@id='content']/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/span/span/input"))
			.click();
			log.info("Flight got Booked");
		} catch (Exception e) {
			log.error("Flight is not Booked");

		}
	}
	@Step("Flights are Booked....")
	public void getRoundwayBookFlight(Logger log) {
		try {
			Thread.sleep(1000);
			driver.findElement(By
					.xpath("//*[@id='content']/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/span[2]/span/input"))
			.click();
			Thread.sleep(1000);
			log.info("Flight got Booked");
		} catch (Exception e) {
			log.error("Flight is not  Booked");

		}
	}
	@Step("verifying ReviewPageFrom ....")
	public void getReviewPageFrom(String from, Logger log) {

		try {
			ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
			if (s.size() > 1)
				driver.switchTo().window(s.get(1));
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@id='content']/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(from), true);
			log.info("From Element present in review page ");
		} catch (Exception e) {
			log.error("From Element not present in review page ");
			Assert.fail();

		}

	}
	@Step("verifying ReviewPageTo ....")
	public void getReviewPageTo(String to, Logger log) {

		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@id='content']/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(to), true);
			log.info("To Element present in review page ");
		} catch (Exception e) {
			log.error("To Element not present in review page ");
			Assert.fail();

		}

	}
	@Step("verifying ReviewPageDay ....")
	public void getReviewPageDay(String date, String month, Logger log) {
		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@id='content']/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(date), true);
			log.info("Date Element present in review page ");
			Assert.assertEquals(fromreceived.contains(month.substring(0, 3)), true);
			log.info("Month Element present in review page ");
		} catch (Exception e) {
			log.error("Day not reviewed successfully in review page  ");

			Assert.fail();

		}

	}
	@Step("verifying DepartReviewPageFrom ....")
	public void getDepartReviewPageFrom(String from, Logger log) {
		try {
			ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
			if (s.size() > 1)
				driver.switchTo().window(s.get(1));
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[1]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(from), true);
			log.info("From Element present in review page ");
		} catch (Exception e) {
			log.error("From Element not present in review page ");
			Assert.fail();

		}
	}
	@Step("verifying DepartReviewPageTo....")
	public void getDepartReviewPageTo(String to, Logger log) {
		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[1]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(to), true);
			log.info("To Element present in review page ");
		} catch (Exception e) {
			log.error("To Element not present in review page ");
			Assert.fail();

		}
	}
	@Step("verifying DepartReviewPageDay....")
	public void getDepartReviewPageDay(String date, String month, Logger log) {
		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[1]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(date), true);
			log.info("Date Element present in review page ");
			Assert.assertEquals(fromreceived.contains(month.substring(0, 3)), true);
			log.info("Month Element present in review page ");
		} catch (Exception e) {
			log.error("Day not reviewed successfully in review page  ");
			Assert.fail();

		}

	}
	@Step("verifying ReturnReviewPageFrom....")
	public void getReturnReviewPageFrom(String from, Logger log) {
		try {
			ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[2]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(from), true);
			log.info("From Element present in review page ");
		} catch (Exception e) {
			log.error("From Element not present in review page ");
			Assert.fail();

		}
	}
	@Step("verifying ReturnReviewPageTo....")
	public void getReturnReviewPageTo(String to, Logger log) {
		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[2]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(to), true);
			log.info("To Element present in review page ");
		} catch (Exception e) {
			log.error("To Element not present in review page ");
			Assert.fail();

		}
	}
	@Step("verifying ReturnReviewPageDay....")
	public void getReturnReviewPageDay(String date, String month, Logger log) {
		try {
			String fromreceived = driver
					.findElement(By
							.xpath("//*[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10 padB20']/div[2]/div[2]/div/div[1]/span[1]"))
					.getText().trim();
			Assert.assertEquals(fromreceived.contains(date), true);
			log.info("Date Element present in review page ");
			Assert.assertEquals(fromreceived.contains(month.substring(0, 3)), true);
			log.info("Month Element present in review page ");
		} catch (Exception e) {
			log.error("Day not reviewed successfully  in review page ");
			Assert.fail();

		}

	}
}
