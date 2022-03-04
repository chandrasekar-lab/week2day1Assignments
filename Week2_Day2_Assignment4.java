package week2_day1_Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main

Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/

public class Week2_Day2_Assignment4 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get( "http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		WebElement  elementUsername = driver.findElement( By.id( "username"));
		elementUsername.sendKeys( "Demosalesmanager");
		
		WebElement elementPassword = driver.findElement( By.id( "password"));
		elementPassword.sendKeys( "crmsfa");
		
		WebElement  elementLogInButton = driver.findElement( By.className( "decorativeSubmit"));
		elementLogInButton.click();
		
		WebElement  elementCRMSFA = driver.findElement( By.linkText( "CRM/SFA"));
		elementCRMSFA.click();
		
		WebElement  elementLeads = driver.findElement( By.linkText( "Leads"));
		elementLeads.click();
		
		WebElement  elementFindLeads = driver.findElement( By.linkText( "Find Leads"));
		elementFindLeads.click();
		
		WebElement  elementPhone = driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]"));
		elementPhone.click();
		
		WebElement  elementEnterPhoneNo = driver.findElement(By.name( "phoneNumber"));
		elementEnterPhoneNo.sendKeys("123456");
		
	 
		WebElement  elementPhoneFindLeads = driver.findElement(By.xpath( "//table[@id='ext-gen242']/tbody[1]/tr[1]/td[2]/em[1]/button[1]"));
		elementPhoneFindLeads.click();
		Thread.sleep(3000);
		
		System.out.println("FindLeadsClicked");
	 
		String idNo = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
		System.out.println(idNo);
		
		WebElement idClick=driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]"));
		idClick.click();
		 
		WebElement elementDelete=driver.findElement(By.className("subMenuButtonDangerous"));
		elementDelete.click();
		
		WebElement  elementFindLeads1 = driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']"));
		elementFindLeads1.click();
		
		System.out.println("FindLeads1Clicked");
		
		WebElement  idNoEnter = driver.findElement( By.xpath("//label[text()='Lead ID:']/following::input"));
		idNoEnter.sendKeys(idNo);
		
		WebElement  elementFindLeads2 = driver.findElement(By.xpath("//button[@id='ext-gen334']"));
		elementFindLeads2.click();
		
		System.out.println("FindLeads2Clicked");
		
		
		  WebElement getDiplayedText=
		  driver.findElement(By.xpath("//div[@id='ext-gen315']"));
		  getDiplayedText.getText();
		  
		  if(getDiplayedText.equals("No records to display")) {
		  System.out.println("Record deleted successfully"); }else {
		  System.out.println("Deletion Failed"); }
		 
		
		

		//get URL

		String url2 = driver.getCurrentUrl();
		System.out.println("The Title is : " + url2);

		//get Title

		String title = driver.getTitle();
		System.out.println("The Title is : " + title);

		// close the driver

		// driver.close();

		
		 
	}

}
