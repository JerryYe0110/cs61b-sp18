/**
* OffByOne
*/
public class OffByOne implements CharacterComparator{
	 @Override
	 public boolean equalChars(char a, char b) {
		if (a-b==1 || b-a == 1) return true;
		return false;
	 }
}
