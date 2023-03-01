package leantech;

public class leantechtest {
	
	import org.junit.jupiter.api.*; 

	import org.openqa.selenium.*; 

	import org.openqa.selenium.chrome.*; 

	  

	public class SauceDemoTest { 

	  

	    WebDriver driver; 

	  

	    @BeforeEach 

	    void setUp() { 

	        // Set up the Chrome driver 

	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); 

	        driver = new ChromeDriver(); 

	        driver.manage().window().maximize(); 

	    } 

	  

	    @AfterEach 

	    void tearDown() { 

	        // Quit the Chrome driver 

	        driver.quit(); 

	    } 

	  

	    @Test 

	    void testCheckout() { 

	        // Go to the website 

	        driver.get("https://www.saucedemo.com/"); 

	  

	        // Login with standard user 

	        WebElement username = driver.findElement(By.id("user-name")); 

	        WebElement password = driver.findElement(By.id("password")); 

	        WebElement loginButton = driver.findElement(By.id("login-button")); 

	        username.sendKeys("standard_user"); 

	        password.sendKeys("secret_sauce"); 

	        loginButton.click(); 

	  

	        // Add a product to the cart 

	        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']")); 

	        WebElement itemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")); 

	        String itemNameText = itemName.getText(); 

	        addToCartButton.click(); 

	  

	        // Go to the cart page 

	        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")); 

	        cartIcon.click(); 

	  

	        // Validate item name in cart 

	        WebElement cartItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")); 

	        String cartItemNameText = cartItemName.getText(); 

	        Assertions.assertEquals(itemNameText, cartItemNameText); 

	  

	        // Click checkout button 

	        WebElement checkoutButton = driver.findElement(By.xpath("//button[text()='Checkout']")); 

	        checkoutButton.click(); 

	  

	        // Fill in checkout information 

	        WebElement firstName = driver.findElement(By.id("first-name")); 

	        WebElement lastName = driver.findElement(By.id("last-name")); 

	        WebElement zipCode = driver.findElement(By.id("postal-code")); 

	        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']")); 

	        firstName.sendKeys("John"); 

	        lastName.sendKeys("Doe"); 

	        zipCode.sendKeys("12345"); 

	        continueButton.click(); 

	  

	        // Validate item name in checkout overview 

	        WebElement overviewItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")); 

	        String overviewItemNameText = overviewItemName.getText(); 

	        Assertions.assertEquals(itemNameText, overviewItemNameText); 

	  

	        // Finish the order 

	        WebElement finishButton = driver.findElement(By.xpath("//button[text()='Finish']")); 

	        finishButton.click(); 

	  

	        // Validate completion page 

	        WebElement completeHeader = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")); 

	        String completeHeaderText = completeHeader.getText(); 

	        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", completeHeaderText); 

	    } 

	} 

}
