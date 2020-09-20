package pom;

import org.openqa.selenium.WebDriver;

public class Pojo {
	public static WebDriver driver;
    public static String browser;
    public static String url;
	    public String triptype;
	    public String From;

	    public void setUrl(String url) {
	        this.url = url;
	    }

	    public String getUrl() {
	        return url;
	    }

	    public String getBrowser() {
	        return browser;
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }

	    public void setDriver(WebDriver driver) {
	        this.driver = driver;
	    }


	    public void setBrowser(String browser) {
	        this.browser = browser;
	    }


	    public String setTriptype(String Triptype) {
	        return this.triptype = Triptype;
	    }

	    public String setFrom(String from) {
	        return this.From = from;
	    }

	    public String setTo(String to) {
	        return this.To = to;
	    }

	    public void setDeparture(String departure_date, String departure_month) {
	        Departure_date = departure_date;
	        Departure_month = departure_month;
	    }

	    public void setReturn(String return_date, String return_month) {
	        Return_date = return_date;
	        Return_month = return_month;
	    }

	    public void setTravelDetails(String adults, String travelClass) {
	        Adults = adults;
	        TravelClass = travelClass;
	    }

	    public String To;
	    public String Departure_date, Departure_month;
	    public String Return_date, Return_month;
	    public String Adults;
	    public String TravelDetails;
	    public String TravelClass;
}
