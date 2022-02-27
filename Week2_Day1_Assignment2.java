package week2_day1_Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Assignment 2:Edit Lead
1. Launch URL "http://leaftaps.com/opentaps/control/login"
2. Enter UserName and Password Using Id Locator
3. Click on Login Button using Class Locator
4. Click on CRM/SFA Link
5. Click on Leads Button
6. Click on Create Lead 
7. Enter CompanyName Field Using id Locator
8. Enter FirstName Field Using id Locator
9. Enter LastName Field Using id Locator
10. Enter FirstName(Local) Field Using id Locator
11. Enter Department Field Using any Locator of Your Choice
12. Enter Description Field Using any Locator of your choice 
13. Enter your email in the E-mail address Field using the locator of your choice
14. Select State/Province as NewYork Using Visible Text
15. Click on Create Button
16. Click on edit button
17. Clear the Description Field using .clear()
18. Fill ImportantNote Field with Any text
19. Click on update button 
20. Get the Title of Resulting Page. refer the video  using driver.getTitle()
*/
public class Week2_Day1_Assignment2 {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get( "http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		WebElement  elementMyLeads = driver.findElement( By.partialLinkText( "Create"));
		elementMyLeads.click();
		WebElement  elementCompanyName = driver.findElement( By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys( "TCS");
		WebElement  elementFirstName = driver.findElement( By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys( "chand");
		WebElement  elementLastName = driver.findElement( By.id("createLeadForm_lastName"));
		elementLastName.sendKeys( "govind");

		WebElement  elementFirstNameLocal = driver.findElement( By.id("createLeadForm_firstNameLocal"));
		elementFirstNameLocal.sendKeys( "sekar");
		WebElement  elementDepartmnetName = driver.findElement( By.id("createLeadForm_departmentName"));
		elementDepartmnetName.sendKeys( "pde");
		WebElement  elementDescription = driver.findElement( By.id("createLeadForm_description"));
		elementDescription.sendKeys( "Welcome to Product development Engg.");

		WebElement  elementEmail = driver.findElement( By.id("createLeadForm_primaryEmail"));
		elementEmail.sendKeys( "chandrasekar.89@gmail.com");

		WebElement  elementDropDown = driver.findElement( By.id( "createLeadForm_generalStateProvinceGeoId"));
		//elementDropDown.sendKeys( "New York");

		Select se =new Select(elementDropDown);

		se.selectByVisibleText("New York");

		


		WebElement  elementCreate = driver.findElement( By.className( "smallSubmit"));
		elementCreate.click();
		
		WebElement  elementEditButton = driver.findElement( By.linkText( "Edit"));
		elementEditButton.click();
		
		WebElement  elementDescriptionClear = driver.findElement( By.name("description"));
		elementDescriptionClear.clear();
		WebElement  elementImportantNote = driver.findElement( By.name( "importantNote"));
		elementImportantNote.sendKeys( "Note:Welcome to Product development Engg.");
		
		WebElement  elementupdate = driver.findElement( By.name( "submitButton"));
		elementupdate.click();
		

		String title = driver.getTitle();
		System.out.println("The Title is : " + title);


	 

	}

}
