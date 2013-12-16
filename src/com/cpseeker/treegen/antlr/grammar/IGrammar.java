package com.cpseeker.treegen.antlr.grammar;

public interface IGrammar 
{
	/**
	 * 
	 * @return
	 * 		The grammar's name.
	 */
	public String   getName();
	/**
	 * 
	 * @return
	 * 		The grammar's first rule.
	 */
	public String   getFirstRule();
	/**
	 * 
	 * @return
	 * 		The language's file extensions.
	 */
	public String[] getExtensions();
	/**
	 * Only for a relevant node(subtree)
	 * the corresponding vector is updated.
	 * @return
	 * 		The grammar's relevant nodes.
	 */
	public String[] getRelevantNodes();
	/**
	 * The vectors of the mergeable nodes
	 * are going to be merged.
	 * @return
	 * 		The grammar's mergeable nodes.
	 */
	public String[] getMergeableNodes();
	/**
	 * Only for a significant node(subtree)
	 * the corresponding vector is generated.
	 * @return
	 * 		The grammar's significant nodes
	 */
	public String[] getSignificantNodes();
}
