package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GiftPage;

public class GiftStep {

	WebDriver driver=Hooks.driver;
	GiftPage gift=new GiftPage(driver);
	public Logger logger=LogManager.getLogger(this.getClass());;
	
	@When("user click on more option And click on giftcards")
	public void user_click_on_more_option_and_click_on_giftcards() {
	   gift.moreC();
	   
	 //logger
		 logger.info("click on giftselect");
	}

	@Then("user scroll down And click on weddinggift")
	public void user_scroll_down_and_click_on_weddinggift() throws InterruptedException {
	  // gift.weddingGift();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",gift.weddingGift());
		Thread.sleep(2000);
		gift.weddingGift().click();
		
		//logger
		 logger.info("click on wedding gift");
	}

	@Then("user Enter all the Deatil")
	public void user_enter_all_the_deatil() {
		 gift.senderDetail("Ganapatrao Apate");
		 gift.mobileN("9876543210");
		 gift.mailE("abate.com");
		 
		//logger
		 logger.info("enter user Detail");
	}

	@When("user click on buy now button")
	public void user_click_on_buy_now_button() {
	   gift.buyButton();
	   
	 //logger
		 logger.info("click on Buy now");
	}

	@Then("print the error mail msg")
	public void print_the_error_mail_msg() {
	   System.out.println("***Error msg="+ gift.errormsg1());
	   
	 //logger
		 logger.info("print the error msg");
	}
}
