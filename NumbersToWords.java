import java.util.Scanner;

// This code is meant to convert integers to numbers


public class NumbersToWords{

//This array stores numbers one to nineteen
public static String[] numToNineteen={
	"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen",
	"sixteen","seventeen","eighteen","nineteen",
};

//This array stores numbers in tens twenty to ninety
public static String[] tens={"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};

//boolean here will be used in the conversion function
public static boolean isWithin(int i, int lower, int upper){
	return (lower<=i)&&(upper>=i);
}

//this function takes care of numbers greater than 99
public static String otherNums(int num2, int qualifier, String title){
	int convQualif=num2/qualifier;
	int convRest=num2%qualifier;

	if (convRest>0) {
		return conversion(convQualif)+" "+title+" "+conversion(convRest);
	}
	else 
		return conversion(convQualif)+" "+title;
}

//The below takes care of the conversion from integers to words
public static String conversion(int num){
	if (num<0) {
		return "Negative "+ conversion(-1*num);
		//returns negative then converts num to a +ve number and returns it to conversion function. this is for negative numbers
	}

	else if (isWithin(num,0,19)) {
		return numToNineteen[num];
		//if num is within 0 and 19 it calls the array numToNineteen

	}
	else if (num>=20&&num<=90&&num%10==0) {
		return tens[num/10-2];
		//this picks the tens only reason why add modulo 0

	}
	else if (isWithin(num,20,99)) {
		int convTens=num/10*10;
		int convRem=num%10;

		return conversion(convTens)+"-"+conversion(convRem);
		//this statement gets numbers between 20 & 99 and converts them

	}
	else if (isWithin(num,100,999)) {
		return otherNums(num,100,"hundred");
		//this statement gets numbers between 100 & 999 and converts them with reference to otherNums function

	}
	else if (isWithin(num,1000,999999)) {
		return otherNums(num,1000,"thousand");
		//this statement gets numbers between 1000 & 999,999 and converts them with reference to otherNums function

	}
	else if (isWithin(num,1000000,999999999)) {
		return otherNums(num,1000000,"million");
		//this statement gets numbers between 1,000,000 & 999,999,999 and converts them with reference to otherNums function
	}
	else if (isWithin(num,1000000000,2147483647)) {
		return otherNums(num,1000000000,"billion");
		//this statement gets numbers between 1,000,000,000 & 2,147,483,647 and converts them with reference to otherNums function
	}

	else return"";
}
public static void main(String[] args) {

	//The part will request user to enter an integer then convert it to words

	String num1;
	Scanner in= new Scanner(System.in);

	System.out.println("-------------------------------------------------------------------");
		System.out.print("Enter number to convert to words(or 'done' to quit):");

		num1 = in.nextLine();

		
		while(!num1.equals("done")){	
		try{
		int	num3 = Integer.parseInt(num1);

		System.out.println(conversion(num3));
		System.out.print("Enter number to convert to words(or 'done' to quit):");

		}
		catch(NumberFormatException e){
			System.out.println("You have entered the wrong value");
			break;
		}

		num1 = in.nextLine();
		}
		if (num1.equals("done")) 
		{
		System.out.println("Thank you for using our services");
		System.out.println("--------------------------------------------------------------");
		}
}

}