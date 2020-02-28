
package eg.edu.alexu.csd.datastructure.hangman;

import java.io.BufferedReader;
import java.io.FileReader;

public class game implements IHangman {
	
	@Override
	public void setDictionary(String[] words) {
		Readfromfile(words);
	}

	@Override
	public String selectRandomSecretWord() {
		int r =(int)(Math.random()*41239);
		return Hangman.words[r];
	}

	@Override
	public String guess(Character c) throws Exception {
		int temp;
		String tempWord;
		temp = Hangman.secWord.indexOf(c);
		if (temp==-1) {
			game h=new game();
			h.setMaxWrongGuesses(Hangman.max);
		}
		if (Hangman.max <= 0) {
			return null;
		}
		while (temp!=-1) {
			Hangman.initialword[temp]=c;
			temp = Hangman.secWord.indexOf(c,temp+1);
		}
		tempWord=new String(Hangman.initialword).substring(0,Hangman.secWord.length());
		return tempWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		Hangman.max--;
	}
	
	public static void Readfromfile(String a[]) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("dictionary.txt") );
			for (int i=0;i<41239 ;i++) {
				a[i]=f.readLine();
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
