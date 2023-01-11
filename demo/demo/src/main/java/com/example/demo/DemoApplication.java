package com.example.demo;

import com.example.demo.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int userInput;
        int oddNum=0;
        int primeNum=0;
        System.out.println("Enter numbers you want check:");
        userInput = sc.nextInt();
        String temp = String.valueOf(userInput);
        System.out.println(temp);
        int [] a = new int[temp.length()];
        for(int i =0; i<temp.length();i++){

            a[i] = temp.charAt(i)-'0';
//            if(a[i] %2==0){
//                primeNum=primeNum+1;
//            }else{
//                oddNum=oddNum+1;
//            }
//
        }
       Arrays.sort(a);
       System.out.println(Arrays.toString(a));


    }



//public static void main(String[] args){
//    Scanner sc = new Scanner(System.in);
//    int N,Y,X;
//    System.out.println("Enter N:");
//    N=sc.nextInt();
//    System.out.println("Enter X");
//    X=sc.nextInt();
//    System.out.println("Enter Y");
//    Y=sc.nextInt();
//
//    int [] A = new int[N];
//    for(int i=0; i<N;i++){
//        System.out.println("Enter array number");
//        A[i] = sc.nextInt();
//    }
//    System.out.println(countofElements(N,X,Y,A));
//}
//public static int countofElements(int N, int X, int Y, int[]A){
//    int result=0;
//    for(int i=0;i<N;i++){
//        if((A[i]+X)<Y){
//            result=result+1;
//            System.out.println((A[i]));
//        }
//    }
//    System.out.println("ansa"+result);
//    return result;
//}


//    //Split the number and count number with remainder
//    public static int countOfSpecialDigits(int n){
//        int result =0;
//        String temp = String.valueOf(n);
//        int [] a = new int[temp.length()];
//
//        for (int i=0;i<temp.length();i++){
//            a[i] = temp.charAt(i)-'0';
//            if(a[i] % 3==1){
//                result = result + a[i];
//
//            }
//        }
//        System.out.println(result);
//        System.out.println(temp);
//
//        return result;
//    }
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n;
//        System.out.println("Enter number");
//        n=scanner.nextInt();
//
//        System.out.println(countOfSpecialDigits(n));
//    }



//	public static void main(String[] args)
//	{
//		SpringApplication.run(DemoApplication.class, args);
//	}













//public static void main(String[] args){
//
//	Scanner sc = new Scanner(System.in);
//	int N,X,Y;
//	System.out.println("Enter n");
//	N= sc.nextInt();
//	System.out.println("Enter X");
//	X=sc.nextInt();
//	System.out.println("Enter Y");
//	Y=sc.nextInt();
//
//	int[] A = new int[N];
//	int el ;
//	for(int i=0;i<N;i++)
//	{
//		el=i+1;
//		System.out.println("Enter array Element"+el);
//		A[i]= sc.nextInt();
//
//	}
//	System.out.println(countofElement(N,X,Y,A));
//}
//public static int countofElement(int N, int X, int Y,int[] A){
//	int result =0;
//
//	for(int i=0;i<A.length;i++){
//		A[i] = A[i] +X;
//		if(A[i] < Y){
//			result = result+1;
//		}
//		System.out.print(A[i]);
//	}
//System.out.println();
//
//	return result;
//}
//


//public  static void main(String[] args){
//	Scanner sc = new Scanner(System.in);
//	int N;
//	N = sc.nextInt();
//
//	System.out.println(countOfSpecialDigits(N));
//
//}
//public static int

//	public static void main(String[] args){
//		String nstr="";
//		char ch;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter name to be reverse: ");
//		String str = sc.nextLine();
//
//		for (int i=0; i<str.length(); i++)
//		{
//			ch= str.charAt(i); //extracts each character
//			nstr= ch+nstr; //adds each character in front of the existing string
//		}
//		System.out.println("Reversed word: "+ nstr);
//	}
}
