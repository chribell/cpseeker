package com.cpseeker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cpseeker.vectorgen.Vector;

/**
 * Describes a file of source code.
 * @author chribell
 *
 */
public class SourceFile 
{
	/**
	 * The source file's, {@link File} reference. 
	 */
	private File file_;
	/**
	 * The source file's {@link CodeFragment}s.
	 */
	private Set<CodeFragment> codeFragments_;
	/**
	 * Public constructor.
	 * @param file
	 * 		A {@link File} reference.
	 * @param codeFragments
	 * 		The {@link CodeFragment} list to be set.
	 */
	public SourceFile(File file)
	{
		file_ = file;
		codeFragments_ = new HashSet<CodeFragment>();
	}
	/**
	 * 
	 * @return
	 * 		The source file's absolute path.
	 */
	public String getFileAbsolutePath()
	{
		return file_.getAbsolutePath();
	}
	/**
	 *  
	 * @return
	 * 		The source file's name.
	 */
	public String getFileName()
	{
		return file_.getName();
	}
	/**
	 * Adds a {@link CodeFragment} to the source file's
	 * code fragments list.
	 * @param codeFragment
	 * 		The {@link CodeFragment} to be added.
	 * @return
	 * 		True if the insertion was successful,
	 * 		otherwise false.
	 */
	public boolean addCodeFragment(CodeFragment codeFragment)
	{
		codeFragment.setSourceFile(this);
		return codeFragments_.add(codeFragment);
	}
	/**
	 * Sets the source file's {@link CodeFragment} list to a specific.
	 * @param codeFragments
	 * 		The list to be set.
	 */
	public void setCodeFragments(Set<CodeFragment> codeFragments)
	{
		codeFragments_ = codeFragments;
	}
	/**
	 * Returns the source file's {@link CodeFragment} list.
	 * @return
	 * 		The {@link CodeFragment} list.
	 */
	public Set<CodeFragment> getCodeFragments()
	{
		return codeFragments_;
	}	
	/**
	 * Returns the source file's {@link Vector} list.
	 * @return
	 * 		The {@link Vector} list.
	 */
	public List<Vector> getVectors()
	{
		List<Vector> vectors = new ArrayList<>();
		for(CodeFragment cf : codeFragments_)
		{
			vectors.add(cf.getVector());
		}
		return vectors;
	}
}
