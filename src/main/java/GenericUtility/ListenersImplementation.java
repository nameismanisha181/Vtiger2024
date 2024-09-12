package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener{

//	@Override
	public void onTestFailure(ITestResult result) {
		
		LocalDateTime ldt= LocalDateTime.now();
		String stamp = ldt.toString().replace(':', '-');
		TakesScreenshot ts =(TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./errorShots/test1"+stamp+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
