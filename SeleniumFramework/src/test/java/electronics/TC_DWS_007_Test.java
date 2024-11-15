package electronics;

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
public class TC_DWS_007_Test extends BaseClass{
@Test
public void clickOnElectronics() throws EncryptedDocumentException, IOException {
	homepage = new HomePage(driver);
	homepage.getElectronicsLink().click();
	Assert.assertEquals(driver.getTitle(), excelutility.getStringDataFromExcel("Electronics", 1, 0),"Electronics page has not been Displayed");
	test.log(Status.PASS, "Electronics Page has been Displayed");
}
}
