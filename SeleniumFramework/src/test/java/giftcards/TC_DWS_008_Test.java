package giftcards;

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
public class TC_DWS_008_Test extends BaseClass{
@Test
public void clickOnGiftCards() throws EncryptedDocumentException, IOException {
	homepage = new HomePage(driver);
	homepage.getGiftcardsLink().click();
	Assert.assertEquals(driver.getTitle(), excelutility.getStringDataFromExcel("GiftCards", 1, 0),"Gift Cards Page is not Displayed");
	test.log(Status.PASS, "Gift cards Page has been displayed");
}
}
