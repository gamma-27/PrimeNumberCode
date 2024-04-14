package primeN;
import java.util.Scanner;

public class prime {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //here I'm asking for the range you want the prime numbers to be.
        System.out.println("Enter the range 1");
        int n1=sc.nextInt();
        System.out.println("Enter the range 2");
        int n2=sc.nextInt();
        //This is the function we are calling here which will give prime numbers between n1 and n2;
        isPrime(n1, n2);
    }
    static void isPrime(int n1,int n2){
        //we are making boolean array of n2+1 size because as we know 1 is not a prime number and we have to start 
        //from 2 to that number which will be then n2+1.
        boolean [] Prime=new boolean[n2+1];
        //Intially we making all the boolean value true from 2 to range 2 number;
        for(int i=2;i<=n2;i++){
            Prime[i]=true;
        }
        //we are running the loop from 2 to <=n2 and checking that value of boolean array of i is true or not
        //if it is true and we are checking for its multiple till <=n2 and making its multiple false as this means it is
        //not a prime number . we are again running the loop for i+1 and in the end that true boolean values be the prime number.
        for(int i=2;i*i<=n2;i++){
            //To optimize it we know that loop till under root n as for j it is i*i so for i<=n that i*i will go out of bound 
            //means more than n2 which is worthless and extra operations of no use , so we calculated till underroot n. 
            if(Prime[i]==true){
                //and if we do i*2 it always gives true as the real numbers start from i2 which is i*i.
                //for ex for 2 we have to check from 4.
                //for 3 we have to check from 9 which is 3*3 (i^2) as if we do 3*3=6 which is already false as 2*3=6
                //which is already false, instead of marking false again who are already marked , we can optimize it by i*i.
                for(int j=i*i;j<=n2;j=j+i){
                    Prime[j]=false;
                }
            }
        }
        // here we are running loop from n1 to <=n2 and checking that the boolean value is true that means that particular value is prime no.
        //Hence printing that value of i.
        for(int i=n1;i<=n2;i++){
            if(Prime[i]){
                System.out.print(i+" ");
            }
        }
    }
}
