package com.cpseeker.util;

import java.util.List;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ParseTreeUtilities
{
	public static boolean isTerminal(ParseTree tree)
	{
		return tree instanceof TerminalNode ? true : false;
	}
	public static boolean isNonTerminal(ParseTree tree)
	{
		return !(tree instanceof TerminalNode) ? true : false; 
	}
	public static boolean isMergeable(ParseTree tree, String[] nodes, String[] ruleNames, int tokens)
	{
		return (isType(tree,nodes,ruleNames) && containsEnoughTokens(tree, tokens)) ? true : false;
	}
	public static boolean containsEnoughTokens(ParseTree tree, int tokens)
	{
		return tokens > countTokens(tree) ? false : true;
	}
	public static boolean containsEnoughTokens(List<ParseTree> trees, int tokens)
	{
		int sumTokens = 0;
		for(ParseTree tree : trees)
		{
			sumTokens += countTokens(tree);
		}
		return tokens > sumTokens ? false : true;
	}
	public static boolean isType(ParseTree tree, String[] nodes, String[] ruleNames)
	{
		if(tree instanceof RuleNode)
		{
			RuleContext rule = (RuleContext)tree;
			for(String node : nodes)
				if(ruleNames[rule.getRuleIndex()].equals(node))
					return true;
		}
		return false;
	}
	private static int countTokens(ParseTree tree)
	{
		int count = 0;
	    for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	count += countTokens(tree.getChild(i));
	    }
	    if(tree instanceof TerminalNode)
	    {
	    	count++;
	    }
		return count;
	}
	public static void serializeParseTreePostOrder(ParseTree tree, List<ParseTree> serialTree)
	{
		for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	serializeParseTreePostOrder(tree.getChild(i), serialTree);
	    }
		serialTree.add(tree);
	}
	public static void serializeParseTreeInOrder(ParseTree tree, List<ParseTree> serialTree)
	{
		serialTree.add(tree);
	    for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	serializeParseTreeInOrder(tree.getChild(i), serialTree);
	    }
	}
	public static Token getLeftMostToken(ParseTree tree)
	{
		Token token = null;
		for (int i = 0; i < tree.getChildCount(); ++i)
	    {
			token = getLeftMostToken(tree.getChild(i));
			if(null != token)
				break;
	    }
		if(tree instanceof TerminalNode)
		{
			TerminalNode tn = (TerminalNode) tree;
			token = tn.getSymbol();
		}
		return token;
	}
	public static Token getRightMostToken(ParseTree tree)
	{
		Token token = null;
		for (int i = tree.getChildCount()-1; i >= 0; i--)
	    {
			token = getRightMostToken(tree.getChild(i));
			if(null != token)
				break;
	    }
		if(tree instanceof TerminalNode)
		{
			TerminalNode tn = (TerminalNode) tree;
			token = tn.getSymbol();
		}
		return token;
	}
	public static String getCode(ParseTree tree)
	{
		String s = "";
	    for (int i = 0; i < tree.getChildCount(); ++i)
	    {
	    	s += getCode(tree.getChild(i)) + " ";
	    }
	    if(tree instanceof TerminalNode)
	    {
	    	TerminalNode tn = (TerminalNode)tree;
	    	s += tn.getText();
	    }
		return s;
	}
	public static boolean hasChild(ParseTree parent, ParseTree child)
	{
		boolean flag = false;
		for(int i = 0; i < parent.getChildCount(); i++)
		{
			flag = hasChild(parent.getChild(i), child);
			if(flag) break;
		}
		if(parent == child)
		{
			flag = true;
		}
		return flag;
	}
	public static int getHeight(ParseTree root, ParseTree tree)
	{
		if(root == tree) return 0;
		return 1 + getHeight(root, tree.getParent());
	}
	public static boolean commonParent(ParseTree tree1, ParseTree tree2, int depth)
	{
		if(tree1 == tree2) return true;
		for(int i = 0; i < depth; i++)
		{
			tree1 = tree1.getParent();
			tree2 = tree2.getParent();
			if(tree1 == tree2) return true;	
		}
		return false;
	}
}
