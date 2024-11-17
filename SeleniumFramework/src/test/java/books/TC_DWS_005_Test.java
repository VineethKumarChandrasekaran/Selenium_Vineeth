package books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutilities.BaseClass;
import genericutilities.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass {
	@Test
	public void clickOnBooks() throws EncryptedDocumentException, IOException {
		homepage = new HomePage(driver);
		homepage.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), excelutility.getStringDataFromExcel("Books", 1, 0),
				"Books Page is not Displayed");
		test.log(Status.PASS, "Books Page is Displayed");
	}
}
