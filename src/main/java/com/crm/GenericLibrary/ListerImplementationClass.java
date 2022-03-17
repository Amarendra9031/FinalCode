package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		String Methodname = result.getMethod().getMethodName();
		test=report.createTest(Methodname);
		//Reporter.log(Methodname+"------testscript execution ---START" );
	}
	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+" ------->passed");
		//Reporter.log(MethodName + "--- TestScript Execution Sucessful---PASS");

	}

	public void onTestFailure(ITestResult result)
	{
		String path=null;
		String Methodname = result.getMethod().getMethodName();
		//Reporter.log(Methodname+"------testscript failed-----" );

		// Step:Configure screenshot name

		String screenshotName=Methodname + new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);

		//Step 2: using screenshot method from webDriver Utility
		try {

		path = new WebdriverUtility().getSceenShot(BaseClass.sDriver, screenshotName);


			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);

		} catch (Throwable e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, Methodname+" ----->failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(path);

	}
	public void onTestSkipped(ITestResult result) 
	{
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,Methodname+"------>skipped");
		//it will capture the exception and log it in the report
		test.log(Status.SKIP,result.getThrowable());


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	public void onStart(ITestContext context) 
	{
		//Execution will start here
		/*Configure the report*/	
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReporter.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Selenium Execution Report");


		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-Url", "http://loclahost:8888");
		report.setSystemInfo("Reporter Name", "Amarendra");


	}

	public void onFinish(ITestContext context) 
	{
		//consolidate all the parameters the report
		report.flush();

	}

}
