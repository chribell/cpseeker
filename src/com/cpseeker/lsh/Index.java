package com.cpseeker.lsh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cpseeker.vectorgen.Vector;

/**
 * Describes an index of {@link HashTable}s. Through the index,
 * the process of iteration and vector querying is much more
 * faster than a "static approach".
 * @author chribell
 *
 */
public class Index 
{
	/**
	 * The {@link HashFamily} to be used.
	 */
	private HashFamily family_;
	/**
	 * The list of {@link HashTables} to be indexed.
	 */
	private List<HashTable> hashTables_; 
	/**
	 * 
	 * @param family
	 * 		The {@link HashFamily} to be used.
	 */
	public Index(HashFamily family)
	{
		family_ = family;
		//TODO possible refactor
		//the number of hash tables depends on the number
		//of the hash family's hash functions. Each hash
		//function should have its corresponding hash table
		hashTables_ = new ArrayList<HashTable>();
		for(int i = 0 ; i < family_.getHashFunctionsNumber() ; i++ )
		{
			hashTables_.add(new HashTable(family));
		}
	}
	/**
	 * Indexes a {@link Vector} to the {@link HashTable}s.
	 * @param vector
	 * 		The {@link Vector} to be indexed.
	 */
	public void index(Vector vector)
	{
		for (HashTable table : hashTables_) 
		{
			table.add(vector);
		}
	}
	/**
	 * 
	 * @return
	 * 		The number of {@link HashTable}s the index uses.
	 */
	public int getNumberOfHashTables()
	{
		return hashTables_.size();
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
		Set<Vector> neighborsSet = new HashSet<Vector>();
		for(HashTable table : hashTables_)
		{
			List<Vector> vectors = table.query(query);
			neighborsSet.addAll(vectors);
		}
		List<Vector> possibleNeighbors = new ArrayList<Vector>(neighborsSet);
		IDistance measure = family_.getDistanceMeasure();
		DistanceComparator dc = new DistanceComparator(query, measure);
		Collections.sort(possibleNeighbors,dc);
		List<Vector> neighbors = new ArrayList<>();
		for(Vector neighbor : possibleNeighbors)
		{
			if(measure.distance(query, neighbor) <= radius)
				neighbors.add(neighbor);
			else
				break;
		}
		return neighbors;
	}
}
