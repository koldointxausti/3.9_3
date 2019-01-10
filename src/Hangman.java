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
		boolean playAgain = true;
		while (playAgain == true) {
			Word word = new Word(possibleWords[(int) (Math.random() * 7)]);
			// print the word using underscores
			for (int i = 0; i < word.getWord().length(); i++)
				System.out.print("_ ");
			char[] guessed = new char[3];
			System.out.println("Good luck, start with the first letter.");
			int flag = 0;
			while (flag < 3) {
				String letter = sc.next().trim().toLowerCase();
				sc.nextLine();
				if (word.letterMatch(letter)) {
					ArrayList<Integer> matchPositions = word.matchPositions(letter);
					for (int i = 0; i < matchPositions.size(); i++) {
						guessed[flag] = word.getWord().charAt(matchPositions.get(i));
					}
				} else
					System.out.println("there's no " + letter);

				for (int i = 0; i < word.getWord().length(); i++) {
					boolean found = false;
					for (int j = 0; j < guessed.length; j++) {
						if (guessed[j] == word.getWord().charAt(i)) {
							System.out.print(word.getWord().charAt(i) + " ");
							found = true;
						}
					}
					if (!found) {
						System.out.print("_ ");
					}
				}
				flag++;
			}
			System.out.println("It's time, you gotta try to guess to whole word");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String playerWord = sc.next();
				sc.nextLine();
				// check the user has entered just one word
				String[] playerWordArray = playerWord.split(" ");
				if (playerWordArray.length == 1) {
					// check if the word the user enters has a number
					boolean hasNumber = false;
					for (int i = 0; i < playerWordArray[0].length(); i++) { // taking each letter
						for (int j = 0; j < 9; j++) { // comparing with numbers
							// if this letter is equal to any number
							if (playerWordArray[0].charAt(i) == (char) j) {
								hasNumber = true;
								break;
							}
						}
					}
					if (hasNumber == false) {
						wordEntered = true; // to go out of the loop
						if (playerWordArray[0].compareTo(word.getWord()) == 0)
							System.out.println("Congrats, you won the game");
						else
							System.out.println("Sorry, you lost. The surname was " + word.getWord());
					} else
						System.out.println("Please, enter a real number (no numbers)");
				} else
					System.out.println("Please enter just one word");
			}
			System.out.println("Would you like to play again? (y/n)");
			boolean askAgain = true;
			while (askAgain) {
				String answer = sc.next().toLowerCase();
				sc.nextLine();
				switch (answer) {
				case "y":
					askAgain = false; // get out of this loop but no out of the biggest loop (playAgain)
					break;
				case "n":
					askAgain = false; // get out of this loop
					playAgain = false; // get out of the biggest loop (playAgain)
					break;
				default:
					System.out.println("Please, select a posible answer ('y' for yes/ 'n' for no)");
					break;
				}
			}
		}
	}
}
