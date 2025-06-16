package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class ExtentTestNGListener implements ITestListener {

	private static final ExtentReports extent = ExtentReportsManager.createInstance();

	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext contentx) {

		System.out.println("Test Suite started!");
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test Suite is ending!");
		extent.flush();

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, "Test Case Passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.get().fail(result.getThrowable());

		WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
		if (driver != null) {

			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			test.get().addScreenCaptureFromBase64String(screenshotBase64, "Screenshot on test failure");

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.get().log(Status.SKIP, "Test Skipped");
	}

}
