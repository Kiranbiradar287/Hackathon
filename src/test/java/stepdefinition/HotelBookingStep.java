package stepdefinition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Hotelbooking;
//import utilities.Excelcode;

public class HotelBookingStep {

WebDriver driver=Hooks.driver;
Hotelbooking hotel=new Hotelbooking(driver);
public Logger logger=LogManager.getLogger(this.getClass());;




@When("user click on hotel section")
public void user_click_on_hotel_section() throws InterruptedException {
    hotel.hotelclick();
    
  //logger
	 logger.info("click on hotel");
}

@Then("user see room option and click")
public void user_see_room_option_and_click() {
    hotel.roomadultClick();
    
  //logger
	 logger.info("Select the room option");
}

@Then("user click on Adult list and print the list")
public void user_click_on_adult_list_and_print_the_list() {
    hotel.adults1();
    System.out.println("******Adult list Below*****");
    for(WebElement li:hotel.adultsList()) {
		System.out.println(li.getText());
	}
  //logger
	 logger.info("print the adult list");
}
}
