package tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class UsingTestWord {
	/*
	 * create a vector of all unique test words that are in both input files
	 * in the implementation please use HashSet<TestWord> 
	 *  for testing please use the files: text1.txt and text2.txt
	 */
	public static Vector<TestWord> inBothFiles(String fn1, String fn2) throws IOException {
	
		HashSet<TestWord>  words1 = new HashSet<>(fromFile(fn1));
		HashSet<TestWord>  words2 = new HashSet<>(fromFile(fn2));
		words1.retainAll(words2);
		return new Vector<>(words1);
	}


	/*
	 *  Create a vector of all words from the content of data in file fn 
	 */
	public static Vector<TestWord> fromFile(String fn) throws IOException {
		Vector<TestWord> vector = new Vector<>();
		Scanner scanner = new Scanner(new File(fn));
		while(scanner.hasNextLine()) {
			try {
				vector.add(new TestWord(scanner.next()));
			} catch(Exception ex) {
				
			}
		}
		
		scanner.close();
		
		return vector;
	}


	/*
	 *  Print out  the input vector
	 *  using natural order of TestWord class (alphabetical, case insensitive)
	 *  preserve the original ordering of input vector indata
	 */
	public static void naturalSortOrder(Vector<TestWord> indata) {
		Vector<TestWord> sorted = new Vector<>(indata);
		Collections.sort(sorted);
		for (TestWord testWord : sorted) {
			System.out.println(testWord);
		}
		
	}
	/*
	 *  Print the input vector
	 *  in the length order of words starting with the longest
	 *  preserve the original ordering of input vector 
	 */
	public static void lengthOrder(Vector<TestWord> indata) {
		Vector<TestWord> sorted = new Vector<>(indata);
		Collections.sort(sorted, new Comparator<TestWord>() {
			public int compare(TestWord o1, TestWord o2) {
				return o2.getWord().length() - o1.getWord().length();
			}
		});
		
		for (TestWord testWord : sorted) {
			System.out.println(testWord);
		}
	}
	
	// use text1.txt and text2.txt files
	
	public static void main(String[] args) throws Exception {
		Vector<TestWord> common = inBothFiles("text1.txt", "text2.txt");
		System.out.println("Common Words: ");
		for (TestWord testWord : common) {
			System.out.println(testWord);
		}
		
		
		Vector<TestWord> words1 = fromFile("text1.txt");
		System.out.println("**** Natural Sort");
		naturalSortOrder(words1);
		
		System.out.println("**** Length Sort");
		lengthOrder(words1);
		
	}

}
