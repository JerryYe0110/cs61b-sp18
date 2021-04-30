/**
* OffByOne
*/
public class OffByOne implements CharacterComparator{
	 @Override
	 public boolean equalChars(char a, char b) {
		if (Math.abs(Character.toLowerCase(a)-Character.toLowerCase(b))==1) return true;
		return false;
	 }
}
