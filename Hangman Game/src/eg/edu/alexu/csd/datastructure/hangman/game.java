package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class game {
	public static char[] initialword = new char [20];
	public static String[] words=new String[41239];
	public static int max;
	public static String secWord,finalWord;
	public static void main (String []args) {
		char c;
		char check = 'y';
		Scanner s=new Scanner(System.in);
		Hangman h = new Hangman();
		h.setDictionary(words);
		
		while (check=='y') {
			max= 10;
			for (int i=0;i<20;i++)initialword[i]='-';
			for (int i=0;i<20;i++)System.out.println();
			
			secWord = h.selectRandomSecretWord();
			//System.out.println(secWord);
			while (true) { 
				System.out.println("please enter the character that might be in the word :");
				c=s.next().charAt(0);
				for (int i=0;i<50;i++)System.out.println();
				try {
					finalWord=h.guess(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(finalWord +"\t\t"+max+" Attempts Left");
				if (finalWord==null) {
					System.out.println("\n\nGame Over \nthe secret word was : "+ secWord +"\nYou lose the game !!!!!!!Try again to win\n");break;
				}
				else if (finalWord.equals(secWord)){
					System.out.println("\nWow !!!!!! you won the game");break;
				}
			}
			System.out.println("Are you want to play again ? [y,n]");
			check=s.next().charAt(0);
		}
		s.close();
	}
}
