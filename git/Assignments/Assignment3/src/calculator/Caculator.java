package calculator;

import java.util.ArrayList;
import java.util.List;

public class Caculator {	

	public static void main(String[] args) {
		//Assume i and j are entered by user
		double i =3.2; double j = 3.6;
		
		System.out.format(i + " + " +  j + " = %.2f%n", Caculator.Add(i, j));
		System.out.format(i + " - " +  j + " = %.2f%n", Caculator.Subtract(i, j));
		System.out.format(i + " * " +  j + " = %.2f%n", Caculator.Multiply(i, j));
		System.out.format(i + " / " +  j + " = %.2f%n", Caculator.Divide(i, j));
		System.out.format("The square root of " + i +" is %.2f%n", Caculator.squareRoot(i));
		System.out.format("The square of " + i + " is %.2f%n", Caculator.square(i));
		System.out.format("The cube of " + i + " is %.2f%n", Caculator.cube(i));
		System.out.format(i +"F is equal to %.2fC%n",Caculator.convertFromFahrenheitToCelcius(i));
		System.out.format(i +" feet is equal to %.2f inches%n", Caculator.convertFromFeetToInches(i));
		 
		//Coefficients for the quadratic equation used by user
		double a =1; double b= 2; double c=1;
		List<Double> solution = solveQuadraticEquation(a, b, c);
		System.out.print("The quadratic equation "+a+"X^2 + "+b+"X + "+c+" = 0 has ");
		if(solution.isEmpty()){			
			System.out.println("NO solution");
		}
			
		else if(solution.size() ==2) {
			System.out.println("2 solutions");
			System.out.format("X1 = %.2f%n", solution.get(0));
			System.out.format("X2 = %.2f%n", solution.get(1));
		}
		else {
			System.out.println("1 solution");
			System.out.format("X1 = %.2f%n", solution.get(0));
		}
	}
	
	Caculator() {		
	}
	
	private static boolean isANumber(double i) {
		return Double.isNaN(i);
	}
	
	public static double Add(double i, double j) {
		if(isANumber(i) || isANumber(j)) throw new IllegalArgumentException("Either "+ i +" or "+ j +" is not a number");
		return i + j;
	}
	
	public static double Subtract(double i, double j) {
		if(isANumber(i) || isANumber(j)) throw new IllegalArgumentException("Either "+ i +" or "+ j +" is not a number");
		return i - j;
	}
	
	public static double Multiply(double i, double j) {
		if(isANumber(i) || isANumber(j)) throw new IllegalArgumentException("Either "+ i +" or "+ j +" is not a number");
		return i*j;
	}
	
	public static double Divide (double i, double j){
		if(isANumber(i) || isANumber(j)) throw new IllegalArgumentException("Either "+ i +" or "+ j +" is not a number");
		if(j ==0) throw new IllegalArgumentException("divisor can not be zero");
		return i/j;
	}
	
	public static double squareRoot(double i){
		if(isANumber(i)) throw new IllegalArgumentException(i +" is not a number");
		return Math.sqrt(i); 
	}
	
	public static double square(double i) {
		if(isANumber(i)) throw new IllegalArgumentException(i +" is not a number");
		return i*i;		
	}
	
	public static double cube(double i) {
		if(isANumber(i)) throw new IllegalArgumentException(i +" is not a number");
		return i*i*i;
	}
	
	public static double convertFromFahrenheitToCelcius(double i){
		if(isANumber(i)) throw new IllegalArgumentException(i +" is not a number");
		return (i-32)*5/9;					
	}
	
	public static double convertFromFeetToInches(double i) {
		if(isANumber(i)) throw new IllegalArgumentException(i +" is not a number");
		return i*12;
	}
	
	public static List<Double> solveQuadraticEquation(double A, double B, double C) {
		if(isANumber(A) || isANumber(B) || isANumber(C)) 
			throw new IllegalArgumentException("Either "+ A +" or "+ B +" or " + C+ " is not a number");
		
		double delta = square(B) - Multiply(4, Multiply(A, C));
		double firstSolution=0.0; double secondSolution=0.0;
		
		ArrayList<Double> solution = new ArrayList<Double>();
		if(delta > 0) {
			firstSolution = Divide((-B + squareRoot(delta)), Multiply(2, A));
			secondSolution = Divide((-B - squareRoot(delta)), Multiply(2, A));
			solution.add(firstSolution);
			solution.add(secondSolution);
		}
		else if(delta == 0) {
			firstSolution = Divide(-B, Multiply(2, A));
			solution.add(firstSolution);
		}
		
		return solution;
	}
} 
