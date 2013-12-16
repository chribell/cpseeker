package com.cpseeker.lsh;

import java.util.List;

import com.cpseeker.vectorgen.Vector;

/**
 * Describes a LSH process.
 * @author chribell
 *
 */
public class LSH 
{
	/**
	 * The dataset of {@link Vector}s.
	 */
	List<Vector> vectors_;
	/**
	 * The {@link HashTables}s' index.
	 */
	private Index index;
	/**
	 * The hash family, {@link HashFamily}, to be used.
	 */
	private final HashFamily hashFamily_;
	/**
	 * Public constructor.
	 * @param hashFamily
	 * 		The {@link HashFamily}, to be used.
	 */
	public LSH(HashFamily hashFamily) 
	{
		hashFamily_ = hashFamily;
	}
	/**
	 * Sets the dataset to a specific.
	 * @param vectors
	 * 		The {@link Vector}s' list to be set.
	 */
	public void setVectors(List<Vector> vectors)
	{
		vectors_ = vectors;
	}
	/**
	 * Builds the {@link HashTable}s' index.
	 */
	public void buildIndex()
	{
		index = new Index(hashFamily_);
		for(Vector vector : vectors_)
		{
			//index every vector from the dataset
			index.index(vector);
		}
	}
	/**
	 * Given a query {@link Vector}, it returns its
	 * neighborhood of {@link Vector}s.
	 * @param query
	 * 		The query {@link Vector}.
	 * @param radius
	 * 		The radius of the query {@link Vector}.
	 * @return
	 * 		A list containing possible neighbors.
	 * 		An empty list if there are no neighbors.
	 */
	public List<Vector> query(final Vector query, double radius)
	{
		return index.query(query, radius);
	}
}
