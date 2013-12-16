package com.cpseeker.vectorgen.vectorgroup;

import java.util.ArrayList;
import java.util.List;

import com.cpseeker.vectorgen.Vector;

/**
 * Group is used for clustering {@link Vector}s.
 * @author chribell
 *
 */
public class Group
{
	/**
	 * The group's lower bound.
	 */
	private double lowerBound_;
	/**
	 * The group's upper bound.
	 */
	private double upperBound_;
	/**
	 * The group's {@link Vector}s.
	 */
	private List<Vector> vectors_;
	/**
	 * The group's sigma value.
	 * This number defines the radius for the LSH scheme.
	 */
	private double sigma_;
	/**
	 * Public constructor.
	 * @param lower
	 * 		The group's lower bound.
	 * @param upper
	 * 		The group's upper bound.
	 */
	public Group(double lower, double upper)
	{
		lowerBound_ = lower;
		upperBound_ = upper;
		vectors_ = new ArrayList<>();
	}
	/**
	 * 
	 * @return
	 * 		The group's lower bound.
	 */
	public double getLowerBound()
	{
		return lowerBound_;
	}
	/**
	 * 
	 * @return
	 * 		The group's upper bound.
	 */
	public double getUpperBound()
	{
		return upperBound_;
	}
	/**
	 * 
	 * @return
	 * 		The group's {@link Vector}s.
	 */
	public List<Vector> getVectors()
	{
		return vectors_;
	}
	/**
	 * Sets the group's sigma value.
	 * @param sigma
	 * 		The value to be set.
	 */
	public void setSigma(double sigma)
	{
		sigma_ = sigma;
	}
	/**
	 * 
	 * @return
	 * 		The group's sigma value.
	 */
	public double getSigma()
	{
		return sigma_;
	}
	/**
	 * Adds a vector into the group.
	 * @param vector
	 * 		The vector to be added.
	 * @return
	 * 		True if insertion was successful, otherwise false.
	 */
	public boolean addVector(Vector vector)
	{
		return vectors_.add(vector);
	}
	/**
	 * 
	 * @return
	 * 		True if group is empty, otherwise false.
	 */
	public boolean isEmpty()
	{
		return vectors_.isEmpty();
	}
	/**
	 * Sets the group's list of {@link Vector} to a specific.
	 * @param vectors
	 * 		The list of {@link Vector} to be set.
	 */
	public void setVectors(List<Vector> vectors)
	{
		vectors_ = vectors;
	}
	@Override
	public String toString()
	{
		String s = "[" + lowerBound_ + "," + upperBound_ + "] Contains " + vectors_.size() + " element(s), sigma = " + sigma_;
		return s;
	}
}
