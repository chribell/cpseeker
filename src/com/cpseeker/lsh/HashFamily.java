package com.cpseeker.lsh;

import java.util.Arrays;
import java.util.List;

import com.cpseeker.vectorgen.Vector;

/**
 * Describes a family of hash functions. Each family
 * has its own set of hash functions {@link IHashFunction}
 * and distance measure {@link IDistance}.
 * @author chribell
 *
 */
public abstract class HashFamily 
{
	/**
	 * The family's set of hash functions, {@link IHashFunction}s.
	 */
	protected List<IHashFunction> hashFunctions_;
	/**
	 * The family's distance measure, {@link IDistance}.
	 */
	protected IDistance distanceMeasure_;
	/**
	 * Constructs the family's corresponding hash function.
	 * To be overridden by the extended class.
	 */
	protected void constructHashFunction(){}
	/**
	 * Constructs the family's corresponding distance measure.
	 * To be overridden by the extended class.
	 */
	protected void constructDistanceMeasure(){}
	/**
	 * 
	 * @return
	 * 		The family's distance measure, {@link IDistance}.
	 */
	public IDistance getDistanceMeasure()
	{
		return distanceMeasure_;
	}
	/**
	 * 
	 * @return
	 * 		The number of hash functions {@link IHashFunction},
	 * 		the family uses.
	 */
	public int getHashFunctionsNumber()
	{
		return hashFunctions_.size();
	}
	/**
	 * Hashes a {@link Vector}.
	 * For every family's hash function generates
	 * a hash value then it combines all the hash
	 * values and returns a single hash value.
	 * @param vector
	 * 		The {@link Vector} to be hashed.
	 * @return
	 * 		A combined hash value.
	 */
	public Integer hashVector(Vector vector)
	{
		int[] hashes = new int[hashFunctions_.size()];
		int index = 0;
		for(IHashFunction hashFunction : hashFunctions_)
		{
			hashes[index] = hashFunction.hash(vector);
			index++;
		}
		return Arrays.hashCode(hashes);
	}
}
