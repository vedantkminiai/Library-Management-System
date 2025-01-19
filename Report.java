import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalTime;

public class Report {

    //finds the most popoular genre for the user logged-in
	public static String findPopularGenre(int dramaCount, int mysteryCount, int thrillerCount, int romanceCount, int sciCount) {
		String[] genres = {"Drama", "Mystery", "Thriller", "Romance", "Science Fiction"};
		int[] counts = {dramaCount, mysteryCount, thrillerCount, romanceCount, sciCount};
		int maxCount = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > maxCount) {
				maxCount = counts[i];
			}
		}
		ArrayList<String> mostPopularGenres = new ArrayList<>();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == maxCount) {
				mostPopularGenres.add(genres[i]);
			}
		}

		return "Most Popular Genre(s): " + String.join(", ", mostPopularGenres) + " with " + maxCount + " borrow(s).";
	}
	
	 //finds the average books the user borrows. Takes in input as member from MyClass
	 public static void userAverageBooks(Member currentUser) {
        if (currentUser == null) {
            System.out.println("No member is currently logged in.");
            return;
        }
        int totalBorrowedBooks = currentUser.getUserHistory().size();
        System.out.println("\n\tREPORT SUMMARY\n----------------------------");
        System.out.println("Member Name: " + currentUser.getMemberName());
        System.out.println("Member ID: " + currentUser.getMemberID());
        System.out.println("Total Books Borrowed: " + totalBorrowedBooks + " (all time)");
        System.out.printf("Average Books Borrowed: %.2f (per session)%n", ((double) totalBorrowedBooks/MyClass.sessionCount));
    }
    

}
