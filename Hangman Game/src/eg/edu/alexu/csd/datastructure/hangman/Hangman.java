package eg.edu.alexu.csd.datastructure.hangman;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hangman implements IHangman {
	
	@Override
	public void setDictionary(String[] words) {
		Readfromfile(words);
	}

	@Override
	public String selectRandomSecretWord() {
		int r =(int)(Math.random()*41239);
		return game.words[r];
	}

	@Override
	public String guess(Character c) throws Exception {
		int temp;
		String tempWord;
		temp = game.secWord.indexOf(c);
		if (temp==-1) {
			Hangman h=new Hangman();
			h.setMaxWrongGuesses(game.max);
		}
		if (game.max <= 0) {
			return null;
		}
		while (temp!=-1) {
			game.initialword[temp]=c;
			temp = game.secWord.indexOf(c,temp+1);
		}
		tempWord=new String(game.initialword).substring(0,game.secWord.length());
		return tempWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		game.max--;
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
