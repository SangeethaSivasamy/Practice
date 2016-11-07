/**
 * 
 */

/**
 * @author sparida
 *
 */
public class Test {

   public static void main(String args[]){
	   
	   
	   Boolean firstCondition = true || false;
	   Boolean secondCondition = true ;
	   Boolean thirdCondition = true && false;
	   Boolean fourthCondition = true && false;
	   Boolean fifthCondition = true && false;
	   
	   
      int x = 10;
      
      if(x==10 || x==11){
    	  if(fifthCondition){
    		  System.out.println("fifth condition");
    	  }else if(secondCondition){
    		  System.out.println("second condition");
    	  }else if(firstCondition){
    		  System.out.println("first condition");
    	  }else if (thirdCondition){
    		  System.out.println("third condition");
    	  }else if(fourthCondition){
    		  System.out.println("fourth condition");
    	  }
      }else{
    	  
    	  if(secondCondition){
    		  System.out.println("second condition");
    	  }else if (thirdCondition){
    		  System.out.println("third condition");
    	  }
    	  else if(fourthCondition){
    		  System.out.println("fourth condition");
    	  }
    	  else if(firstCondition){
    		  System.out.println("first condition");
    	  }
    	  else if(fifthCondition){
    		  System.out.println("fifth condition");
    	  }
    	  
      }
      

      
   }
}