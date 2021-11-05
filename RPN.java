import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
	    File inputFile = new File("Calc1.stk");
	    Stack<String> simulator = new Stack<String>();
	    try{
		    Scanner sc = new Scanner(inputFile);
		    String[] operators = {"*", "+", "/", "-"};
		    while(sc.hasNext()){
		        String input = sc.next();
		        Boolean isOperator = false;
		        for(Integer i = 0 ; i < 4 ; i++){
		            String operador = operators[i];
		            if(input.equals(operador)){
		                isOperator = true;
		            }
		        }
		        if(isOperator){
		            Integer secondNumber = Integer.parseInt(simulator.peek());
	                simulator.pop();
	                Integer firstNumber = Integer.parseInt(simulator.peek());
	                simulator.pop();
	                Integer result = 0;
		            if(input.equals("*")){
		                result = (secondNumber * firstNumber);
		            }
		            else if(input.equals("+")){
		                result = (secondNumber + firstNumber);
		            }
		            else if(input.equals("-")){
		                result = (firstNumber - secondNumber);
		            }
		            else{ // "/" operator
		                result = (firstNumber / secondNumber);
		            }
		            simulator.push(Integer.toString(result));
		        }
		        else{ // Temos um número
		            simulator.push(input);
		        }
		    }
		    System.out.println(simulator.peek());
	    }
	    catch(FileNotFoundException e) {
	        System.out.println("Não foi possivel ler o arquivo");
	    }
	}
}