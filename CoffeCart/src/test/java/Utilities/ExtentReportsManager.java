package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		if (extent == null) {

			String reportPath = "target/extent-reports/ExtentReport.html";
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
