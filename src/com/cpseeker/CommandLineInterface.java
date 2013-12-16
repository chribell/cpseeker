package com.cpseeker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.LoggerFactory;

import com.cpseeker.util.ClonedLinesCalculator;
import com.cpseeker.util.FileUtilities;
import com.cpseeker.util.HTMLBuilder;
import com.cpseeker.vectorgen.VectorSet;

import ch.qos.logback.classic.Level;

public class CommandLineInterface
{
	private static ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("main");
	private ch.qos.logback.classic.Logger cfLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("codeFragment");
	private ch.qos.logback.classic.Logger hLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("hashing");
	private CommandLine commandLine_ = null;
	private Options options_ = null;
	
	private String[] arguments_;

	private String path_;
	private String language_ = "Java7";
//	private String hashFamily_ = "EUCLIDEAN";
	private String outputPath_ = "";
	
	private int stride_ = 4;
	private int minimumTokens_ = 30;
	private int hashFunctions_ = 3;
	private double similarity_ = 0.9;
	private boolean default_ = true;
	
	private long clonedLoC_ = 0;
	private CodeFragmentController cfController_; 
	public CommandLineInterface(String[] arguments)
	{
		arguments_ = arguments;
		constructOptions();
	}
	private void constructOptions()
	{
		options_ = new Options();
		options_.addOption("p", true, "the source files' path");
		options_.addOption("l", true, "the language (e.g. java)");
		//TODO add interface for supporting  different hash families
		//options_.addOption("f", true, "the hash family (e.g. euclidean)");
		options_.addOption("h", true, "the number of hash functions to be used (e.g. 3)");
		options_.addOption("s", true, "stride (e.g. 4)");
		options_.addOption("sim", true, "similarity factor (e.g. 0.9)");
		options_.addOption("t", true, "the number of minimum tokens (e.g. 30)");
		options_.addOption("help", false, "prints help");
		options_.addOption("o", true, "the results' output path");
		options_.addOption("c", true, "the method for calculating the overall cloned lines of code (e.g. 2)\n" +
				" 1.Skips the lines of the overlapping code fragments\n 2.Counts the lines of the overlapping code fragments");
		options_.addOption("debug", false, "run program in debug mode (more info about code fragments' generation etc)");
	}
	private void parseArguments()
	{
		CommandLineParser parser = new BasicParser();
		try
		{
			commandLine_ = parser.parse(options_, arguments_);
		}
		catch (ParseException e)
		{ 
			logger.error("", e);
			printHelp();
			System.exit(-1);
		}
		if(commandLine_.hasOption("debug"))
		{
			System.out.println("DEBUG MODE");
			cfLogger.setLevel(Level.TRACE);	
			hLogger.setLevel(Level.TRACE);
		}
		else
		{
			cfLogger.getAppender("CODEFRAGMENTS").stop();
			hLogger.getAppender("HASHING").stop();
			FileUtilities.deleteFile("Hashing.log");
			FileUtilities.deleteFile("CodeFragments.log");
		}
		if(commandLine_.hasOption("help"))
		{
			printHelp();
			System.exit(0);
		}
		else
			getValues();
	}
	private void getValues()
	{
		//get path
		if(!commandLine_.hasOption('p'))
		{
			System.out.println("Error: Path not given. Application terminated.");
			logger.error("Path not given");
			printHelp();
			System.exit(-1);
		}
		else
			path_ = commandLine_.getOptionValue('p');
		File path = new File(path_);
		if(!path.exists())
		{
			System.out.println("Error: Invalid path given. Application terminated.");
			logger.error("Invalid path given");
			printHelp();
			System.exit(-1);
		}
		if(path.isFile())
			outputPath_ = path.getParent();
		else
			outputPath_ = path_;
		if(commandLine_.hasOption('o'))
		{
			outputPath_ = commandLine_.getOptionValue('o');
			if(!FileUtilities.directoryExists(outputPath_))
			{
				System.out.println("Error: Invalid output path.");
				System.out.println("Output path set to default");
				logger.error("Invalid output path");
				outputPath_ = path_;
			}
		}
		//get language
		if(commandLine_.hasOption('l'))
		{
			language_ = commandLine_.getOptionValue('l');
		}
		//get hash family
		/*if(commandLine_.hasOption('f'))
		{
			hashFamily_ = commandLine_.getOptionValue('f');
		}*/
		//get hash functions
		if(commandLine_.hasOption('h'))
		{
			hashFunctions_ = getIntegerValue(commandLine_.getOptionValue('h'));
		}
		//get minimum tokens
		if(commandLine_.hasOption('t'))
		{
			minimumTokens_ = getIntegerValue(commandLine_.getOptionValue('t'));
		}
		//get stride
		if(commandLine_.hasOption('s'))
		{
			stride_ = getIntegerValue(commandLine_.getOptionValue('s'));
		}
		//get similarity
		if(commandLine_.hasOption("sim"))
		{
			similarity_ = getDoubleValue(commandLine_.getOptionValue("sim"));
			if(1 < similarity_)
			{
				System.out.println("Similarity must be below or equal to 1");
				similarity_ = 0.9;
				System.out.println("Setting Similarity = 0.9");
			}
		}
		//get method for calculating cloned lines of code
		if(commandLine_.hasOption('c'))
		{
			int num = getIntegerValue(commandLine_.getOptionValue('c'));
			switch(num)
			{
				case 1:
					default_ = false;
					break;
				case 2:
					default_ = true;
					break;
				default:
					System.out.println("Invalid argument for cloned lines calculation, will count overlapping code fragments.");
					break;
			}
			
		}
	}
	private void printHelp()
	{
		HelpFormatter hf = new HelpFormatter();
		hf.printHelp("CPSeeker", options_);
		System.out.println("The examples are the program's default values");
		System.out.println("If the input path or the output path contain space character(s)\nthe path must be quoted (e.g. -o \"C:\\hello world\")");
	}
	private int getIntegerValue(String string)
	{
		Integer integerValue = null;
		try
		{
			integerValue = Integer.parseInt(string);
		}
		catch(NumberFormatException e)
		{
			logger.error("Value {} is not an integer.", string);
		}
		return integerValue;
	}
	private double getDoubleValue(String string)
	{
		Double doubleValue = null;
		try
		{
			doubleValue = Double.parseDouble(string);
		}
		catch(NumberFormatException e)
		{
			logger.error("Value {} is not a double.", string);
		}
		return doubleValue;		
	}
	public void start()
	{
		parseArguments();
		//initialize the code fragment controller
		cfController_ = new CodeFragmentController(language_, minimumTokens_, stride_);
		try 
		{
			System.out.println("Creating code fragments....");
			cfController_.createCodeFragments(path_);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, check log for more information.");
			logger.error("", e);
		}
		System.out.println("Code fragments generation completed.");
		//create the output directory where the clone report will be placed 
		createOutputDirectory();
		//create output (search for clones and deploy them in html format)
		createOutput();
		System.out.println("Done, reports in folder " + outputPath_.replace("\\\\", "\\"));
	}
	private void createOutputDirectory()
	{
		outputPath_ += File.separator + "CloneReport";
		if(FileUtilities.directoryExists(outputPath_))
			FileUtilities.deleteDirectory(outputPath_);
		else
			FileUtilities.createDirectory(outputPath_);
		FileUtilities.copyFiles("output", outputPath_);
	}
	private void createOutput()
	{
		List<String> fileNames = new ArrayList<>();
		List<SourceFile> sourceFiles = cfController_.getSourceFiles();
		logger.trace("LSH start");
		System.out.println("Grouping vectors and applying LSH.");
		Set<VectorSet> codeClones = cfController_.seekClones(hashFunctions_, minimumTokens_, similarity_);
		System.out.println("End of LSH.");
		logger.trace("LSH end");
		try 
		{		
			for(SourceFile sf : sourceFiles)
			{
				List<VectorSet> sfClones = new ArrayList<>();
				for(VectorSet vectorSet : codeClones)
				{
					if(vectorSet.containsFile(sf))
						sfClones.add(vectorSet);
				}
				if(sfClones.size() > 0)
				{
					System.out.println("Constructing " + sf.getFileName() + ".html clone report.");
					HTMLBuilder.buildHTML(sf.getFileName(), sfClones, outputPath_);
					fileNames.add(sf.getFileName());
				}
			}
			//cloned lines of code (to get a picture about the "clones' size")
			System.out.println("Calculating cloned lines of code...");
			if(default_)
			{
				System.out.println("Counting overlapping code fragments.");
				clonedLoC_ = ClonedLinesCalculator.getClonedLinesOfCodeWithOverlap(codeClones);
			}
			else
			{
				System.out.println("Skiping overlapping code fragments.");
				clonedLoC_ = ClonedLinesCalculator.getClonedLinesOfCodeWithoutOverlap(codeClones);
			}
			//first parameter is a string array about the parameters
			//second parameter is a string array which contains the file names of the source code files
			//third and last parameter is the output path to deploy the index.html file
			System.out.println("Constructing index.html.");
			HTMLBuilder.buildIndex(consturctInfo(), fileNames.toArray(new String[fileNames.size()]), outputPath_);
		} 
		catch (Exception e) 
		{
			System.out.println("Error, check log for more information");
			logger.error("", e);
		}		
	}
	private String[] consturctInfo()
	{
		String[] info = new String[6];
		info[0] = "Language:" + language_;
		info[1] = "Minimum Tokens:" + minimumTokens_; 
		info[2] = "Similarity:" + similarity_;
		info[3] = "Stride:" + stride_;
		info[4] = "Hash Functions used:" + hashFunctions_;
		info[5] = "Cloned Lines of Code:" + clonedLoC_ ;
		return info;
	}
}
