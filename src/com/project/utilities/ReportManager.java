package com.project.utilities;

import com.project.Configuration.Configuration;
import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {
	public static ExtentReports extent;
	
	public synchronized static ExtentReports getReporter()
	{
		if(extent==null) {
			extent=new ExtentReports(Configuration.REPORT_LOCATION,true);
			extent.addSystemInfo("HostName","personal");
			extent.addSystemInfo("Environment","QA");
			
		}
		return extent;
		
	}

}
