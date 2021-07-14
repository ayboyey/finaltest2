package tests;

/*
	Complete the class TestWord
	natural sort: alphabetical, case insensitive

*/

public class TestWord implements Comparable<TestWord> {
	private String word;

	// TestWord(String w)  constructor
	// one letter words are not allowed do not create such objects!
	public TestWord(String w) throws Exception {
		if(w.length() <= 1)
			throw new Exception("Cannot create one letter words");
		
		word = w;
	}

	
	public String getWord() {
		return word;
	}
	
	@Override
	public int compareTo(TestWord other) {
		return this.word.compareToIgnoreCase(other.word);
	}
	
	@Override
	public int hashCode() {
		return word.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TestWord) {
			TestWord m = (TestWord) o;
			return word.equalsIgnoreCase(m.word);
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return word;
	}
}