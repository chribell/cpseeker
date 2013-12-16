package com.cpseeker.vectorgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.CodeFragment;
import com.cpseeker.SourceFile;
import com.cpseeker.treegen.antlr.grammar.IGrammar;
import com.cpseeker.util.ParseTreeUtilities;
/**
 * 
 * @author chribell
 *
 */
public class CodeFragmentGenerator
{
	/**
	 * The logger responsible for the code fragments' logging.
	 */
	private static final Logger cfLogger_ = LoggerFactory.getLogger("codeFragment");
	/**
	 * {@link Vector}'s dimension.
	 */
	private static int points_;
	/**
	 * The number of minimum tokens.
	 */
	private static int tokens_;
	/**
	 * The number which defines the sliding
	 * window's width.
	 */
	private static int stride_;
	/**
	 * The grammar's rule names.
	 */
	private static String[] ruleNames_;
	/**
	 * The programming language's grammar.
	 */
	private static IGrammar grammar_;
	/**
	 * 
	 */
	private static SourceFile sourceFile_;
	
	
	private ParseTree root_;
	/**
	 * Public constructor.
	 * @param points
	 * 		{@link Vector}'s dimension.
	 * @param tokens
	 * 		The number of minimum tokens.
	 * @param stride
	 * 		The sliding window's width.
	 * @param ruleNames
	 * 		The parse tree's generator rule names.
	 * @param grammar
	 * 		The corresponding {@link IGrammar}. 
	 */
	public CodeFragmentGenerator(int points, int tokens, int stride, String[] ruleNames, IGrammar grammar)
	{
		points_ = points;
		tokens_ = tokens;
		stride_ = stride;
		ruleNames_ = ruleNames;	
		grammar_ = grammar;
	}
	/**
	 * 
	 * @param sourceFile
	 */
	public void setSourceFile(SourceFile sourceFile)
	{
		sourceFile_ = sourceFile;
	}
	/**
	 * Generates and returns a {@link Vector} of the corresponding
	 * parse tree. For the {@link Vector}
	 * @param tree
	 * 		The corresponding parse tree.
	 * @return
	 * 		A {@link Vector}.
	 */
	private Vector generateVector(ParseTree tree)
	{
		Vector vector = new Vector(points_);
	    for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	vector.merge(generateVector(tree.getChild(i)));
	    }
	    if(tree instanceof RuleNode)
	    {
	    	if(ParseTreeUtilities.isType(tree, grammar_.getRelevantNodes(), ruleNames_))
	    	{
	    		RuleContext rule = (RuleContext) tree;
	    		vector.increaseElementAt(rule.getRuleIndex());
	    	}
	    }
	    return vector;
	}
	/**
	 * 
	 * @param tree
	 * @param vectorsMap
	 */
	private void mapVectors(ParseTree tree, HashMap<ParseTree, Vector> vectorsMap)
	{
	    for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	mapVectors(tree.getChild(i), vectorsMap);
	    }
	    if(tree instanceof RuleNode)
	    {
    		vectorsMap.put(tree, generateVector(tree));
	    }
	}
	/**
	 * 
	 * @param vectorsMap
	 * @return
	 */
	private Set<CodeFragment> generateCodeFragments(HashMap<ParseTree, Vector> vectorsMap)
	{
		Set<CodeFragment> codeFragments = new HashSet<>();
		for(Map.Entry<ParseTree, Vector> entry : vectorsMap.entrySet())
		{
			//if the node is significant then create its corresponding code fragment
			if(ParseTreeUtilities.isType(entry.getKey(), grammar_.getSignificantNodes(), ruleNames_) &&
			   ParseTreeUtilities.containsEnoughTokens(entry.getKey(), tokens_))
			{
				CodeFragment codeFragment = new CodeFragment(ParseTreeUtilities.getLeftMostToken(entry.getKey()),
						   ParseTreeUtilities.getRightMostToken(entry.getKey()),
						   entry.getValue());
				if(sourceFile_.addCodeFragment(codeFragment))
					codeFragments.add(codeFragment);
			}
		}
		return codeFragments;
	}
	/**
	 * 
	 * @param vectorsMap
	 * @return
	 */
	private List<ParseTree> serialize(HashMap<ParseTree, Vector> vectorsMap)
	{
		List<ParseTree> serialTree = new ArrayList<>();
		Iterator<Entry<ParseTree, Vector>> iter = vectorsMap.entrySet().iterator();
		while (iter.hasNext()) 
		{
		    Map.Entry<ParseTree, Vector> entry = iter.next();
		    //serialize the parse tree only with mergeable nodes 
		    if(ParseTreeUtilities.isType(entry.getKey(), grammar_.getMergeableNodes(), ruleNames_))
		    {
		    	serialTree.add(entry.getKey());
		    }
		    else
		    {
		    	iter.remove();
		    }
		}
		return serialTree;
	}
	/**
	 * 
	 * @param serializedTree
	 * @param startIndex
	 * @return
	 */
	private List<ParseTree> constructSlidingWindow(List<ParseTree> serializedTree, int startIndex)
	{
		//the sliding window
		List<ParseTree> slidingWindow = new ArrayList<>();
		if(startIndex < serializedTree.size())
		{
			//temporary for selection purposes
			List<ParseTree> temp = new ArrayList<>();
			ParseTree first = serializedTree.get(startIndex);
			int height = ParseTreeUtilities.getHeight(root_, first);
			temp.add(first);
			for(int i = startIndex + 1; i < serializedTree.size(); i++)
			{
				ParseTree tree = serializedTree.get(i);
				if(ParseTreeUtilities.getHeight(root_, tree) == height)
				{
					temp.add(tree);
				}
			}
			if(temp.size() > 1)
			{
				ParseTree child = temp.get(0);
				slidingWindow.add(child);
				for(int i = 1; i < temp.size(); i++)
				{
					ParseTree parent = temp.get(i);
					if(ParseTreeUtilities.commonParent(child, parent, 2))
					{
						slidingWindow.add(parent);
						child = parent;
					}
					if(slidingWindow.size() == stride_) break;
				}
			}
		}
		return slidingWindow;
	}
	/**
	 * 
	 * @param slidingWindow
	 * @param vectorsMap
	 * @return
	 */
	private Vector mergeVectors(List<ParseTree> slidingWindow, HashMap<ParseTree,Vector> vectorsMap)
	{
		Vector merged = new Vector(points_);
		for(ParseTree tree : slidingWindow)
		{
			merged.merge(vectorsMap.get(tree));
		}
		return merged;
	}
	/**
	 * 
	 * @param serializedTree
	 * @param vectorsMap
	 * @return
	 */
	private List<CodeFragment> merge(List<ParseTree> serializedTree, HashMap<ParseTree,Vector> vectorsMap)
	{
		//the merged code fragments to be returned
		List<CodeFragment> mergedFragments = new ArrayList<>();
		List<ParseTree> slidingWindow = new ArrayList<>();
		//the front subtree of the sliding window
		int frontIndex = 0;
		slidingWindow = constructSlidingWindow(serializedTree, frontIndex);
		while(frontIndex != serializedTree.size())
		{
			//if the sliding window's size is equal to stride then merge its members
			if(slidingWindow.size() == stride_ && ParseTreeUtilities.containsEnoughTokens(slidingWindow, tokens_))
			{
				Vector vector = mergeVectors(slidingWindow, vectorsMap);
				CodeFragment merged = new CodeFragment(ParseTreeUtilities.getLeftMostToken(slidingWindow.get(0)),
			   			ParseTreeUtilities.getRightMostToken(slidingWindow.get(slidingWindow.size() - 1)),
			   			vector);
				if(sourceFile_.addCodeFragment(merged))
					mergedFragments.add(merged);
			}
			//slide the window by increasing the front index
			frontIndex++;
			//create the new sliding window
			slidingWindow = constructSlidingWindow(serializedTree, frontIndex);
		}
		return mergedFragments;
	} 
	/**
	 * 
	 * @param tree
	 * @return
	 */
	public Set<CodeFragment> generateCodeFragments(ParseTree tree)
	{
		root_ = tree;
		//construct a map with key a parse tree and value its 
		//corresponding vector
		HashMap<ParseTree,Vector> map = new LinkedHashMap<ParseTree,Vector>();
		//map the whole tree as serial (post order traversal), the usage of 
		//LinkedHashMap ensures the correct serialization of the parse tree 
		mapVectors(tree,map);
		//construct code fragments, for every node in the map which satisfies
		//a sequence of statements, create its corresponding code fragment
		Set<CodeFragment> codeFragments = generateCodeFragments(map);
		//construct a  serialized tree, but only with mergeable nodes
		//(parse trees), so their corresponding vectors can be merged
		List<ParseTree> serializedTree = serialize(map);
		//if and only if our stride is greater than 1 and smaller than the size
		//of the serialized tree, then merge the corresponding vectors
		//if stride is below 1 or greater than the size of the serialized tree
		//there is no meaning trying to merge the vectors 
		if(stride_ > 1 && stride_ < serializedTree.size())
		{
			//add merged vectors from serialTree
			codeFragments.addAll(merge(serializedTree,map));	
		}
		//better memory handling?
		map = null;
		log(codeFragments);
		return codeFragments;
	}
	private static void log(Set<CodeFragment> codeFragments)
	{
		cfLogger_.info("File: {}", sourceFile_.getFileName());
		cfLogger_.info("Number of code fragments: {}", codeFragments.size());
		cfLogger_.info("=========================================");
		for(CodeFragment cf : codeFragments)
		{
			cfLogger_.info("\t{}", cf.getStartingToken());
			cfLogger_.info("\t{}", cf.getEndingToken());
			cfLogger_.info("\tCode size: " + cf.getVector().getCodeSize());
			cfLogger_.info("-----------------------------------------");
		}
		cfLogger_.info("=========================================");
		cfLogger_.info("\n\n\n");
	}
	
}
