package com.cpseeker.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.cpseeker.vectorgen.Vector;
import com.cpseeker.vectorgen.VectorSet;

public class HTMLBuilder 
{
	private static int number_ = 1;
	public static void buildIndex(String[] info, String[] files, String path) throws IOException
	{
		number_ = 1;
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head><title>CPSeeker's index</title>");
		builder.append("<link rel = \"stylesheet\" href = \"table.css\">");
		builder.append("<table class = \"bordered\" >");
		builder.append("<tr><th colspan= \"2\" >Information</th></tr>");
		builder.append("<tr>"); 
		builder.append("<th>Name</th>");
		builder.append("<th>Value</th>");
		builder.append("</tr>");
		for(String i : info)
		{
			String[] members = i.split(":");
			builder.append("<tr>"); 
			builder.append("<td>");
			builder.append(members[0]);
			builder.append("</td>");
			builder.append("<td>");
			builder.append(members[1]);
			builder.append("</td>");
			builder.append("</tr>");
		}
		builder.append("</table>");
		builder.append("<br/><br/>");
		builder.append("<table class = \"bordered\" >");
		builder.append("<tr>");
		builder.append("<th>#</th>");
		builder.append("<th>File</th>");
		builder.append("<th>Clones</th>");
		builder.append("</tr>");
		for(String s : files)
		{
			builder.append("<tr>");
			//serial number
			builder.append("<td>" + number_ + "</td>");
			//file's name
			builder.append("<td>" + s + "</td>");
			//file's clone set hyper-link
			builder.append("<td>");
			builder.append("<a href=\"" + number_ + "." + s + ".html\">");
			builder.append("Clone set");
			builder.append("</a></td></tr>");
			number_++;
		}
		builder.append("</table>");
		builder.append("</html>");
		String html = builder.toString();
		File file = new File(path + "\\index.html");
		FileUtils.write(file,html);
	}
	public static void buildHTML(String fileName, List<VectorSet> codeClones, String path) throws IOException
	{
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head><title>" + fileName + " clone report</title>");
		builder.append("<link rel = \"stylesheet\" href = \"default.min.css\">");
		builder.append("<link rel = \"stylesheet\" href = \"table.css\">");
		builder.append("<script src = \"highlight.min.js\"></script>");
		builder.append("<script>window.onload = function() {var aCodes = document.getElementsByTagName('pre');");
		builder.append("for (var i=0; i < aCodes.length; i++) {hljs.highlightBlock(aCodes[i]);}};</script>");
		builder.append("</head>");
		builder.append("<body>");
		builder.append("<p>");
		for(VectorSet set : codeClones)
		{
			builder.append("<div class = \"datagrid\">");
			builder.append("<table>");
			builder.append(buildCloneSet(set));
			builder.append("</table>");
			builder.append("</div>");
			builder.append("<br/>");
		}
		builder.append("</p>");
		builder.append("</body>");
		builder.append("</html>");
		String html = builder.toString();
		File file = new File(path + "\\" + number_ + "." + fileName + ".html");
		FileUtils.write(file,html);
		number_++;
	}
	private static String buildCloneSet(VectorSet cloneSet) throws IOException
	{
		StringBuilder builder = new StringBuilder();
		int i = 1;
		Set<Vector> vectors = cloneSet.getVectorSet();
		for(Vector vector : vectors)
		{
			builder.append("<tr><td>");
			builder.append("Clone " + i +":");
			builder.append("</td></tr>");
			builder.append(buildReference(vector));
			builder.append(buildSourceCode(vector));
			i++;
		}
		return builder.toString();
	}
	private static String buildReference(Vector vector)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("<tr><td>");
		builder.append("<a href=\"file://");
		builder.append(vector.getCodeFragment().getSourceFile().getFileAbsolutePath());
		builder.append("\">");
		builder.append(vector.getCodeFragment());
		builder.append("</a>");
		builder.append("</td></tr>");
		return builder.toString();	
	}
	private static String buildSourceCode(Vector vector) throws IOException
	{
		StringBuilder builder = new StringBuilder();
		builder.append("<tr><td>");
		builder.append("<pre class = \"java\">");
		builder.append(FileUtilities.readFileRange(
				new File(vector.getCodeFragment().getSourceFile().getFileAbsolutePath()),
				vector.getCodeFragment().getStartLine(),
				vector.getCodeFragment().getEndLine()));
		builder.append("</pre>");
		builder.append("</td></tr>");
		return builder.toString();
	}
}
