package com.cpseeker;

import org.antlr.v4.runtime.Token;

import com.cpseeker.vectorgen.Vector;

/**
 * Describes a source file's code fragment.
 * @author chribell
 *
 */
public class CodeFragment 
{
	/**
	 * The fragment's {@link SourceFile}.
	 */
	private SourceFile sourceFile_;
	/**
	 * The fragment's start {@link Token}.
	 */
	private Token startToken_;
	/**
	 * The fragment's end {@link Token}.
	 */
	private Token endToken_;
	/**
	 * The fragment's characteristic {@link Vector}.
	 */
	private Vector vector_;
	/**
	 * Public constructor.
	 * @param serialTree
	 * 			A parse tree.
	 * @param vector
	 * 			A {@link Vector}.
	 */
	public CodeFragment(Token startToken, Token endToken,Vector vector)
	{
		startToken_ = startToken;
		endToken_ = endToken;
		vector_ = vector;
		vector.setCodeFragment(this);
	}
	/**
	 * Returns the fragment's vector.
	 * @return
	 * 			The {@link Vector}.
	 */
	public Vector getVector()
	{
		return vector_;
	}
	/**
	 * Sets the fragment's source file's name.
	 * @param sourceFile
	 * 			The source file's name to be set.
	 */
	public void setSourceFile(SourceFile sourceFile)
	{
		sourceFile_ = sourceFile;
	}
	/**
	 * Returns fragment's source file's name.
	 * @return
	 * 			The source file's name.
	 */
	public SourceFile getSourceFile()
	{
		return sourceFile_;
	}
	/**
	 * 
	 * @return
	 * 		The fragment's starting line in the source file.
	 */
	public int getStartLine()
	{
		return startToken_.getLine();
	}
	/**
	 * 
	 * @return
	 * 		The fragment's ending line in the source file.
	 */
	public int getEndLine()
	{
		if(endToken_.getType() == Token.EOF)
			return endToken_.getLine() - 1;
		return endToken_.getLine();
	}
	/**
	 * 
	 * @return
	 * 		The fragment's amount of lines.
	 */
	public int getAmountOfLines()
	{
		return getEndLine() - getStartLine() + 1;
	}
	public Token getStartToken()
	{
		return startToken_;
	}
	public Token getEndToken()
	{
		return endToken_;
	}
	/**
	 * Checks if the code fragment overlaps with the query
	 * code fragment.
	 * @param codeFragment
	 * 		The query code fragment.
	 * @return
	 * 		True if there is an overlap, otherwise false.
	 */
	public boolean overlaps(CodeFragment codeFragment)
	{
		return sourceFile_.equals(codeFragment.getSourceFile()) &&
		(getStartLine() <= codeFragment.getEndLine()) && (codeFragment.getStartLine() <= getEndLine());
	}
	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true;
		if(!(o instanceof CodeFragment)) return false;
		CodeFragment cf = (CodeFragment) o;
		return sourceFile_.equals(cf.getSourceFile()) &&
			   startToken_ == cf.getStartToken() &&
			   endToken_ == cf.getEndToken();
	//&&       vector_.equals(cf.getVector());
	}
	@Override
	public int hashCode()
	{
		int hash = 17;
		hash = 31 * hash + sourceFile_.hashCode();
		hash = 31 * hash + startToken_.hashCode();
		hash = 31 * hash + endToken_.hashCode();
//		hash = 31 * hash + vector_.getVector().hashCode();
		return hash;
	}
	public String getStartingToken()
	{
		return 	"Starting token: " + startToken_.getText() + " at line " + startToken_.getLine();
	}
	public String getEndingToken()
	{
		return "Ending token: " + endToken_.getText() + " at line " + endToken_.getLine();
	}
	@Override
	public String toString()
	{
		return  "Source File: " + sourceFile_.getFileAbsolutePath() + "\n" 
				+ getStartingToken() + "\n" + getEndingToken();
	}
}
