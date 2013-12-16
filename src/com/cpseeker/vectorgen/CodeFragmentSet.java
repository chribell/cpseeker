package com.cpseeker.vectorgen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cpseeker.CodeFragment;

public class CodeFragmentSet 
{
	private Set<CodeFragment> codeFragments_;
	
	public CodeFragmentSet()
	{
		codeFragments_ = new HashSet<CodeFragment>();
	}	
	
	public Set<CodeFragment> getCodeFragmentSet()
	{
		return codeFragments_;
	}
	
	public boolean add(CodeFragment codeFragment)
	{
		//not sure must check in case of multiple overlaps
		for(Iterator<CodeFragment> iter = codeFragments_.iterator(); iter.hasNext();)
		{
			CodeFragment cf = iter.next();
			if(cf.overlaps(codeFragment))
			{
				//let the cf be the constant and the codeFragment the query
				if(cf.getStartLine() < codeFragment.getStartLine() && cf.getEndLine() < codeFragment.getEndLine())
				{
					iter.remove();
					CodeFragment merged = new CodeFragment(cf.getStartToken(), codeFragment.getEndToken() , new Vector(0));
					merged.setSourceFile(cf.getSourceFile());
					return codeFragments_.add(merged);
				}
				else if(cf.getStartLine() > codeFragment.getStartLine() && cf.getEndLine() > codeFragment.getEndLine())
				{
					iter.remove();
					CodeFragment merged = new CodeFragment(codeFragment.getStartToken(), cf.getEndToken() , new Vector(0));
					merged.setSourceFile(cf.getSourceFile());
					return codeFragments_.add(merged);
				}
				else if(cf.getStartLine() > codeFragment.getStartLine() && cf.getEndLine() < codeFragment.getEndLine())
				{
					iter.remove();
					return codeFragments_.add(codeFragment);
				}
				return false;
			}
		}
		return codeFragments_.add(codeFragment);
	}
	
	public void addAll(List<CodeFragment> codeFragments)
	{
		for(CodeFragment cf : codeFragments)
		{
			add(cf);
		}
	}
	public long sumLines()
	{
		long lines = 0;
		for(CodeFragment cf : codeFragments_)
		{
			lines += cf.getAmountOfLines();
		}
		return lines;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true;
		if(!(o instanceof VectorSet)) return false;
		CodeFragmentSet cfSet = (CodeFragmentSet)o;
		if (cfSet.codeFragments_.size() != codeFragments_.size()) return false;
		if (cfSet.codeFragments_.containsAll(codeFragments_)) return true;
		return false;
	}
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		for (CodeFragment cf : codeFragments_) 
		{
			hashCode += cf.hashCode();
		}
		return hashCode;
	}
}
