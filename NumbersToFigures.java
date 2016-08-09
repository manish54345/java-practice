import java.util.*;

public class NumbersToFigures {

	static HashMap<String,String> numToFig;
	static HashMap<Integer,String> sizeToFig;
	public static void main(String[] args) {
		String input="";
		String output="";
		if (args.length == 0){
			System.out.println("Please input a number!!");
			System.exit(0);
		} else {
			input = args[0];
		}

		
		init();
		output = convertNumberToFigure(input);

		System.out.println("Output:" + output);
		

	}
	public static String convertNumberToFigure(String input) {
		String output="";
		ArrayList<String> groups = new ArrayList<String>();
		int number = parseString(input);
		
		if ( numToFig.containsKey(input) ) {
			output=numToFig.get(input);
			return output;
		} 
		int i=0;
		int index = input.length() % 3;
		if (index == 0) {
	    	index = 3;
	    }
		for(i=0; i<input.length();i+=index) {
		    if (i==1){
		    	index = 3;
		    }
			//System.out.println("i:: " + i);
			//System.out.println("index:: " + index);
		    String str = input.substring(i, index+i);
		    //System.out.println("String:: " + str);
		    groups.add(str);
			//output=getFigureForThreeNumbers(input);
		}
		
		for(String s: groups){
			//System.out.println("String:: " + s);
			if (s.length() == 1) {
				output += getFigureForSingleNumber(s);
			} else if (s.length() == 2) {
				output += getFigureForTwoNumbers(s);
			} else if (s.length() == 3) {
				output += getFigureForThreeNumbers(s);
			}
			if (groups.size() - groups.indexOf(s) == 4) {
				output += " Billion ";
			} else if (groups.size() - groups.indexOf(s) == 3) {
				output += " Million ";
			} else if (groups.size() - groups.indexOf(s) == 2) {
				output += " Thousand ";
			} 
		}
		return output;
	}
	public static String getFigureForThreeNumbers(String str) {
		String out=numToFig.get(str.substring(0, 1)) + " Hundred";
		out = out + " " +  getFigureForTwoNumbers(str.substring(1, 3));
		//System.out.println(str.substring(1, 3));
		//System.out.println(out);
		return out;
	}
	
	public static String getFigureForTwoNumbers(String str) {
		String out="";
		if (parseString(str.substring(0)) <= 20) {
			out = numToFig.get(str.substring(0));
		}else {
			out = numToFig.get(str.substring(0,1)+'0');
			if( str.charAt(1) != '0' ){
				out = out + " " +  numToFig.get(str.substring(1));
			}
		}
		return out;
	}
	
	public static String getFigureForSingleNumber(String str) {
		String out=numToFig.get(str.substring(0));
		return out;
	}
	
	public static int parseString(String str){
		int i= -1;
		try{
			i= Integer.parseInt(str);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			return i;
		}
	}
	public static void init() {
		numToFig = new HashMap<String,String>();
		numToFig.put("0", "Zero");
		numToFig.put("1", "One");
		numToFig.put("2", "Two");
		numToFig.put("3", "Three");
		numToFig.put("4", "Four");
		numToFig.put("5", "Five");
		numToFig.put("6", "Six");
		numToFig.put("7", "Seven");
		numToFig.put("8", "Eight");
		numToFig.put("9", "Nine");
		numToFig.put("10", "Ten");
		numToFig.put("11", "Eleven");
		numToFig.put("12", "Twelve");
		numToFig.put("13", "Thirteen");
		numToFig.put("14", "Fourteen");
		numToFig.put("15", "Fifteen");
		numToFig.put("16", "Sixteen");
		numToFig.put("17", "Seventeen");
		numToFig.put("18", "Eighteen");
		numToFig.put("19", "Ninteen");
		numToFig.put("20", "Twenty");
		numToFig.put("30", "Thirty");
		numToFig.put("40", "Forty");
		numToFig.put("50", "Fifty");
		numToFig.put("60", "Sixty");
		numToFig.put("70", "Seventy");
		numToFig.put("80", "Eighty");
		numToFig.put("90", "Ninty");
		numToFig.put("100", "Hundred");
		numToFig.put("1000", "Thousand");
		numToFig.put("1000000", "Million");
		
		sizeToFig = new HashMap<Integer,String>();
		sizeToFig.put(9, "Billion");
		sizeToFig.put(7, "Million");
		sizeToFig.put(4, "Thousand");
		sizeToFig.put(3, "Hundred");
	}
}
