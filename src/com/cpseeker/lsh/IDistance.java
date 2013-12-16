package com.cpseeker.lsh;

import com.cpseeker.vectorgen.Vector;

/**
 * An interface which describes a distance 
 * measure between two {@link Vector}s.
 * @author chribell
 *
 */
public interface IDistance 
{
	/**
	 * 
	 * @param vector1
	 * 		The first {@link Vector}.
	 * @param vector2
	 * 		The second {@link Vector}.
	 * @return
	 * 		The distance between the two {@link Vector}s.
	 */
	public double distance(Vector vector1, Vector vector2);
}
