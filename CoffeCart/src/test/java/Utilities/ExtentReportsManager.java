package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * An extent report is created every time a test suite is ran and provides
 * in-depth detail on each test case.
 */
public class ExtentReportsManager {

	private static ExtentReports extent;

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

				reportDir.mkdirs();
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
