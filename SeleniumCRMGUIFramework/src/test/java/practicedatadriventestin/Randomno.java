package practicedatadriventestin;

import java.util.Random;

public class Randomno {

	public static void main(String[] args) {
		Random ran=new Random();
		int ranno=ran.nextInt(20000);
		System.out.println(ranno);

	}

}
