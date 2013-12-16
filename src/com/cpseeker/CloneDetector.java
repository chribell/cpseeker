package com.cpseeker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.lsh.HashFamily;
import com.cpseeker.lsh.HashFamilyFactory;
import com.cpseeker.lsh.HashFamilyType;
import com.cpseeker.lsh.LSH;
import com.cpseeker.vectorgen.Vector;
import com.cpseeker.vectorgen.VectorSet;
import com.cpseeker.vectorgen.vectorgroup.Group;


public class CloneDetector
{
	/**
	 * Default class' logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger("main");
	private static HashFamily hashFamily_;
	
	public CloneDetector(HashFamilyType type, int hashFunctions, int dimension, double radius)
	{
		hashFamily_ = HashFamilyFactory.buildHashFamily(type, hashFunctions, dimension, radius);
	}
	public Set<VectorSet> LSHCD(List<Group> groups)
	{
		LSH lsh = new LSH(hashFamily_);
		Set<VectorSet> clonesSet = new HashSet<VectorSet>();
		for(Group g : groups)
		{
			List<Vector> vectors = g.getVectors();
			lsh.setVectors(vectors);
			lsh.buildIndex();
			for(Iterator<Vector> iter = vectors.iterator(); iter.hasNext();)
			{
				Vector query = iter.next();
				VectorSet vectorSet = new VectorSet();
				List<Vector> neighbors = lsh.query(query, g.getSigma());
				vectorSet.addVectors(removeSpuriousClones(neighbors));
				if(vectorSet.getVectorSet().size() > 1)
					clonesSet.add(vectorSet);
				iter.remove();
			}
			logger.trace("End of group {}", g);
		}
		return clonesSet;
	}
	private static List<Vector> removeSpuriousClones(List<Vector> neighbors)
	{
		List<Vector> finalList = new ArrayList<>();
		boolean flag = true;
		for (int i = 0; i < neighbors.size(); i++)
		{
			Vector query = neighbors.get(i);
			List<Vector> sublist = new ArrayList<>(neighbors.subList(i + 1, neighbors.size()));
			for(Vector vector : sublist)
			{
				if(query.getCodeFragment().overlaps(vector.getCodeFragment()))
				{
					flag = false;
					break;
				}
			}
			if(flag) finalList.add(query);
			flag = true;
		}
		return finalList;
	}
}
