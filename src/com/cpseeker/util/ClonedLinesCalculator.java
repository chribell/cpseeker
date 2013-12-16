package com.cpseeker.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cpseeker.CodeFragment;
import com.cpseeker.vectorgen.CodeFragmentSet;
import com.cpseeker.vectorgen.VectorSet;

/**
 * A class responsible for the cloned lines calculation.
 * @author chribell
 *
 */
public class ClonedLinesCalculator 
{
	/**
	 * Calculates the number of cloned lines of code, counting
	 * the lines of the overlapping {@link CodeFragment}s.
	 * @param clones
	 * 		The set containing the cloned {@link CodeFragment}s.
	 * @return
	 * 		The number of cloned lines of code.
	 */
	public static long getClonedLinesOfCodeWithOverlap(Set<VectorSet> clones)
	{
		long lines = 0;
		List<CodeFragment> codeFragments = new ArrayList<>();
		for(VectorSet set : clones)
		{
			codeFragments.addAll(set.getCodeFragmentSet());
		}
		for(CodeFragment cf : codeFragments)
		{
			lines += cf.getAmountOfLines();
		}
		return lines;
	}
	/**
	 * Calculates the number of cloned lines of code, without counting
	 * same lines twice or more.
	 * @param clones
	 * 		The set containing the cloned {@link CodeFragment}s.
	 * @return
	 * 		The number of cloned lines of code.
	 */
	public static long getClonedLinesOfCodeWithoutOverlap(Set<VectorSet> clones)
	{
		CodeFragmentSet cfSet = new CodeFragmentSet();
		for(VectorSet cloneSet : clones)
		{
			cfSet.addAll(cloneSet.getCodeFragmentSet());
		}
		return cfSet.sumLines();
	}
}
