package com.cpseeker.lsh.families;

import java.util.ArrayList;

import com.cpseeker.lsh.HashFamily;
/**
 * The Euclidean hash family.
 * @author chribell
 *
 */
public class EuclideanHashFamily extends HashFamily
{
	/**
	 * The {@link Vector}'s dimension.
	 */
	private final int vectorDimension_;
	/**
	 * A real number.
	 */
	private final double w_;
	/**
	 * Public constructor.
	 * @param hashFunctions
	 * 		The number of hash functions to be used.
	 * @param dimension
	 * 		The {@link Vector}'s dimension.
	 * @param w
	 * 		A real number.
	 */
	public EuclideanHashFamily(int hashFunctions, int dimension,double w)
	{
		hashFunctions_ = new ArrayList<>();
		w_ = w;	
		vectorDimension_ = dimension;
		for(int i = 0; i < hashFunctions; i++)
		{
			constructHashFunction();
		}
		constructDistanceMeasure();
	}
	
	@Override
	protected void constructHashFunction()
	{
		hashFunctions_.add(new EuclideanHashFunction(vectorDimension_, w_));
	}
	
	@Override
	protected void constructDistanceMeasure() 
	{
		distanceMeasure_ = new EuclideanDistance();
	}
}
