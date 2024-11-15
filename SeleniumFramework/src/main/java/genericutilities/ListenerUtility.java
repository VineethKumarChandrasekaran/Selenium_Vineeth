package genericutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extReport.createTest(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is Failed");
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));// adding screenshot to the ExtentReport
		
		//add screenshot to the screenshot folder
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File screenshot = new File("./Screenshots/"+result.getName()+javautility.getSystemTime()+".png");
		try {
			FileUtils.copyFile(temp, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
