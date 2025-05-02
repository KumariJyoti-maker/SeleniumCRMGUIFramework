package practicedatadriventestin;

public class Generatealphanum {

	public static void main(String[] args) {
		int n=30;
		//choose a character random from this string
		String alphanum="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		//create string buffer size ofalphanum
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<=n;i++) {
			//generate randomnumber btwn 0 to alphanum variable length
			int index=(int)(alphanum.length()*Math.random());
			//add character one one by onein end of sb
			sb.append(alphanum.charAt(index));
		}
		System.out.println(sb);

		
	}

}
