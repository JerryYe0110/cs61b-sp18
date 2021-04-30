/**
* Palindrome
*/
public class Palindrome {

	public Deque<Character> wordToDeque(String word) {
		LinkedListDeque<Character> listForword = new LinkedListDeque<>();
		for (int i = 0; i < word.length(); i++) {
			listForword.addLast(word.charAt(i));
		}
		return listForword;
	}

	public boolean isPalindrome(String word) {
	  for (int i = 0; i < word.length()/2; i++) {
//	 if(word.charAt(i))
	  	if (word.charAt(i)!=word.charAt(word.length()-i-1)) {
	  		return false;
	  	}
	  }
		return true;
	}

	public boolean isPalindrome(String word, CharacterComparator cc) {
	  for (int i = 0; i < word.length()/2; i++) {
	  	if (!cc.equalChars(word.charAt(i),word.charAt(word.length()-i-1))) {
	  		return false;
	  	}
	  }
		return true;
	}
}
