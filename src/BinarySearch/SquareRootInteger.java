package BinarySearch;

/*
Problem Description:
Given an integer A.
Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.

Problem Constraints: 0 <= A <= 10^10

Input Format: The first and only argument given is the integer A.
Output Format: Return floor(sqrt(A))
 */
public class SquareRootInteger {
    public int sqrt(int A) {
        //define a search space: for 0<=A<=10^10; sqrt should lie b/w [0,10^5]
        int low = 0, high = 100000, sqrt = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            long square = (long)mid*mid;
            if(square == A) {
                sqrt = mid;
                break;
            } else if(square>A) {
                high = mid-1;
            } else {
                //mid is a probable answer; look for a more closer answer in right
                sqrt = mid;
                low = mid+1;
            }
        }
        return sqrt;
    }
}
