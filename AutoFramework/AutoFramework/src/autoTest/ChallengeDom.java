package autoTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class functions as a page object for the
 * ChallengingDom webpage, it requires a WebDriver
 * object to be instantiated.
 * https://the-internet.herokuapp.com/challenging_dom
 * @author philip.webb
 *
 */
public class ChallengeDom {
	
	/**
	 * Element object to be returned to the caller once the element has been found.
	 */
	private WebElement element;
	
	/**
	 * The WebDriver object used to interact with the elements on this page.
	 */
	private WebDriver driver;
	
	/**
	 * Constructor for the ChallengeDom page object class.
	 * @param driver The WebDriver object used to interact with the browser.
	 */
	public ChallengeDom(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * Finds the blue button on the ChallengeDom page.
	 * @return The WebElement object of the Blue Button.
	 */
	public WebElement btn_BlueButton()
	{
		return FindElement(driver, By.className("button"), "Blue Button");
	}
	
	/**
	 * Finds the red button on the ChallengeDom page.
	 * @return The WebElement object of the Red Button.
	 */
	public WebElement btn_RedButton()
	{
		return FindElement(driver, By.xpath("//*[@class='button alert']"), "Red Button");
	}
	
	/**
	 * Finds the green button on the ChallengeDom page.
	 * @return The WebElement object of the Green Button.
	 */
	public WebElement btn_GreenButton()
	{
		return FindElement(driver, By.xpath("//*[@class='large-2 columns']/a[3]"), "Green Button");
	}
	
	/**
	 * Finds the table on the ChallngeDom page.
	 * @return The WebElement object of the Greek Table.
	 */
	public WebElement tbl_GreekTable()
	{
		return FindElement(driver, By.xpath("//*[@class='large-10 columns']/table"), "Greek Table");				
	}
	
	/**
	 * Finds the Canvas on the ChallengeDom page.
	 * @return The WebElement object of the Canvas object.
	 */
	public WebElement cnv_Canvas()
	{
		return FindElement(driver, By.xpath("//*[@id='canvas']"), "Canvas");
	}
	
	/**
	 * Finds and returns a WebElement on the page
	 * using the given WebDriver and By objects.
	 * @param driver The driver used to find the element.
	 * @param locator The By object used to locate the element.
	 * @param name The name of the element used for logging.
	 * @return The WebElement object that was found.
	 */
	private WebElement FindElement(WebDriver driver, By locator, String name)
	{
		try
		{
			this.element = driver.findElement(locator);
		}
		catch (NoSuchElementException e)
		{
			String failMsg = "Unable to find " + name + "\n" + e.getMessage();
			System.out.println(failMsg);
			Assert.fail(failMsg);
		}
		
		System.out.println(("Found " + name));
		return this.element;
	}
}
