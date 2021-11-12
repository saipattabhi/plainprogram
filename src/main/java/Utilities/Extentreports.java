package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	
	static ExtentReports reports;
	public  static ExtentReports getExtentReport()
	{
		
	 String extentReporterpath = System.getProperty("user.dir")+"\\reports\\Extentreport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReporterpath);
		
		reporter.config().setReportName("Tutorial ninja test automation results");
		reporter.config().setDocumentTitle("Reports");
	
		 reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("operating system", "windows 10");
		reports.setSystemInfo("Tested by", "Saipattabhi");
		return reports;
	}

}
