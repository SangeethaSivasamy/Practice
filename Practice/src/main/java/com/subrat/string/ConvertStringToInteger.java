/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 *
 */
public class ConvertStringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConvertStringToInteger convertStringToInteger = new ConvertStringToInteger();
		convertStringToInteger.convert("12345");
	}

	private void convert(String string) {
		if(string==null || string.length()==0){
			return;
		}
		int i=0;
		boolean isNegative = false;
		int sum=0;
		if(string.charAt(i)=='-'){
			isNegative = true;
			i=1;
		}
		
		while(i<string.length()){
			sum=sum*10+string.charAt(i)-'0';
			i++;
		}
		if(isNegative){
			sum=-sum;
		}
		
		System.out.println("Result is :"+sum);
		
	}

}
