package com.cpseeker.lsh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.CodeFragment;
import com.cpseeker.vectorgen.Vector;

/**
 * This class is used as a wrapper for java's {@link HashMap},
 * so the usage of a {@link HashFamily} can be much more easier.
 * @author chribell
 *
 */
public class HashTable 
{
	/**
	 * The logger responsible for the vectors' hashing.
	 */
	private static final Logger hLogger_ = LoggerFactory.getLogger("hashing");
	/**
	 * A {@link HashMap}. Its key field represents a hash value
	 * and the value field represents the hash value's nearest
	 * neighbors (possible clones). 
	 */
	private HashMap<Integer,List<Vector>> hashMap_;
	/**
	 * The {@link HashFamily} to be used.
	 */
	private HashFamily hashFamily_;
	/**
	 * Public constructor.
	 * @param family
	 * 		The {@link HashFamily} to be used.
	 */
	public HashTable(HashFamily family)
	{
		hashFamily_ = family;
		hashMap_ = new HashMap<Integer, List<Vector>>();
	}
	/**
	 * Hashes a {@link Vector}.
	 * @param vector
	 * 		The {@link Vector} to be hashed.
	 * @return
	 * 		The {@link Vector}'s hash value.
	 */
	private Integer hash(Vector vector)
	{
		return hashFamily_.hashVector(vector);
	}
	/**
	 * Adds a {@link Vector}, i.e. its hash value
	 * to the {@link HashMap}.
	 * @param vector
	 * 		The {@link Vector} to be added.
	 */
	public void add(Vector vector)
	{
		Integer combinedHash = hash(vector);
		if(! hashMap_.containsKey(combinedHash))
		{
			hashMap_.put(combinedHash, new ArrayList<Vector>());
		}
		hashMap_.get(combinedHash).add(vector);
		log(vector.getCodeFragment(), combinedHash);
	}
	/**
	 * Given a query {@link Vector}, it returns its
	 * neighborhood of {@link Vector}s.
	 * @param query
	 * 		The {@link Vector} to be queried about
	 * 		its "neighborhood".
	 * @return
	 * 		A list containing possible neighbors.
	 * 		An empty list if there are no neighbors.
	 */
	public List<Vector> query(Vector query) 
	{
		Integer combinedHash = hash(query);
		if(hashMap_.containsKey(combinedHash))
			return hashMap_.get(combinedHash);
		else
			return new ArrayList<Vector>();
	}
	private static void log(CodeFragment cf, Integer hashValue)
	{
		hLogger_.info("----------------------------------------");
		hLogger_.info("{}", cf.toString());
		hLogger_.info("Hash Value: {}", hashValue);
		hLogger_.info("----------------------------------------");
	}
}
