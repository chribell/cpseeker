package com.cpseeker.lsh;

import com.cpseeker.vectorgen.Vector;

/**
 * An interface which describes a
 * hash function.
 * @author chribell
 *
 */
public interface IHashFunction 
{
	/**
	 * Hashes the given vector and returns
	 * its hash value.
	 * @param vector
	 * 		The {@link Vector} to be hashed.
	 * @return
	 * 		The {@link Vector}'s hash value.
	 */
	int hash(Vector vector);
}
