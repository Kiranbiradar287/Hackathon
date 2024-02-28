package stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cabselectpage;
import utilities.Excel_Output;

public class CabStep {
	WebDriver driver=Hooks.driver;
	public Logger logger=LogManager.getLogger(this.getClass());
	//logger= LogManager.getLogger(this.getClass());

	Cabselectpage hm;
	String carname;
	String carprice;
	@Given("user can see cab selection And click on cab")
	public void user_can_see_cab_selection_and_click_on_cab() throws InterruptedException {
		System.out.println("=======================================================");
		hm = new Cabselectpage(driver);
		hm.carClick();
		 //logger
		 logger.info("click on cab");
		
	}

	@Then("user enter the from city")
	public void user_enter_the_from_city() throws InterruptedException {
		 hm.fromClick();
		   hm.fromcity();
		  
		   //logger
			 logger.info("select the from city");
			
	}

	@Then("user enter the to city")
	public void user_enter_the_to_city() {
		hm.toCitySelect("Manali");
	    hm.tocitySelect();
	}

	@Then("user select the date")
	public void user_select_the_date() {
         hm.dateSelect();
         
         //logger
		 logger.info("select the To city");
		
	}

	@Then("user click on apply button")
	public void user_click_on_apply_button() {
        hm.applyB();
        
        //logger
		 logger.info("select the Date");
		
	}

	@When("user click on search button")
	public void user_click_on_search_button() {
	   hm.searchB();
	   //logger
		 logger.info("click on search button");
		
	}

	@Then("user see car type section And select SUV car")
	public void user_see_car_type_section_and_select_suv_car() {
		hm.suvSelcet();
		
		 //logger
		 logger.info("click on suv type car");
		
	}
	   

	@Then("print car name And car price")
	public void print_car_name_and_car_price() throws IOException {
	   carname= hm.carNamep().get(0).getText();
	   System.out.println("carname= "+carname);
	   
	   carprice= hm.carpriceP().get(0).getText();
	   System.out.println("carprice= "+carprice);
	   
	   Excel_Output.Excel(carname,carprice);
	}
	
}
