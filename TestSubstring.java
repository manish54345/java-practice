import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "123456789";
		System.out.println(str.length());
		
		System.out.println(str.substring(3,4));
		
		
		String s2 = "110010100000000_2";
		int indx = 0;
		int gap=0;
		while(s2.length() > 0){
			indx = getIndexOfOne(s2);
			System.out.println("String: " + s2+ ", length: "+indx);
			s2=s2.substring(indx+1);
			if (gap<indx){
				gap = indx;
			}
		}
		System.out.println("Maxgap: " +gap);
	}
	
	public static int getIndexOfOne(String s) {
		int i = 0;
		Pattern p = Pattern.compile("1");
		Matcher m = p.matcher(s);
		if (m.find()) {
			i=m.start();
		}
		return i;
	}
	

}
