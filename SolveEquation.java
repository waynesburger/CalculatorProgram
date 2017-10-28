import java.util.Stack;
import java.util.ArrayList;
import java.lang.Math;
import java.util.EmptyStackException;

public class SolveEquation{
   
   public static double returnAnswer(ArrayList<Object> results){
   
      Stack<Double> stak = new Stack<Double>();
      Object element;
      Double first, second;
      int conversion1;
      double conversion2;
      
      //each member of the results is processed in order
      for(int a=0; a<results.size(); a++){
         //get the next element in results
         element = results.get(a);
         
         //push into stak if it's a number
         //some conversions needed to be done in order 
              //for the number to be accepted into stak
         if(element instanceof Number){
            //conversion1 = (int)element;
            //conversion2 = (double)conversion1;
            stak.push((Double)element);
         }
         //if it's an operator
         //pop the top two number from stak and perform the appropriate opperation
         else{
            if(stak.empty()){
               throw new EmptyStackException();
            }
              second = stak.pop();
              first = stak.pop();
            
              if(element.equals("+")){
                 stak.push(first+second);
              }else if(element.equals("-")){
                 stak.push(first-second);
              }else if(element.equals("x") || element.equals("*")){
                 stak.push(first*second);
              }else if(element.equals("/")){
                 stak.push(first/second);
              }else if(element.equals("^")){
                 stak.push(Math.pow(first, second));
              }
            
         }
      }
      
      //in the end, stak should contain one number
      //pop it from the stack and return it
      double answer = stak.pop();
      return answer;
   }
   
}