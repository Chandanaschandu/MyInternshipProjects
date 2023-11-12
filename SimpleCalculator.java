import java.util.Scanner;

public class SimpleCalculator{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double num1,num2;
        System.out.println("Simple Calculator");
        System.out.println("Enter first number");
        num1=input.nextDouble();
        System.out.println("Enter second number");
        num2=input.nextDouble();
        char operator;
        double result;
        System.out.println("Enter operator");
        operator=input.next().charAt(0);
        switch (operator){
            case '+':
                result=num1+num2;
                System.out.println("Addition of two numbers is"+"="+result);
                break;
            case '-':
                
                result=num1-num2;
                System.out.println("The subtraction of two numbers is"+"="+result);
                break;
            case '*':
                result=num1*num2;
                System.out.println("The Multiplication of two numbers is"+"="+result);
                break;
            case '/':
                if (num2!=0){
                    result=num1/num2;
                    System.out.println("The division of two numbers is"+"="+result);
                    break;
               }
            default:
                
                System.out.println("Invalid operator");
        }
    }
}
