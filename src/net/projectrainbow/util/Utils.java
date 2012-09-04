package net.projectrainbow.util;

/**
 * Utils.java
 */

public class Utils
{
	public static String input(String prompt)
	{
		String inputLine = "";
		System.out.print(prompt);
		try
		{
			java.io.InputStreamReader sys = new java.io.InputStreamReader(
					System.in);
			java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
			inputLine = inBuffer.readLine();
		}
		catch (Exception e)
		{
			String err = e.toString();
			System.out.println(err);
			inputLine = "";
		}
		return inputLine;
	}
}
