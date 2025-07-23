package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import testCases.AddItemsToCartTest;

/**
 * A TestNGListener class that is integrated with ExtentReports in order to
 * create an in-depth report. Each event is read such as on test start, pass,
 * fail etc and is then logged, in addition to taking screenshots when tests
 * fail.
 */
public class ExtentTestNGListener implements ITestListener {

	private static final ExtentReports extent = ExtentReportsManager.createInstance();

	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private static final Logger log = LogManager.getLogger(AddItemsToCartTest.class.getName());

	/**
	 * Invoked and logged at the start of the test suite.
	 */
	@Override
	public void onStart(ITestContext contentx) {

		log.info("TEST SUITE STARTED!");
	}

	/**
	 * Invoked and logged at the end of the test suite. Flushes ExtentReports
	 * instance in order to write test information to HTML file.
	 */
	@Override
	public void onFinish(ITestContext context) {

		log.info("TEST SUITE IS ENDING!");
		extent.flush();

	}

	/**
	 * Invoked every time a test case method is about to start, a new test entry is
	 * created in the ExtentReport.
	 */
	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);

	}

	/**
	 * Invoked on each time a test case method is successful, a log is created which
	 * states the test as a "PASS".
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, "Test Case Passed!");
	}

	/**
	 * Invoked each time a test case method fails. Logs the test case as a "FAIL"
	 * and attaches a screenshot which highlights where the test failed.
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		test.get().fail(result.getThrowable());

		WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
		if (driver != null) {

			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			test.get().addScreenCaptureFromBase64String(screenshotBase64, "Screenshot on test failure");

		}

	}

	/**
	 * Invoked every time a test case method is skipped and logs the test as "SKIP".
	 */
	@Override
	public void onTestSkipped(ITestResult result) {

		test.get().log(Status.SKIP, "Test Skipped");
	}

}
