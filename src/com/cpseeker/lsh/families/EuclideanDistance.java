package com.cpseeker.lsh.families;

import com.cpseeker.lsh.IDistance;
import com.cpseeker.vectorgen.Vector;

/**
 * The Euclidean distance.
 * The distance is computed as /f$\sqrt{ (x_2-x_1)^2 + (y_2 - y_1)^2 }/f$.
 * @author chribell
 *
 */
public class EuclideanDistance implements IDistance 
{
	@Override
	public double distance(Vector v1, Vector v2) 
	{
		int sum = 0;
		for(int i = 0; i < v1.getDimension(); i++)
		{
			sum += Math.pow(v1.getValueAt(i) - v2.getValueAt(i), 2.0);
		}
		return Math.sqrt(sum);
	}
	
}
