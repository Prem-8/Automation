package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contains Java Generic Libraries
 * @Prem
 *
 */
public class JavaUtility 
{
	/**
	 * Generate Random Number
	 * @Prem
	 */
	public String getRandomData()
	{
		Random random = new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	
	/**
	 * Generate Current System Date
	 * @Prem
	 */
	public String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentDate=date.toString();
		return currentDate;
	}
}
