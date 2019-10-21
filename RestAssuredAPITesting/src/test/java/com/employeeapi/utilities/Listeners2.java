package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Listeners2 implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
    public void onTestStart(ITestResult result) {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/RestAPIReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");    //title of the Report
		htmlReporter.config().setReportName("Rest API Testing Report"); //name of the Report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project name: ","Employee Database API");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Enviroinment: ","SAT");
		extent.setSystemInfo("User: ","Russel");
	}	
		
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.PASS, "TestCase PASSED is " + result.getName());
		//test = extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());  //create new entry in the report
		test.log(Status.FAIL, "TestCase FAILED is " + result.getName());	  // to add name in extent report
		test.log(Status.FAIL, "TestCase FAILED is " + result.getThrowable()); //to add error/exception in extent
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());  //create new entry in the report
		test.log(Status.SKIP, "TestCase SKIPPED is " + result.getName());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}

}
