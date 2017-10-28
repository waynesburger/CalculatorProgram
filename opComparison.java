import java.util.Comparator;

public class opComparison implements Comparator<String>{

   public int compare(String operator1, String operator2){
      int op1, op2;
      
      switch(operator1){
         case "^": op1 = 3; break;
         case "*": op1 = 2; break;
         case "/": op1 = 2; break;
         case "+": op1 = 1; break;
         case "-": op1 = 1; break;
         default: op1 = 0; break;
      }
      
      switch(operator2){
         case "^": op2 = 3; break;
         case "*": op2 = 2; break;
         case "/": op2 = 2; break;
         case "+": op2 = 1; break;
         case "-": op2 = 1; break;
         default: op2 = 0; break;
      }
      
      return op1 - op2; 
   }
}