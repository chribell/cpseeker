package com.cpseeker.vectorgen.vectorgroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.util.Utilities;
import com.cpseeker.vectorgen.Vector;

/**
 * This class is responsible for the {@link Group}s' creation
 * and the {@link Vector}s dispatch according to their code size.
 * @author chribell
 *
 */
public class VectorGrouping 
{
	/**
	 * Default class's logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger("main");
	/**
	 * It creates the corresponding {@link Group}s. It returns them empty
	 * but with bounds, for the {@link Vector} dispatch to be possible.
	 * @param maxCodeSize
	 * 		The maximum code size of a {@link Vector} set. 
	 * @param similarity
	 * 		A probability used to create the ranges/bounds.
	 * @param size
	 * 		A user specified code for the first group creation.
	 * @return
	 * 		A list of empty groups.
	 */
	private static List<Group> sizeRanges(int maxCodeSize, double similarity, int size)
	{
		double distance = Math.sqrt((1 - similarity) * size);
		List<Group> groups = new ArrayList<>();
		//1st group
		Group group = new Group(0, Math.round(distance + size));
		group.setSigma(distance);
		groups.add(group);
		//2nd group
		if(0.0 == distance)
			group = new Group(size + 1, size + 1);
		else
			group = new Group(size, Math.round(size + 3 * distance + 1));
		group.setSigma(Math.sqrt(group.getLowerBound())/Math.sqrt(size) * distance);
		groups.add(group);
		//remaining groups
		double lowerBound = group.getLowerBound();
		double upperBound = group.getUpperBound();
		while(upperBound <= maxCodeSize)
		{
			if(0.0 == distance)
				group = new Group(upperBound + 1, upperBound + 1);
			else
				group = new Group(Math.round(upperBound - (lowerBound/size) * distance), 
								  Math.round(((size + 2 * distance) / size) * upperBound
								  - 2*(Math.pow(distance, 2.0) / Math.pow(size, 2.0))
								  * lowerBound + 1));
			lowerBound = group.getLowerBound();
			upperBound = group.getUpperBound();
			group.setSigma(Math.sqrt(lowerBound)/Math.sqrt(size) * distance);
			groups.add(group);
		}
		return groups;
	}
	/**
	 * It creates the corresponding {@link Group}s. It returns them empty
	 * but with bounds, for the {@link Vector} dispatch to be possible. 
	 * This function should be called only when similarity is 1.
	 * @param vectors
	 * 		The list of {@link Vector}s for the groups' generation.
	 * @return
	 * 		A list of empty groups.
	 */
	private static List<Group> sizeRanges(List<Vector> vectors)
	{
		List<Group> groups = new ArrayList<>();
		Set<Integer> codeSizes = new HashSet<>();
		for(Vector vector : vectors)
		{
			codeSizes.add(vector.getCodeSize());
		}
		for(Integer size : codeSizes)
		{
			groups.add(new Group(size,size));
		}		
		return groups;
	}
	
	
	/**
	 * It dispatches the {@link Vector}s to their corresponding groups.
	 * @param groups
     * 			The {@link Group}s to be filled.
	 * @param vectors
	 * 			The {@link Vector}s to be dispatched.
	 */
	private static void dispatchVectors(List<Group> groups, List<Vector> vectors)
	{
		for(Group group : groups)
		{
			for(Iterator<Vector> iter = vectors.iterator(); iter.hasNext();)
			{
				Vector vector = iter.next();
				if(vector.getCodeSize() >= group.getLowerBound() && vector.getCodeSize() <= group.getUpperBound())
				{
					group.addVector(vector);
				}
			}
		}
		
	}
	/**
	 * It dispatches the {@link Vector}s to their corresponding groups.
	 * To be used only when similarity equals 1.
	 * @param groups
     * 			The {@link Group}s to be filled.
	 * @param vectors
	 * 			The {@link Vector}s to be dispatched.
	 */
	private static void dispatch(List<Group> groups,List<Vector> vectors)
	{
		for(Group group : groups)
		{
			for(Iterator<Vector> iter = vectors.iterator(); iter.hasNext();)
			{
				Vector vector = iter.next();
				if(vector.getCodeSize() == group.getLowerBound())
				{
					group.addVector(vector);
					iter.remove();
				}
			}
			logger.info("{}",group);
		}
	}
	/**
	 * It looks for possible empty {@link Group}. If a {@link Group}
	 * is empty, it removes from the returning list.
	 * @param groups
	 * 		The list to be iterated.
	 */
	private static void postProcess(List<Group> groups)
	{
		for(Iterator<Group> iter = groups.iterator(); iter.hasNext();)
		{
			Group group = iter.next();
			if(group.isEmpty())
				iter.remove();
			logger.info("{}",group);
		}
	}
	/**
	 * It creates and returns a list of {@link Group}s.
	 * Each {@link Group} has {@link Vector}s with code size
	 * within its bounds.
	 * @param vectors
     *		The {@link Vector}s to be clustered.
	 * @param similarity
	 * 		A probability used to create the ranges/bounds.
	 * @param size
	 * 		A user specified code for the first group creation.
	 * @return
	 * 		A list of groups.
	 */
	public static List<Group> vectorGrouping(List<Vector> vectors, double similarity, int size)
	{
		List<Group> groups;
		if(similarity != 1.0)
		{
			int[] codeSizes = new int[vectors.size()];
			int i = 0;
			for(Vector vector : vectors)
			{
				codeSizes[i] = vector.getCodeSize();
				i++;
			}
			//get maxCodeSize for sizeRanges
			int maxCodeSize = Utilities.findMax(codeSizes);
			groups = sizeRanges(maxCodeSize, similarity, size);
			//dispatch vectors
			dispatchVectors(groups, vectors);
			//post process groups (removes empty groups)
			postProcess(groups);
		}
		else
		{
			groups = sizeRanges(vectors);
			dispatch(groups, vectors);
		}
		return groups;		
	}
}
