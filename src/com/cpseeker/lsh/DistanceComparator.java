package com.cpseeker.lsh;

import java.util.Comparator;

import com.cpseeker.vectorgen.Vector;


/**
 * This class is used to compare distances 
 * between vectors.
 * @author chribell
 *
 */
public class DistanceComparator implements Comparator<Vector> 
{
	/**
	 * The query {@link Vector}.
	 */
	private final Vector vector_;
	/**
	 * The {@link IDistance} measure.
	 */
	private final IDistance distance_;
	/**
	 * Public constructor.
	 * @param vector
	 * 		The query {@link Vector}.
	 * @param distance
	 * 		The {@link IDistance} measure.
	 */
	public DistanceComparator(Vector vector, IDistance distance)
	{
		vector_ = vector;
		distance_ = distance;
	}
	@Override
	public int compare(Vector first, Vector second) 
	{
		Double firstDistance = distance_.distance(vector_, first);
		Double secondDistance = distance_.distance(vector_, second);
		return firstDistance.compareTo(secondDistance);
	}
}

