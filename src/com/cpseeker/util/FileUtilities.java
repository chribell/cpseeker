package com.cpseeker.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class with some useful file handling methods.
 * @author chribell
 *
 */
public final class FileUtilities 
{
	private static final Logger logger = LoggerFactory.getLogger(FileUtilities.class);
	/**
	 * Reads and returns a List of {@link File}s of a specific extension. 
	 * @param path
	 * 		The path to be searched.
	 * @param extension
	 * 		The specific files' extension.
	 * @return
	 * 		The List of {@link File}s.
	 */
	public static List<File> readFiles(String path,String extension)
	{
		List<File> fileList = new ArrayList<>();
		File dir = new File(path);  
		if(dir.isDirectory())
		{
			Collection<File> files = FileUtils.listFiles(dir, new RegexFileFilter("^.*\\." + extension + "$"), DirectoryFileFilter.DIRECTORY);
			fileList.addAll(files);
		}
		else
			fileList.add(dir);
		logger.info("Number of files: {}", fileList.size());
		return fileList;
	}	
	/**
	 * Reads and returns a string found in the given borders(file's starting/ending line).
	 * @param file
	 * 		The file to be read.
	 * @param startLine
	 * 		The starting line.
	 * @param endLine
	 * 		The ending line.
	 * @return
	 * 		The text contained in the given borders of the file as string.
	 */
	public static String readFileRange(File file, int startLine, int endLine)
	{
		String s = "";
		List<String> lines = null;
		List<String> fileLines = null;
		try 
		{
			fileLines = FileUtils.readLines(file);
		} 
		catch (IOException e) 
		{
			logger.error("", e);
		}
		try
		{
			lines = fileLines.subList(startLine - 1, endLine);
		}
		//this exception should occur only when the last 
		//line of the file contains no characters
		catch(IndexOutOfBoundsException e)
		{
			logger.error("Index out of bounds. File {} , start line {} , end line {}", file.getAbsolutePath(), startLine, endLine);
			lines = fileLines.subList(startLine - 1, endLine - 1);
		}
		for(String line : lines)
		{
			s += line + "\n";
		}
		return s;
	}
	/**
	 * Checks if a directory exists.
	 * @param directoryPath
	 * 		The directory to be checked.
	 * @return
	 * 		True if the given directory exists,
	 * 		otherwise false.
	 */
	public static boolean directoryExists(String directoryPath)
	{
		File directory = new File(directoryPath);
		return directory.exists();
	}
	/**
	 * Creates a directory.
	 * @param directoryPath
	 * 		The directory to be created.
	 * @return
	 * 		True if the directory's creation was successful,
	 * 		otherwise false.
	 */
	public static boolean createDirectory(String directoryPath)
	{
		boolean flag = false; 
		File directory = new File(directoryPath);
		// if the directory does not exist, create it
		if (!directory.exists()) 
		{
			flag = directory.mkdir();
		}
		return flag;
	}
	/**
	 * Deletes a given directory.
	 * @param directoryPath
	 * 		The directory to be deleted.
	 * @return
	 * 		True if the directory's deletion was successful,
	 * 		otherwise false. 
	 */
	public static boolean deleteDirectory(String directoryPath)
	{
		boolean flag = false;
		File directory = new File(directoryPath);
		if(directory.exists())
		{
			flag = true;
			//try to delete the directory
			try 
			{
				//first delete every file within the directory
				FileUtils.cleanDirectory(directory);
				//FileDeleteStrategy.FORCE.delete(directory);
				//then delete the directory itself
				FileUtils.deleteDirectory(directory);
				//note: if there more than one subdirectories within the
				//main directory this function must be recursive
			} 
			catch (IOException e) 
			{
				logger.error("", e);
			}
		}
		return flag;
	}
	/**
	 * Deletes a given directory.
	 * @param directoryPath
	 * 		The directory to be deleted.
	 * @return
	 * 		True if the directory's deletion was successful,
	 * 		otherwise false. 
	 */
	public static boolean deleteFile(String filePath)
	{
		boolean flag = false;
		File file = new File(filePath);
		if(file.exists())
		{
			file.setWritable(true);
			flag = true;
			file.delete();
		}
		return flag;
	}
	
	/**
	 * Copies all files from a given source path to a given
	 * destination path.
	 * @param sourcePath
	 * 		The source path which contains the files to be copied.
	 * @param destinationPath
	 * 		The destination path where the files will be pasted.
	 */
	public static void copyFiles(String sourcePath, String destinationPath)
	{
		File source = new File(sourcePath);
		File destination = new File(destinationPath);
		List<File> files = (List<File>) FileUtils.listFiles(source, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for(File file : files)
		{
			try 
			{
				FileUtils.copyFileToDirectory(file, destination);
			} 
			catch (IOException e) 
			{
				logger.error("", e);
			}
		}
		
	}
}
