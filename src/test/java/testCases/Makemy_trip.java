package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.GiftPage;
import pageObjects.Cabselectpage;
import pageObjects.Hotelbooking;
import testBase.BaseClass;
import utilities.Excel_Output;

public class Makemy_trip extends BaseClass{
	
 List<String>li2=new ArrayList<String>();
 String carN;
 String carP2;
 
 
 @Test (priority=1)
 public void carSelect1() throws InterruptedException {
	 logger.info("******starting ************");
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.carClick();
	 logger.info("click on cab");
 }
 
 @Test (priority=2)
 public void fromCity1() throws InterruptedException {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.fromClick();
	 Thread.sleep(2000);
	 hm.fromcity();
	 
	 logger.info("select from city");
 }
 
 @Test (priority=3)
 public void tocity1() throws InterruptedException {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.toCitySelect("Manali");
	 Thread.sleep(5000);
	 hm.tocitySelect();
	 
	 logger.info("select to city");
 }
 
 @Test (priority=4)
 public void dateClick() {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.dateSelect();
	 
	 logger.info("click on date");
 }
 
 @Test (priority=5)
 public void apply1() {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.applyB();
 }
 
 @Test (priority=6)
 public void search1() {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.searchB();
	 
	 logger.info("click on search button");
 }
 @Test (priority=7)
 public void suvSelect1() {
	 Cabselectpage hm=new Cabselectpage(driver);
	 hm.suvSelcet();
	 
	 logger.info("click on suv car type");
 }
 @Test (priority=8)
 public void carDetails(){
	 Cabselectpage hm=new Cabselectpage(driver);
	 String carN= hm.carNamep().get(0).getText();
	 //System.out.println("carname="+ carN);
	// return carN;
	 System.out.println("carname= "+ carN);
 }
 @Test (priority=9)

 public void carP1() throws IOException {
	 Cabselectpage hm=new Cabselectpage(driver);
	 String carP2=hm.carpriceP().get(0).getText();
	 System.out.println("carprice= "+ carP2);
	 Excel_Output.Excel(carN,carP2);
 }
 
 @Test (priority=10)

 public void moreClick() {
	 GiftPage gf=new GiftPage(driver);
	 gf.moreC();
	 
	 logger.info("click on giftpage");
 }
 @Test (priority=11)
 public void giftSelect() throws InterruptedException {
	    GiftPage gf=new GiftPage(driver);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",gf.weddingGift());
		Thread.sleep(2000);
		gf.weddingGift().click();
		
		 logger.info("click on wedding gift section");
 }
 @Test (priority=12)

 public void deatils() {
	 GiftPage gf=new GiftPage(driver);
	 gf.senderDetail("Ganapatrao Apate");
	 gf.mobileN("9876543210");
	 gf.mailE("abate.com");
	 
	 logger.info("Entering the user details");
 }
 @Test (priority=13)

 public void Buynow() {
	 GiftPage gf=new GiftPage(driver);
	 gf.buyButton();
	 
	 logger.info("click on buy now button");
 }
 @Test (priority=14)

 public void msg() {
	 GiftPage gf=new GiftPage(driver);
	 String msg2=gf.errormsg1();
	 System.out.println("Error msg= "+ msg2);
	 
	 
 }
 @Test (priority=15)

 public void hotel1() throws InterruptedException {
	 Hotelbooking ht=new Hotelbooking(driver);
	 ht.hotelclick();
	 
	 logger.info("click on hotel section");
 }
 @Test (priority=16)

 public void roomadultClick1() {
	 Hotelbooking ht=new Hotelbooking(driver);
	 ht.roomadultClick();
	 
	 logger.info("click on room section");
 }
 @Test (priority=17)

 public void adult1() {
	 Hotelbooking ht=new Hotelbooking(driver);
	 ht.adults1();
	 
	 logger.info("click on adult section list");
 }
 @Test (priority=18)

 public void adultlist1() {
	 Hotelbooking ht=new Hotelbooking(driver);
	 for(WebElement li1:ht.adultsList()) {
		li2.add(li1.getText());
	}
	System.out.println(li2);
 }
 
 
}
