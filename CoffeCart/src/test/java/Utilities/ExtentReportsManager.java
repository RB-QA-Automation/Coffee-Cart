package Utilities;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.PaymentMultipleUserTest;

/**
 * An extent report is created every time a test suite is ran and provides
 * in-depth detail on each test case.
 */
public class ExtentReportsManager {

	private static ExtentReports extent;

	private static final Logger log = LogManager.getLogger(ExtentReportsManager.class.getName());

	/**
	 * Building the foundation of the extent reports. Which includes the location of
	 * the file, header, name, theme and tester information.
	 * 
	 * @return A ExtentReports object which is used to build and load the report.
	 */
	public static ExtentReports createInstance() {

		if (extent == null) {

			String reportPath = System.getProperty("user.dir") + "/target/extent-reports/ExtentReport.html";

			File reportDir = new File(System.getProperty("user.dir") + "/target/extent-reports");
			if (!reportDir.exists()) {
				log.info("ExtentReportsManager: Directory does not exist. Attempting to create: "
						+ reportDir.getAbsolutePath());

				if (reportDir.mkdirs()) {
					log.info("ExtentReportsManager: Directory created successfully");
				} else {

					log.info("ExtentReportsManager: FAILED to create directory");

				}

			} else {

				log.info("ExtentReportsManager: Directory already exists: " + reportDir.getAbsolutePath());
			}

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

			sparkReporter.config().setDocumentTitle("Java Selenium Automation Framework");
			sparkReporter.config().setReportName("Coffee Cart Test Report");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Tester", "Raja Bhamra");

		}

		return extent;

	}

}
