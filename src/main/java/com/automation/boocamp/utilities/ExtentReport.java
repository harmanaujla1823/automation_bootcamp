package com.automation.boocamp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports generateExtentReport() throws IOException {
		
	
	
	ExtentReports extentReport = new ExtentReports();
	
	File extentReporterFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
	
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReporterFile);
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutorialsNinja Automation Results");
	sparkReporter.config().setDocumentTitle("TNReportTitle");
	sparkReporter.config().setTimeStampFormat("MM/DD/YYYY HH:MM:SS");
	extentReport.attachReporter(sparkReporter);
	
	
	Properties prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+
			"\\src\\main\\java\\com\\automation\\bootcamp\\config\\config.properties");
	
	prop.load(ip);
	
	extentReport.setSystemInfo("application url", prop.getProperty("url"));
	extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
	extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
	extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
	extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
	extentReport.setSystemInfo("ops version detail", System.getProperty("os.version"));
	extentReport.setSystemInfo("SDET Name", System.getProperty("user.name"));
	extentReport.setSystemInfo("java version", System.getProperty("java.version"));
	extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
	
	
	return extentReport;
	
	}
}