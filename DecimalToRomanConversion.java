import java.util.*;
public class DecimalToRomanConversion {

	static LinkedHashMap<Integer, String> map;
	static LinkedHashMap<String, Integer> romanToDecMap;
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
		int i = parseString(input);
		output = decimalToRoman(i);
		System.out.println(i + " - " + output);
		int i2 = romanToDecimal(output);
		System.out.println(output + " - " + i2);
	}
	
	public static String decimalToRoman(Integer i) {
		String out="";
		while(i > 0) {
			int flag = 0;
			for(int j: map.keySet()) {
				//System.out.println("mapkey="+ j);
				if (i >= j && flag==0) {
					out += map.get(j);
					//System.out.println("number="+i);
					//System.out.println("out="+out);
					i = i-j;

					flag = 1;
				}
			}
		}
		return out;
	}
	
	
	public static Integer romanToDecimal(String s) {
		Integer i = 0;
		String str="";
		while(s != null && s.length() > 0){
	
			int flag = 0;
			if (s.length() > 1) {
				str = s.substring(0,2);
				if (romanToDecMap.containsKey(str)) {
					 i = i + romanToDecMap.get(str);
					 s = s.substring(2);
					 flag=1;
				}
			}
			
			if (flag ==0 && s.length() >= 1) {
					str = s.substring(0,1);
					if (romanToDecMap.containsKey(str)) {
						i = i + romanToDecMap.get(str);
					} else {
						return 0;
					}
					s = s.substring(1);
					flag=1;
			}
			//System.out.println("s="+s + ", str=" + str + ", i=" + i );
		}
		return i;
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
	
	public  static  void init () {
		map = new LinkedHashMap<Integer, String>();
		romanToDecMap = new LinkedHashMap<String, Integer>();
		
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		
		
		for(Integer i: map.keySet()) {
			romanToDecMap.put(map.get(i), i);
		}
	}

}
