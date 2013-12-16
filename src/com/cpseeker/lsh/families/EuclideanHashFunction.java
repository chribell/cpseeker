package com.cpseeker.lsh.families;

import java.util.Random;

import com.cpseeker.lsh.IHashFunction;
import com.cpseeker.vectorgen.Vector;

/**
 * The Euclidean hash function.
 * @author chribell
 *
 */
public class EuclideanHashFunction implements IHashFunction
{
	/**
	 * A random vector projection.
	 */
	private Vector a_; 
	/**
	 * A real number.
	 */
	private double w_;
	/**
	 * An offset.
	 */
	private double b_; 
	
	/**
	 * Public constructor.
	 * @param dimension
	 * 		The {@link Vector}'s dimension/points
	 * @param w
	 * 		A real number.
	 */
	public EuclideanHashFunction(int dimension, double w)
	{
		Random generator = new Random();
		a_ = new Vector(dimension);
		for(int i = 0; i < dimension; i++)
		{
			a_.setValueAt(generator.nextGaussian(), i);
		}		
		w_ = w;
		//b is an element of [0,w]
		b_ = w_ * generator.nextDouble();
	}
	@Override
	public int hash(Vector v) 
	{
		//according to Datar a local sensitive hash function
		//for vectors of integers is the following
		// h(v) = (a*v + b)/w
		// where a, a random vector projection 
		// v, the vector to be hashed
		// b, an offset and w a real number indicating the radius.
		double hash = ( a_.scalarProduct(v) + b_ ) / w_;
		return (int) Math.round(hash);
	}
}
