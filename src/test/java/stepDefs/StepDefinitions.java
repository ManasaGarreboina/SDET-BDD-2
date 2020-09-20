package stepDefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Pojo;
import reuasableMethods.SetDataForTrip;

public class StepDefinitions {
	Pojo object = new Pojo();
    SetDataForTrip sd = new SetDataForTrip();
    String trip_type;
    Logger log = Logger.getLogger(StepDefinitions.class);
	 @Given("url for navigation is {string}  for {string}")
	    public void url_for_navigation_is_for(String url, String browser) {
	        // Write code here that turns the phrase above into concrete actions
	        log.info("******Launch********");
	        sd.getDriver(browser, log);

	        sd.getUrl(url);
	        log.info("Goibibo site is opened");
	    }

	    @When("select type of trip {string}")
	    public void select_type_of_trip(String type) {
	        // Write code here that turns the phrase above into concrete actions

	        trip_type = sd.getTriptype(type, log);

	    }

	    @Then("Enter the details for trip like {string} {string} {string}{string} {string} {string} {string} {string}")
	    public void enter_the_details_for_trip_like(String From, String To, String Departure_date, String Departure_month,
	                                                String Return_date, String Return_month, String Adults, String TravelClass) throws InterruptedException {
	        // Write code here that turns the phrase above into concrete actions
	        if (trip_type.equalsIgnoreCase("oneway")) {

	            sd.getFrom(From, log);

	            sd.getTo(To, log);

	            object.setDeparture(Departure_date, Departure_month);
	            sd.getDeparture(Departure_date, Departure_month, log);

	            // object.setReturn(Return_date, Return_month);
	            // sd.getReturn(Return_date, Return_month);
	            object.setTravelDetails(Adults, TravelClass);
	            sd.getTravelDetails(Adults, TravelClass, log);
	        } else if (trip_type.equalsIgnoreCase("roundTrip")) {

	            sd.getFrom(From, log);

	            sd.getTo(To, log);

	            object.setDeparture(Departure_date, Departure_month);
	            sd.getDeparture(Departure_date, Departure_month, log);

	            object.setReturn(Return_date, Return_month);
	            sd.getReturn(Return_date, Return_month, log);
	            object.setTravelDetails(Adults, TravelClass);
	            sd.getTravelDetails(Adults, TravelClass, log);
	        }
	    }

	    @Then("clicked on Search")
	    public void clicked_on_Search() {
	        // Write code here that turns the phrase above into concrete actions
	        sd.driver.findElement(By.id("gi_search_btn")).click();
	    }

	    @When("filtered by price as lowest")
	    public void filtered_by_price_as_lowest() {
	        // Write code here that turns the phrase above into concrete actions
	        if (trip_type.equalsIgnoreCase("oneway")) {
	            sd.getPricesort(log);
	        } else if (trip_type.equalsIgnoreCase("roundTrip")) {
	            sd.getRoundwayPricesort(log);
	        }
	    }

	    @Then("Click on book")
	    public void click_on_book() {
	        // Write code here that turns the phrase above into concrete actions
	        if (trip_type.equalsIgnoreCase("oneway")) {
	            sd.getBookFlight(log);
	        } else if (trip_type.equalsIgnoreCase("roundTrip")) {
	            sd.getRoundwayBookFlight(log);
	        }
	    }

	    @Then("Review page should be navigated for review checking for match of expected and actual values match i.e {string} {string} {string}{string} {string} {string}")
	    public void review_page_should_be_navigated_for_review_checking_for_match_of_expected_and_actual_values_match_i_e(
	            String From, String To, String Departure_date, String Departure_month, String Return_date,
	            String Return_month) {
	        // Write code here that turns the phrase above into concrete actions
	        if (trip_type.equalsIgnoreCase("oneway")) {
	            sd.getReviewPageFrom(From, log);
	            sd.getReviewPageTo(To, log);
	            sd.getReviewPageDay(Departure_date, Departure_month, log);
	        } else if (trip_type.equalsIgnoreCase("roundTrip")) {
	            sd.getDepartReviewPageFrom(From, log);
	            sd.getDepartReviewPageTo(To, log);
	            sd.getDepartReviewPageDay(Departure_date, Departure_month, log);
	            sd.getReturnReviewPageFrom(From, log);
	            sd.getReturnReviewPageTo(To, log);
	            sd.getReturnReviewPageDay(Return_date, Return_month, log);

	        }
	    }

	    @Then("Close the browser")
	    public void close_the_browser() {
	        // Write code here that turns the phrase above into concrete actions
	        sd.driver.quit();
	        log.info("Browser is not closed");
	        log.error("Browser is closed");
	        log.info("******Launch end********");
	    }
}
