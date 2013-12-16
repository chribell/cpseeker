package com.cpseeker.treegen;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.treegen.antlr.grammar.IGrammar;
import com.cpseeker.util.Utilities;

/**
 * The class responsible for the parse tree generation.
 * @author chribell
 *
 */
public class TreeGenerator 
{
	/**
	 * The programming language's grammar.
	 */
	private static IGrammar grammar_ = null;
	/**
	 * Default class's logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger("main");
	/**
	 * Used to construct different lexers, according to the 
	 * grammar to be parsed.
	 */
	private static Class<? extends Lexer> lexerClass_ = null;
	/**
	 * ANTLR's lexer object.
	 */
	private static Lexer lexer_ = null;
	/**
	 * Used to construct different parsers, according to the 
	 * grammar to be parsed.
	 */
	private static Class<? extends Parser> parserClass_ = null;
	/**
	 * ANTLR's parser object.
	 */
	private static Parser parser_ = null;
	/**
	 * Public constructor.
	 * @param grammarName
	 * 		The grammar name which identifies the source files'
	 * 		programming language. Needed for {@link Lexer} and
	 * 		{@link Parser} construction. 
	 */
	public TreeGenerator(String grammarName) 
	{
		logger.trace("TreeGenerator constructor");
		//first create the corresponding IGrammar instance
		String grammar = "cpseeker.treegen.antlr.grammar." + grammarName + "Grammar";
		Class<?> grammarClass = null;
		try 
		{
			grammarClass = Class.forName(grammar);
			grammar_ = (IGrammar)grammarClass.newInstance();
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) 
		{
			logger.error("Couldn't create grammar {} instance", grammar); 
			logger.error("",e);
			System.exit(-1);
		}
		//then create the grammar's ANTLR lexer and parser 
		String lexerName = "cpseeker.treegen.antlr.grammar." + Utilities.firstCharToLowerCase(grammarName) + "." + grammarName + "Lexer";
		String parserName = "cpseeker.treegen.antlr.grammar." + Utilities.firstCharToLowerCase(grammarName) + "." +  grammarName + "Parser";
		ClassLoader classLoader = TreeGenerator.class.getClassLoader();
		try 
		{
			logger.trace("Creating {}'s corresponding lexer class", grammarName);
			lexerClass_ = classLoader.loadClass(lexerName).asSubclass(Lexer.class);
		}
		catch (ClassNotFoundException e1) 
		{
			logger.error("Class {} was not found", lexerName);
		}
		try 
		{
			Constructor<? extends Lexer> lexerConstructor = lexerClass_.getConstructor(CharStream.class);
			logger.trace("Constructing lexer object");
			lexer_ = lexerConstructor.newInstance((CharStream)null);
			logger.trace("Creating {}'s corresponding parser class", grammarName);
			parserClass_ = classLoader.loadClass(parserName).asSubclass(Parser.class);
			Constructor<? extends Parser> parserConstructor = parserClass_.getConstructor(TokenStream.class);
			logger.trace("Constructing parser object");
			parser_ = parserConstructor.newInstance((TokenStream)null);
			parser_.setErrorHandler(new BailErrorStrategy());
		} 
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e)
		{
			logger.error("",e);
		}
		logger.trace("TreeGenerator end of constructor");
	}
	/**
	 * Given a file's input stream, it returns its parse tree.
	 * @param inputStream
     * 		The file's input stream.
	 * @return
	 */
	public ParseTree ParseTree(InputStream inputStream) throws UnsupportedInputStreamException
	{
		try
		{
			ANTLRInputStream input = new ANTLRInputStream(inputStream);
			lexer_.setInputStream(input);
		} 
		catch (IOException e1) 
		{
			logger.error("Invalid input stream");
		}
		CommonTokenStream tokens = new CommonTokenStream(lexer_);
		tokens.fill();
		parser_.setTokenStream(tokens);
		ParseTree tree = null;
		try 
		{
			Method firstRule = parserClass_.getMethod(grammar_.getFirstRule());
			tree = (ParserRuleContext)firstRule.invoke(parser_, (Object[])null);
		}
		catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			logger.error("",e);
			throw new UnsupportedInputStreamException(e);
		}
		return tree;
	}
	/**
	 * 
	 * @return
	 * 		The parser's rules number n, used to
	 * 		create the n-dimension vectors.
	 */
	public int getRuleNumber()
	{
		return parser_.getRuleNames().length;
	}
	/**
	 * 
	 * @return
	 * 		The parser's rule names.
	 */
	public String[] getRuleNames()
	{
		return parser_.getRuleNames();
	}
	/**
	 * 
	 * @return
	 * 		The {@link IGrammar} used for the parse trees' generation.
	 */
	public IGrammar getGrammar()
	{
		return grammar_;
	}
}
