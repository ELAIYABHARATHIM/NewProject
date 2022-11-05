package org.nn;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseeClass {
	public static WebDriver driver;
    public static WebDriver browserLaunch(String browsername) {
    	switch(browsername) {
    	case"chrome":
WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
 		break;
    	case"firefox":
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    		break;
    	case"edge":
    		WebDriverManager.edgedriver().setup();
    		driver=new EdgeDriver();
    		break;
  }
    	return driver;
    }
    
    public static void browserLaunch1(String browsername) {
    	
    
    if(browsername.equalsIgnoreCase("chrome")) {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    }
    else if(browsername.equalsIgnoreCase("firefox")) {
    	WebDriverManager.firefoxdriver().setup();
    	driver=new FirefoxDriver();
     }
    else if(browsername.equalsIgnoreCase("edge")) {
    	
    	WebDriverManager.edgedriver().setup();
    	driver=new EdgeDriver();
    }
    else {
    	System.out.println("Entering Invalid Browser Name");
    }
    
    }
	public static WebDriver chromeBrowser() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	return driver;
	
}
public static void urlLaunch(String url) {
	driver.get(url);
}

public static WebElement findelement(String LocatorType,String value) {
	if(LocatorType.equalsIgnoreCase("id")) {
		
		return driver.findElement(By.id(value));
	}
	else if(LocatorType.equalsIgnoreCase("name")) {
	
	return driver.findElement(By.name(value));
}
if(LocatorType.equalsIgnoreCase("xpath")) {
	return driver.findElement(By.xpath("value"));
}
	return null;
 
}

public static void maximize() {
	driver.manage().window().maximize();
	
}
public static void implicitwait(long sec) {
	driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
}

public static void sendkeys(WebElement e,String Value) {
	e.sendKeys(Value);
}

public static void click(WebElement e,String clickType) {
	if(clickType.equalsIgnoreCase("normal")) {
		e.click();
	}
	else if(clickType.equalsIgnoreCase("jsclick")) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	else if(clickType.equalsIgnoreCase("aclick")) {
		Actions a =new Actions(driver);
		a.click(e).perform();
	}
}


public static String getText(WebElement e) {
String text = e.getText();
return text;

}
public static void click(WebElement e) {
	e.click();
}
 public static String title() {
	String title = driver.getTitle();
	return title;
}
public static  String currentUrl() {
	String Url=driver.getCurrentUrl();
	return Url;

}
public static String getAttribute(WebElement e) {
	String att=e.getAttribute("value");
	return att;
}
public static void moveToElement(WebElement target) {
	Actions a=new Actions(driver);
	a.moveToElement(target).perform();
	
}

public static boolean isDisplayed(WebElement e) {
	
     boolean text = e.isSelected();
     return text;
}
public static boolean isEnabled(WebElement e) {
	boolean text = e.isEnabled();
	return text;

}
public static boolean isSelected(WebElement e) {
   boolean text= e.isSelected();
   return text;
}

public static void dropdown(String Type,String value, WebElement e){
Select s=new Select(e);
	if(Type.equalsIgnoreCase("index")) {
		s.selectByIndex(Integer.parseInt(value));
	}
	else if(Type.equalsIgnoreCase("Value")) {
		s.selectByValue((value));
	}
	else if(Type.equalsIgnoreCase("value")) {
		s.selectByVisibleText(value);
	}
}

public static  void screenshot(String name) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
	File des=new File("./\\Screenshots\\=+"+name+".png");
	FileUtils.copyFile(screenshotAs, des);

}
 public static void browserclose() {
 driver.close();
	
}
public static void quit() {
	driver.quit();
	
	
}

}
