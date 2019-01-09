import com.zubiri.hangman.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		// add default surnames
		String[] possibleWords = new String[7];
		possibleWords[0] = "lazkano";
		possibleWords[1] = "intxausti";
		possibleWords[2] = "artola";
		possibleWords[3] = "alberdi";
		possibleWords[4] = "lekubide";
		possibleWords[5] = "ortiz";
		possibleWords[6] = "gonzalez";
		Word word = new Word(possibleWords[(int) (Math.random() * 7)]);
		// print the word using underscores
		for (int i = 0; i < word.getWord().length(); i++)
			System.out.print("_ ");
		boolean playAgain = true;
		while (playAgain == true) {
			System.out.println("Good luck, start with the first letter.");
			int flag = 0;
			while (flag < 3) {
				String letter = sc.next();
				sc.nextLine();
				if (word.letterMatch(letter)) {
					ArrayList<Integer> matchPositions = word.matchPositions(letter);
					int counter = 0;
					for (int i = 0; i < matchPositions.size(); i++) {
							System.out.println("The position of " + letter + " is " + i);
						}
					}
				}else {
					System.out.println("There's no "+letter+" in this word");
				}
				flag++;
			}
		}
	}
}
