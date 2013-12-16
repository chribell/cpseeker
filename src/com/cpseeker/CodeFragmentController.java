package com.cpseeker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpseeker.lsh.HashFamilyType;
import com.cpseeker.treegen.TreeGenerator;
import com.cpseeker.treegen.UnsupportedInputStreamException;
import com.cpseeker.util.FileUtilities;
import com.cpseeker.vectorgen.CodeFragmentGenerator;
import com.cpseeker.vectorgen.Vector;
import com.cpseeker.vectorgen.VectorSet;
import com.cpseeker.vectorgen.vectorgroup.Group;
import com.cpseeker.vectorgen.vectorgroup.VectorGrouping;

public class CodeFragmentController 
{
	/**
	 * Default class' logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger("main");
	/**
	 * The parse tree generator.
	 */
	private static TreeGenerator tgen_;
	/**
	 * The code fragment generator.
	 */
	private static CodeFragmentGenerator cfgen_;
	/**
	 * A list with all the source files to be parsed.
	 */
	private static List<SourceFile> sourceFiles_;
	/**
	 * A list with all the generated vectors.
	 */
	private static List<Vector> vectors_;
	/**
	 * A list with all the vectors' groups.
	 */
	private static List<Group> groups_;
	
	public CodeFragmentController(String grammarName, int minimumTokens, int stride)
	{
		 initializeTreeGenerator(grammarName);
		 initializeCodeFragmentGenerator(minimumTokens, stride);
	}
	/**
	 * Initializes the parse tree generator.
	 * @param grammarName
	 * 		The grammar's name.
	 * @param firstRuleName
	 * 		The grammar's first rule name. 
	 */
	private void initializeTreeGenerator(String grammarName)
	{
		tgen_ = new TreeGenerator(grammarName);
	}
	/**
	 * Initializes the code fragment generator.
	 * @param minimumTokens
	 * 		The minimum number of tokens.
	 * @param stride
	 * 		The stride of the sliding window.
	 */
	private void initializeCodeFragmentGenerator(int minimumTokens, int stride)
	{
		cfgen_ = new CodeFragmentGenerator(tgen_.getRuleNumber(), minimumTokens, stride, tgen_.getRuleNames(), tgen_.getGrammar());
	}
	/**
	 * Creates the source files' {@link CodeFragment}s.
	 * @param path
	 * 		The path containing the source files.
	 * @param extensions
	 * 		The source files' extension(s).
	 * @throws FileNotFoundException
	 * 		If the corresponding file is not found throws exception.
	 */
	public void createCodeFragments(String path) throws FileNotFoundException
	{
		vectors_ = new ArrayList<>();
		sourceFiles_ = new ArrayList<>();
		path = path.replace("\\", "\\\\");
		String[] extensions = tgen_.getGrammar().getExtensions();
		for(String extension : extensions)
		{
			List<File> files = FileUtilities.readFiles(path, extension);
			for(File file : files)
			{
				try
				{
					//create file's parse tree
					ParseTree tree = tgen_.ParseTree(new FileInputStream(file));
					//create source file
					SourceFile sourceFile = new SourceFile(file);
					//set corresponding source file code fragments
					cfgen_.setSourceFile(sourceFile);
					//create source file's code fragments
					cfgen_.generateCodeFragments(tree);
					//get all the source file's vectors 
					vectors_.addAll(sourceFile.getVectors());
					//add every source file to the source file list
					sourceFiles_.add(sourceFile);
					logger.trace("{} code fragments for file {}", sourceFile.getCodeFragments().size() , file.getName());
				}
				catch(UnsupportedInputStreamException e)
				{
					System.err.println("Cannot create parse tree for file: " + file.getName() + ", check log for more info.");
				}
			}
		}
	}
	/**
	 * Groups the vectors according to their code size.
	 * @param vectors
	 * 		The vectors to be grouped.
	 * @param distance
	 * 		A parameter which is used in the group's bounds calculation.
	 * @param size
	 * 		A parameter which is used in the group's bounds calculation.
	 */
	private void groupVectors(List<Vector> vectors,double distance, int size)
	{
		groups_ = VectorGrouping.vectorGrouping(vectors, distance, size);
	}
	/**
	 * 
	 * @return
	 * 		The list which contains the parsed {@link SourceFile}s.
	 */
	public List<SourceFile> getSourceFiles()
	{
		return sourceFiles_;
	}
	/**
	 * Searches among the {@link CodeFragment}s' vectors for possible clones.
	 * @param hashFunctions
	 * 		The number of hash functions to be used.
	 * @param minTokens
	 * 		The number of minimum tokens.
	 * @param similarity
	 * 		The similarity factor.
	 * @return
	 * 		A {@link HashMap} which contains the clones.
	 * 		The map's key field is the query vector and its
	 * 		value is the vector's neighbors a.k.a. clones.
	 */
	public Set<VectorSet> seekClones(int hashFunctions, int minTokens, double similarity)
	{
		logger.info("Amount of vectors {}", vectors_.size());
		Set<VectorSet> clones = new HashSet<VectorSet>();
		if(vectors_.size() > 0)
		{	
			//for group generation use the number of minimum tokens as "code size"
			groupVectors(vectors_, similarity, minTokens);				
			//4.0 or another double value?
			CloneDetector cd = new CloneDetector(HashFamilyType.EUCLIDEAN, hashFunctions, tgen_.getRuleNumber(), 4.0);
			//send the groups 
			clones = cd.LSHCD(groups_);
		}
		return clones;
	}
}
