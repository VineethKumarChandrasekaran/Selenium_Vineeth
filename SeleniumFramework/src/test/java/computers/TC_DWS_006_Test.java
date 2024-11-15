package computers;

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
public class TC_DWS_006_Test extends BaseClass {
	@Test
	public void clickOnComputers() throws EncryptedDocumentException, IOException {
		homepage = new HomePage(driver);
		homepage.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), excelutility.getStringDataFromExcel("Computers", 1, 0),
				"Computers Page is not Displayed");
		test.log(Status.PASS, "Computers Page has been Displayed");
	}
}
