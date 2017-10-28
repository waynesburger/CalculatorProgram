import java.util.Stack;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Conversion{

   public static ArrayList<Object> toPostfix(String inString){
   
      Stack<String> stck = new Stack<String>();
      ArrayList<Object> results = new ArrayList<Object>();
      StringTokenizer equation = new StringTokenizer(inString, "+-*x/%^()", true);
      String elem;
      opComparison op = new opComparison();
      
      while(equation.hasMoreElements()){
         elem = equation.nextToken();
         
         if(thisIsANumber(elem)){
            //turn elem to a Double and insert into results
            results.add(Double.parseDouble(elem));
         }else if(elem.equals("(")){
            //push elem into stck
            stck.push(elem);
         }else if(elem.equals(")")){
            //pop everything from stck and add it to results until
            //an opening parenthesis is reached
            String popped;
            while(true){
               popped = stck.pop();
               if(popped.equals("("))break;
               else results.add(popped);
            }
         }else if(elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/") || elem.equals("^")){
            //If the character is an operator, pop operators 
            //until you reach an opening parenthesis, an operator 
            //of lower precedence, or a right associative symbol of equal 
            //precedence. Push the operator onto the stack.
            
            if(!stck.empty()){
               //stck.peek() lower presidence than elem: return positive number
               //stck.peek() higher presidence than elem: return negative number
               //stck.peek() same presidence as elem: return 0
               while(!stck.peek().equals("(") || op.compare(elem, stck.peek()) < 0){
                 results.add(stck.pop());
               }
            }
            
            stck.push(elem);
             
         }
         
      }
      
      while(!stck.empty()){
         results.add(stck.pop());
      }
      
      return results; 
      
   }
   
   public static boolean thisIsANumber(String elem){
      //determine if the string token is a number
      //return true or false
      if(elem == null) return false;
      
      int length = elem.length();
      if(length == 0) return false;
      
      if(elem.charAt(0) == '-'){
         if(length == 1) return false;
      }
      
      char c;
      for(int x=0; x < length; x++){
         c = elem.charAt(x);
         if(c < '0' || c > '9'){
            return false;
         }
      }
      return true;
   }
   
}