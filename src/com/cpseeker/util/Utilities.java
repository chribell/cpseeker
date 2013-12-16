package com.cpseeker.util;


/**
 * A class with useful methods.
 * @author chribell
 *
 */
public class Utilities 
{
	/**
	 * Finds and returns the maximum element in a given 
	 * array of integers.
	 * @param array
	 * 			The array of integers.
	 * @return
	 * 			The array's maximum integer.
	 */
	public static int findMax(int[] array)
	{	
	    int max = array[0];
	    for(int i = 1; i < array.length; i++) 
	    {
	        if(array[i] > max) 
    		{
	            max = array[i];
    		}
	    }
	    return max;
	}
	/**
	 * Finds and returns the minimum element in a given 
	 * array of integers.
	 * @param array
	 * 			The array of integers.
	 * @return
	 * 			The array's minimum integer.
	 */
	public static int findMin(int[] array)
	{
		int min = array[0];
		for(int i = 1; i < array.length; i++)
		{
			if(min > array[i])
			{
				min = array[i];
			}
		}
		return min;
	}
	/**
	 * Finds and returns the maximum element in a given 
	 * array of doubles.
	 * @param array
	 * 			The array of doubles.
	 * @return
	 * 			The array's maximum double.
	 */
	public static double findMax(double[] array)
	{	
	    double max = array[0];
	    for(int i = 1; i < array.length; i++) 
	    {
	        if(array[i] > max) 
    		{
	            max = array[i];
    		}
	    }
	    return max;
	}
	/**
	 * Finds and returns the minimum element in a given 
	 * array of doubles.
	 * @param array
	 * 			The array of doubles.
	 * @return
	 * 			The array's minimum double.
	 */
	public static double findMin(double[] array)
	{
		double min = array[0];
		for(int i = 1; i < array.length; i++)
		{
			if(min > array[i])
			{
				min = array[i];
			}
		}
		return min;
	}
	/**
	 * Returns a modified string with its first character lower case.
	 * If the first character is already lower case, then no change is
	 * applied.
	 * @param string
	 * 			The string to be modified.
	 * @return
	 * 			The modified string.
	 */
	public static String firstCharToLowerCase(String string)
	{
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}
}
