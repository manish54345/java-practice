import java.util.*;


public class NumsToWords {

	static HashMap<String,String> words = new HashMap<String,String>();
	static HashMap<Integer,String> scale = new HashMap<Integer,String>(); 
	static {
		words.put("1", "One");
		words.put("2", "Two");
		words.put("3", "Three");
		words.put("4", "Four");
		words.put("5", "Five");
		words.put("6", "Six");
		words.put("7", "Seven");
		words.put("8", "Eight");
		words.put("9", "Nine");
		words.put("10", "Ten");
		words.put("11", "Eleven");
		words.put("12", "Twelve");
		words.put("13", "Thirteen");
		words.put("14", "Fourteen");
		words.put("15", "Fifteen");
		words.put("16", "Sixteen");
		words.put("17", "Seventeen");
		words.put("18", "Eighteen");
		words.put("19", "Nineteen");
		words.put("20", "Twenty");
		words.put("30", "Thirty");
		words.put("40", "Fouty");
		words.put("50", "Fifty");
		words.put("60", "Sixty");
		words.put("70", "Seventy");
		words.put("80", "Eighty");
		words.put("90", "Ninety");
		
		scale.put(5, "Trillion");
		scale.put(4, "Billion");
		scale.put(3, "Million");
		scale.put(2, "Thousand");
		scale.put(1, "Dollars");
	}
	static List<String> convert3digitToString (String s, int scl) {
		List<String> str = new ArrayList<String>(); 
		
		// padd zeros to String to make size = 3
		if (s.length() == 1) {
			s = "00" + s;
		}
		if (s.length() == 2) {
			s = "0" + s;
		}
		
		String hun = s.substring(0,1);
		//System.out.println(hun);
		String tens = s.substring(1,2) + "0";
		//System.out.println(tens);
		String unit = s.substring(2,3);
		//System.out.println(unit);
		String tens_unit = s.substring(1,3);
		//System.out.println(tens_unit);
		
		// Hundred's position
		if (words.get(hun) != null) {
			str.add(words.get(hun));
			str.add("Hundred");
		}
		
		if (words.get(tens_unit) != null ) {
			str.add(words.get(tens_unit));
			str.add(scale.get(scl));
			return str;
		}
		
		str.add(words.get(tens));
		str.add(words.get(unit));
		str.add(scale.get(scl));
		return str;
	}
	
	public static List<String> convertDigitsToString (String input) {
		List<String> list = new ArrayList<String>();
		List<String> figs = new ArrayList<String>();
		int size = input.length();
		int i=0;
		int offset;
		while (i < size) {	
			offset = (i==0 && size % 3 > 0)?size%3:3;
			//System.out.print("i="+i);
			//System.out.print(", offset="+offset);
			//System.out.println(", string="+input.substring(i, i+offset));
			list.add( input.substring(i, i+offset) ); 
			i += offset;
		}
		//System.out.println(list);
		int j = 0;
		for (String s : list) {
			//System.out.println("str="+s);
			figs.addAll(convert3digitToString(s, list.size()-j++));
		}
		return figs;
	}
	static void printList(List<String> words ){
		String str="";
		for (String s: words) {
			str += s + " ";
		}
		System.out.print(str);
	}
	
	
	public static void main(String[] args) {
		String input="";
		if (args.length == 0){
			System.out.println("Please input a number!!");
			System.exit(0);
		} else {
			input = args[0];
		}
		System.out.println(input);
		List<String> figs = new ArrayList<String>();
		figs = convertDigitsToString(input);
		printList(figs);
		
	}

}
