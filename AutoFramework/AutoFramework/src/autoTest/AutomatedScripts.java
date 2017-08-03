package autoTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.List;

/**
 * This class contains automated test scripts for the Challenging Dom webpage.
 * @author philip.webb
 *
 */
public class AutomatedScripts
{
	/**
	 * WebDriver object used to drive the browser.
	 */
	WebDriver driver;
	
	/**
	 * The URL of the webpage under test.
	 */
	String url = "https://the-internet.herokuapp.com/challenging_dom";
	
	/**
	 * ChallengeDom object used to find elements on the page.
	 */
	ChallengeDom chlDom;
	
	/**
	 * Browser Enum to select which browser to run the test in.
	 */
	Browser browser = Browser.FIREFOX;
	
	/**
	 * Enumeration used to select which browser will be used to run the tests.
	 */
	public enum Browser
	{
		INTERNET_EXPLORER,
		FIREFOX,
		CHROME
	}
	
	/**
	 * Tests the blue button by comparing the background-color and color
	 * CSS attributes to the expected colour.
	 */
	@Test
	public void BlueButtonColour()
	{		
		// Verify the colour of the button.
		String bgColour = chlDom.btn_BlueButton().getCssValue("background-color");
		String expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(43, 166, 203)" : "rgba(43, 166, 203, 1)";
		Assert.assertEquals(expectedColour, bgColour);
		
		String fontColour = chlDom.btn_BlueButton().getCssValue("color");
		expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(255, 255, 255)" : "rgba(255, 255, 255, 1)";
		Assert.assertEquals(expectedColour, fontColour);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests the blue button by clicking on it and checking
	 * the new URL is the same as the original. In IE checks
	 * browser is redirected to the main website.
	 * @throws InterruptedException 
	 */
	@Test
	public void BlueButtonClick() throws InterruptedException
	{
		String expectedUrl = this.browser.equals(Browser.INTERNET_EXPLORER) ?
				"https://the-internet.herokuapp.com/" : driver.getCurrentUrl();
		
		// Click on the blue button and wait a few seconds.
		Output("Clicking on blue button with text: " + chlDom.btn_BlueButton().getText());
		chlDom.btn_BlueButton().click();
		Thread.sleep(2000);
		
		// Get the new page title.
		String newUrl = driver.getCurrentUrl();
		
		// Ensure the new page URL is the same as the old one.
		Assert.assertEquals(newUrl, expectedUrl);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests the green button by comparing the background-colour and color
	 * CSS attributes to the expected colour.
	 */
	@Test
	public void GreenButtonColour()
	{		
		// Verify the colour of the button.
		String bgColour = chlDom.btn_GreenButton().getCssValue("background-color");
		String expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(93, 164, 35)" : "rgba(93, 164, 35, 1)";
		Assert.assertEquals(expectedColour,  bgColour);
		
		String fontColour = chlDom.btn_GreenButton().getCssValue("color");
		expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(255, 255, 255)" : "rgba(255, 255, 255, 1)";
		Assert.assertEquals(expectedColour, fontColour);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests the green button by clicking on it and checking
	 * the new URL is the same as the original. In IE checks
	 * browser is redirected to the main website.
	 * @throws InterruptedException 
	 */
	@Test
	public void GreenButtonClick() throws InterruptedException
	{
		String expectedUrl = this.browser.equals(Browser.INTERNET_EXPLORER) ?
				"https://the-internet.herokuapp.com/" : driver.getCurrentUrl();
		
		// Click on the green button.
		Output("Clicking on green button with text: " + chlDom.btn_GreenButton().getText());
		chlDom.btn_GreenButton().click();
		Thread.sleep(2000);
		
		String newUrl = driver.getCurrentUrl();
		
		// Ensure the new page URL is the same as the old one.
		Assert.assertEquals(newUrl, expectedUrl);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests the red button by clicking on it and checking
	 * the new URL is the same as the original.
	 * @throws InterruptedException 
	 */
	@Test
	public void RedButtonClick() throws InterruptedException
	{
		String expectedUrl = this.browser.equals(Browser.INTERNET_EXPLORER) ?
				"https://the-internet.herokuapp.com/" : driver.getCurrentUrl();
		
		// Click on the red button.
		Output("Clicking on red button with text: " + chlDom.btn_RedButton().getText());
		chlDom.btn_RedButton().click();
		Thread.sleep(2000);
		
		String newUrl = driver.getCurrentUrl();
		
		// Ensure the new page URL is the same as the old one.
		Assert.assertEquals(newUrl, expectedUrl);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests the red button by comparing the background-colour and color
	 * CSS attributes to the expected colour.
	 */
	@Test
	public void RedButtonColour()
	{
		// Verify the colour of the button.
		String bgColour = chlDom.btn_RedButton().getCssValue("background-color");
		String expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(198, 15, 19)" : "rgba(198, 15, 19, 1)";
		Assert.assertEquals(expectedColour, bgColour);
		
		String fontColour = chlDom.btn_RedButton().getCssValue("color");
		expectedColour = this.browser.equals(Browser.FIREFOX) ? "rgb(255, 255, 255)" : "rgba(255, 255, 255, 1)";
		Assert.assertEquals(expectedColour, fontColour);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests that the table headers contain expected values.
	 */
	@Test
	public void TableHeaders()
	{
		// Expected header text.
		String [] headerText = { "Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action" };
				
		// Get the table header elements.
		List<WebElement> tableHeaders = chlDom.tbl_GreekTable().findElements(By.tagName("th"));
		
		for (int i = 0; i < tableHeaders.size(); i++)
		{
			String expected = headerText[i];
			String actual = tableHeaders.get(i).getText();
			Assert.assertEquals(actual, expected);
		}
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests that the table contains expected data.
	 */
	@Test
	public void TableData()
	{
		// Each row contains the same combination of strings,
		// appended with a number indicating which row it is on.
		// Store the raw strings now and append the number before comparison.
		String [] expectedText = { "Iuvaret", "Apeirian", "Adipisci", "Definiebas", "Consequuntur", "Phaedrum" };
		
		// How many rows of data we expect.
		int expectedRows = 10;
		
		// This number will be added to the expected strings.
		int tableRowNum = 0;
		
		// When we verify a row this number will be incremented.
		int verifiedRows = 0;
		
		List<WebElement> tableRows = chlDom.tbl_GreekTable().findElements(By.tagName("tr"));
		
		for (WebElement tableRow : tableRows)
		{
			List<WebElement> tableCells = tableRow.findElements(By.tagName("td"));
			
			// The first 'tr' will contain the table headers, which contain no td's.
			if (!tableCells.isEmpty())
			{
				for (int i = 0; i < expectedText.length; i++)
				{
					String expected = expectedText[i] + (tableRowNum - 1);
					Output("Checking cell " + (i + 1) + " in row " + tableRowNum + " equals: [" + expected + "]");
					Assert.assertEquals(expected, tableCells.get(i).getText());
				}
				
				verifiedRows++;
			}
			
			tableRowNum++;
		}
		
		Assert.assertEquals("Verified [" + verifiedRows + "] rows but expected [" + expectedRows + "]",
				expectedRows, verifiedRows);
		
		Output("Test Passed.");
	}
	
	/**
	 * Tests that the table contains hyperlinks in the expected cells.
	 */
	@Test
	public void TableLinks()
	{
		int expectedRows = 10;
		String hyperlinkText1 = "edit";
		String hyperlinkText2 = "delete";
		List<WebElement> tableRows = chlDom.tbl_GreekTable().findElements(By.tagName("tr"));
		
		int verifiedRows = 0;
		int tableRowNum = 0;
		for (WebElement tableRow : tableRows)
		{
			List<WebElement> tableCells = tableRow.findElements(By.tagName("td"));
			
			// The first 'tr' will contain the table headers, which contain no td's.
			if (!tableCells.isEmpty())
			{
				List<WebElement> hyperlinks = tableCells.get(6).findElements(By.tagName("a"));
				
				// Verify 2 hyperlinks found in cell 6.
				Assert.assertEquals("Expected 2 hyperlinks in row [" + tableRowNum +
						"] cell [6] but found: [" + hyperlinks.size(),
						2, hyperlinks.size());
				
				Output("Verifying hyperlink text in row " + tableRowNum + ".");
				
				// Verify text of each hyperlink.
				String linkText = hyperlinks.get(0).getText();
				Assert.assertEquals("Expected hyperlink text was [" + hyperlinkText1 + "] but was: [" + linkText +"]",
						hyperlinkText1, linkText);
				
				linkText = hyperlinks.get(1).getText();
				Assert.assertEquals("Expected hyperlink text was [" + hyperlinkText2 + "] but was: [" + linkText +"]",
						hyperlinkText2, linkText);
				
				verifiedRows++;
			}
			
			tableRowNum++;
		}
		
		Assert.assertEquals("Expected " + expectedRows + " rows to be verified, but only verified: ["
				+ verifiedRows + "].", expectedRows, verifiedRows);
		
		Output("Test Passed.");
	}
	
	/**
	 * Verifies the canvas object is active on the page.
	 */
	@Test
	public void VerifyCanvas()
	{
		WebElement canvas = chlDom.cnv_Canvas();
		
		Assert.assertTrue("The Canvas element is not visible on the page", canvas.isDisplayed());
		
		Output("Test Passed.");
	}
	
	/**
	 * This method runs before any test to create
	 * the driver and open the URL under test.
	 */
	@Before
	public void Setup()
	{
		Output("Starting driver...");
		
		File file = null;
		switch (this.browser)
		{
			case FIREFOX:
				file = new File("E:\\drivers\\geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
				driver = new FirefoxDriver();
				break;
				
			case CHROME:
				file = new File("E:\\drivers\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
				break;
				
			case INTERNET_EXPLORER:
				file = new File("E:\\drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
				break;
		}
		
		Output("Navigating to: " + url);
		driver.get(url);
		
		chlDom = new ChallengeDom(driver);
	}
	
	/**
	 * The TearDown closes the driver once
	 * the test has completed.
	 */
	@After
	public void TearDown()
	{
		Output("Closing driver...");
		driver.quit();
	}
	
	/**
	 * This method takes a message and outputs it to the console.
	 * @param message The message to output.
	 */
	private static void Output(String message)
	{
		System.out.println(message);
	}
}