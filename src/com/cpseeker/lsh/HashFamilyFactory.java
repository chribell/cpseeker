package com.cpseeker.lsh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.lsh.families.EuclideanHashFamily;

/**
 * A hash family factory (Factory pattern).
 * @author chribell
 *
 */
public class HashFamilyFactory 
{
	/**
	 * Default class's logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(HashFamilyFactory.class);
	/**
	 * Creates and returns a hash family, {@link HashFamily}.
	 * @param type
	 * 		The type of the family.
	 * @param hashFunctions
	 * 		The number of the hash functions to be created
	 * 		inside the family.
	 * @param dimension
	 * 		The vector's dimension/points.
	 * @param radius
	 *		The number which defines a vector's neighborhood.
	 * @return
	 * 		A {@link HashFamily}.
	 */
	public static HashFamily buildHashFamily(HashFamilyType type, int hashFunctions, int dimension, double radius)
	{
		HashFamily hashFamily = null;
		switch(type)
		{
			case EUCLIDEAN:
			{
				//TODO
				if(1 > radius) radius = 1;
				hashFamily =  new EuclideanHashFamily(hashFunctions, dimension, radius);
				break;
			}
			default:
				logger.error("Unknown hash family type: {}", type.name());
		}
		return hashFamily;
	}
}
