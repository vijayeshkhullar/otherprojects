import java.util.Scanner;
import java.util.Random;
public class Hangman {
	
	//final int MAX_WRONG = 6; 
	static int numGames;
	static int numWins;
	static int numLosses;
	
	static void displayStats() {
		System.out.println("Number of Games: " + numGames);
		System.out.println("Number of Wins: " + numWins);
		System.out.println("Number of Losses: " + numLosses);
		return;
	}

	static boolean checkChar(char c, String str){
		for(int i = 0; i < str.length(); i++) {
			char ans = str.charAt(i);
			if(c == ans){
				return true;
			}
		}
		return false;
	}


	
	static String removeSpaces(String str){
        String word = "";
		for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                word += str.charAt(i);
            }          
        }
        return word;
    }

	
	static String getRandomWord (String[] array) {	
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(array.length);
		String ans = array[randomInt];
		return ans;
	}

	static String getRandomWord (String[] array, int len) {
		for(int i = 0; i < array.length; i++) {
			String ans = array[i];
			int length = ans.length();
			if(length == len) {
				return ans;
			}
		}
		return null;
	}

	static String getRevealedChars (String s1, String s2) {
		String word = "";
		for(int i = 0; i < s1.length(); i++) {
			if(checkChar(s1.charAt(i), s2  )){
				word += s1.charAt(i) + " ";
			}
			else {
				word += " _ ";
			}
		}

		return word;
	}

	static void displayHangMan(int numWrong){
		System.out.println();

		switch (numWrong)
		{
		case 0:
			break;
		case 1:
			System.out.print("    _______\n");
			break;
		case 2:
			System.out.print("    _______\n");
			for (int i = 0; i < 6; i++) 
				System.out.println("|        ||");
			break;
		case 3:
			System.out.println("    _______");
			for (int i = 0; i < 6; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 4:
			System.out.println("    _______");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");

			for (int i = 0; i < 4; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 5:
			System.out.print("    _______\n");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");
			System.out.println("|   |    ||");

			for (int i = 0; i < 3; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 6:
			System.out.print("    _______\n");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");
			System.out.println("|   |    ||");
			System.out.println("|  / \\   ||");

			for (int i = 0; i < 2; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		default:
			System.out.println("ERROR: EXCEEDED WRONG NUMBER OF GUESSES!");
		}

		System.out.println("\n");

	}

		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/*		
		//BOOLEAN CHECKCHAR
		char checkingOne = 'c';
		String checkingTwo = "ajkfhn";
		boolean check = checkChar(checkingOne, checkingTwo);
		System.out.println(check);

		//GET RANDOM WORD
		String word[] = {"Apple", "cheese", "Potato", "Celery", "Chips", "Ant"};
		String answer = getRandomWord(word);
		System.out.println(answer);

		//GET RANDOM WORD 2
		String answerTwo = getRandomWordTwo(word, 5);
		System.out.println(answerTwo);

		//GET REVEAL CHARS
		String secretWord = "tomato";
		String guess1 =  input.next();
		String answer4 = getRevealedChars(secretWord, guess1);
		System.out.println(answer4);


		 */		
		
		
		String words[] = {"logan", "hulk", "good", "starkiller", "cheesy", "shopping", "lampshade"};
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(words.length);
		String secretWord = words[randomInt];
		
		String guesses = "";
		 String answer = "";
		 int numWrong = 0;
		 final int MAX_WRONG = 6; 
		 
		 System.out.println("\n Welcome To My HangMan Game! \n" + getRevealedChars(secretWord, guesses) + "\n\n");
		 displayStats();

		 while(numWrong < MAX_WRONG) {

			 System.out.println("\nGuess A Character");
			 String str =  input.nextLine();
			 char str1 = str.charAt(0);
			 guesses += str1;
   
			 answer = getRevealedChars(secretWord, guesses);

			 boolean ans = checkChar(str.charAt(0), secretWord);
			 String ans1 = removeSpaces(answer);

			 if(ans == false){
				 System.out.println("Your Guess Was Incorrect");
				 System.out.println(answer);
				 numWrong++;
				 displayHangMan(numWrong);
			 }
			 else{
				 System.out.println(answer);
				 
				 if (ans1.equals(secretWord)) {
					 System.out.println("Congratulations, You Won! \n");
					 numGames += 1;
					 numWins += 1;
					 displayStats();
					 System.out.println("Want To Play Again? /n Please Type Yes or No");
					 Scanner input2 = new Scanner(System.in);
					 String playAgain = input2.next();
					 if (playAgain == "yes" || playAgain == "Yes") {
						 main(words);
						 return;
					 }
					 else if (playAgain == "no" || playAgain == "No") {
						 System.out.println("Play Again!");
						 return;
					 }
					 
					 
					 
					 
				 }
			 }
		 }
		 if (numWrong == MAX_WRONG) {
			 System.out.println("Sorry, You Lose :( \n The Word Was:" + secretWord + "\n");
			 numGames += 1;
			 numLosses += 1;
			 displayStats();
			 System.out.println("Want To Play Again? \n Please Type Yes or No");
			 Scanner input3 = new Scanner(System.in);
			 String playAgain = input3.next();
			 if (playAgain == "yes" || playAgain == "Yes") {
				 main(words);
				 return;
			 }
			 else if (playAgain == "no" || playAgain == "No") {
				 System.out.println("Play Again!");
				 return;
			 }

		 }

	}
}





