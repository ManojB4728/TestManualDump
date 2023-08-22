package Android_Dump;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class A3_To_Fetch_All_The_Modules extends A2_User_Defined_Methodes {
	
	
	public static ArrayList<String> ToFetchAllTheModulesWithEmptyManual() throws InterruptedException {
		   //Object Creating To Call Return Type From Method , Varables From Parent Class and Since Some Variable Are Non-Static So This Step
		    A4_Getting_Finalized_Text_From_Script m1=new A4_Getting_Finalized_Text_From_Script();
		  //Instead Of Making WebUrl As m1.WebUrl I Am Declaring Like Below
		    String WebUrl=m1.WebUrl;
		    int wait=m1.wait;
		    String EmaiId=m1.EmaiId;
		    String Password=m1.Password;
		    
	 //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		   //Setting Chrome Driver
		    WebDriverManager.chromedriver().setup();
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		   //Opening Chrome Driver
		    ChromeOptions options = new ChromeOptions();
		      options.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(options);
			

	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Maximize Window
			driver.manage().window().maximize();
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Navigateing To Url
		    driver.get(WebUrl);
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    // Making Use Of User Defined Explicit Wait Method To Wait Till Email Id Textfield Is Visible
		    WaitAndPerformAction(driver,m1.EmaiIdXpath, wait);
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    //Making Use Of User Defined clickAction Method To Click On EmaiId Textfield
		    clickAction(driver,m1.EmaiIdXpath ,"EmaiId Textfield" );
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    //Making Use Of User Defined enterInputIntoTheTextfield method To Enter Input Into The EmaiId Textfield
		    enterInputIntoTheTextfield(driver, m1.EmaiIdXpath,EmaiId ,"EmaiId Textfield");
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    //Making Use Of User Defined clickAction Method To Click On Password Textfield
		    clickAction(driver, m1.PasswordTextfieldXpath,"Password Textfield");
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    //Making Use Of User Defined enterInputIntoTheTextfield Method To Enter Input Into The Password Textfield
			enterInputIntoTheTextfield(driver, m1.PasswordTextfieldXpath, Password, "Password Textfield");
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Making Use Of User Defined clickAction Method To Click On Sign In Button
			clickAction(driver, m1.SignInButtonXpath, "Sign In Button");
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Making Use Of User Defined Explicit Wait Method To Wait Till Projects Tab Is Visible
	        WaitAndPerformAction(driver, m1.ProjectsTabXpath, wait);
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	        //Making Use Of User Defined clickAction Method To Click On First Project Name Text
		    clickAction(driver,m1.ProjectsTabXpath ,"First Project Name Text" );
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		    // Making Use Of User Defined Explicit Wait Method To Wait Till Root Modul Text Is Visible
	        WaitAndPerformAction(driver, m1.RootModulTextXpath, wait);
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	        String xpathallscripts="//button[text()='Automation']/following-sibling::button[contains(@class,'manual-button-tct')]/../../../span[@class=\"tree-title\"]//span[@title]";
	        WaitAndPerformAction(driver, m1.Expand, wait);
	        
	        
	        clickAction(driver, m1.Expand, "Expand");
	        
	        Thread.sleep(20000);
	        
	        ArrayList<WebElement> scripts1= (ArrayList<WebElement>) driver.findElements(By.xpath(xpathallscripts));
	       
	        ArrayList<String> scripts=new ArrayList<>();
	        
	        for (WebElement string : scripts1) {

	        	scripts.add(string.getAttribute("title"));
			}
	     
	        driver.close();
	       return scripts;
	}
}
