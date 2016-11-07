import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class Solution {
	
	static int IKatoi(String strInput) {
        int sum = 0;
        char[] array = strInput.toCharArray();
    if(strInput !=null && strInput.length()>0){
        for(char ch : array){
            sum = sum + (int)ch;
        }
    }
        return sum;

    }





	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _strInput;
        try {
            _strInput = in.nextLine();
        } catch (Exception e) {
            _strInput = null;
        }
        
        res = IKatoi(_strInput);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
}