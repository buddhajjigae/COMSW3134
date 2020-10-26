/* this is to test whether the program ignores imbalances in the comment blocks */
public class Test3 {
	public static void main(String[] args) {
		boolean haveYouWatchedHamiltonYet = true;
		int theSchuylerSisters = 3; 
		int alexanderhamilton = 1;
		int aaronburr = 1;

		boolean amIintheroom = theRoomWhereItHappens();


		/* this is a commented block. We're testing if your code 
		can deal with unbalanced things in the comments: /*
		that was the test for here */
	}

	/*just a general comment */ 
	/* this one has some  errors /* { [  { [ } ] */   


	public boolean theRoomWhereItHappens() {
		boolean intheRoomWhereItHappens = false;
		boolean isHappyAboutThis = false;
		return intheRoomWhereItHappens && isHappyAboutThis;

	}
}