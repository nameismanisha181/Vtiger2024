package GenericUtility;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ran;
	}
	
	public String dateStampFormat()
	{
		LocalDateTime ldt= LocalDateTime.now();
		String timeStamp = ldt.toString().replace(':', '-');
		return timeStamp;
	}
	
	
}
