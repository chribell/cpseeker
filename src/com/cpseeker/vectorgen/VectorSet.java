package com.cpseeker.vectorgen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cpseeker.CodeFragment;
import com.cpseeker.SourceFile;

public class VectorSet 
{
	private Set<Vector> vectors_;
	public VectorSet()
	{
		vectors_ = new HashSet<Vector>();
	}	
	public Set<Vector> getVectorSet()
	{
		return vectors_;
	}
	public void addVectors(List<Vector> vectors)
	{
		vectors_.addAll(vectors);
	}	
	public List<CodeFragment> getCodeFragmentSet()
	{
		List<CodeFragment> codeFragments = new ArrayList<>();
		for(Vector vector : vectors_)
		{
			codeFragments.add(vector.getCodeFragment());
		}
		return codeFragments;
	}
	public boolean containsFile(SourceFile file) 
	{		
		for (Vector v : vectors_) 
		{
			if (v.getCodeFragment().getSourceFile().equals(file)) 
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true;
		if(!(o instanceof VectorSet)) return false;
		VectorSet vSet = (VectorSet)o;
		if (vSet.vectors_.size() != vectors_.size()) return false;
		if (vSet.vectors_.containsAll(vectors_)) return true;
		return false;
	}
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		for (Vector v : vectors_) 
		{
			hashCode += v.hashCode();
		}
		return hashCode;
	}
}
