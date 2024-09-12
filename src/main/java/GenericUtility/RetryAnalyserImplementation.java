package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer
{

	int count=0;
	int retryLimit=2;
	public boolean retry(ITestResult result)
	{
		while(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
