/**
 * 
 */
package com.subrat.javaEight;

import java.io.File;
import java.io.FileFilter;

/**
 * @author sparida
 *
 */
public class FirstLambdaExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};*/
		
		FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");
		
		File directory = new File("/Users/sparida/git/Personal/Practice/Practice/src/main/java/com/subrat/array");
		File[] javaFiles = directory.listFiles();
		for (File file : javaFiles) {
			System.out.println(file);
		}

	}

}
