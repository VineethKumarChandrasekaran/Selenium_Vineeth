package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Log out")
	private WebElement logoutButton;

	@FindBy(partialLinkText = "Books")
	private WebElement booksLink;

	@FindBy(partialLinkText = "Computers")
	private WebElement computersLink;

	@FindBy(partialLinkText = "Electronics")
	private WebElement electronicsLink;

	@FindBy(partialLinkText = "Gift Cards")
	private WebElement giftcardsLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getGiftcardsLink() {
		return giftcardsLink;
	}

}
