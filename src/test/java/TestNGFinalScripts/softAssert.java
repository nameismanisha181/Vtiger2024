package TestNGFinalScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {

	@Test
	public void demo()
	{
		System.out.println("step1");
		System.out.println("step2");
		
		SoftAssert SA= new SoftAssert();		
		SA.assertEquals(false, true);
		
		System.out.println("step3");
		System.out.println("step4");
		
		SA.assertAll();
	}
}
