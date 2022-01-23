package Maths.PrimeNumbers;

public class CheckPrime {
    //TC: Sqrt(N)
    //Prime number: A number which has only 2 factors (one itself and other one being 1)
    public boolean checkForPrime(int N) {
        boolean isPrime = true;
        if(N==1) {
            isPrime = false;
        }

        for(int i=2;i*i<=N;i++) {
            if(N%i==0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
