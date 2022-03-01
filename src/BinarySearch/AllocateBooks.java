package BinarySearch;

/*
Problem Description
Given an array of integers A of size N and an integer B.

College library has N books,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that
maximum number of pages alloted to a student is minimum.
A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example:
A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Problem Constraints
1 <= N <= 10^5
1 <= A[i], B <= 10^5

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return that minimum possible number

Example Input: A = [12, 34, 67, 90]
B = 2

Example Output: 113
Example Explanation
There are 2 number of students. Books can be distributed in following fashion :
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
        Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {

    public int books(int[] A, int B) {
        if(B > A.length) {
            return -1;
        }
        long l = 0, h= 0;
        for(int i=0;i<A.length;i++) {
            l=Math.max(A[i],l);
            h+=A[i];
        }
        long minPages = -1;
        while(l<=h) {
            long m = (l+h)/2;
            if(booksCanBeReadWithPages(A, B, m)) {
                minPages = m;
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return (int) minPages;
    }

    private boolean booksCanBeReadWithPages(int[] books, int numStuds, long maxPages) {
        int countStuds = 0;
        long pagesRead = 0;
        for(int i=0;i<books.length;i++) {
            int numBooksLeft = books.length-i-1;
            int numStudsLeft = numStuds-countStuds-1;
            pagesRead += books[i];
            if(books[i] > maxPages) {
                return false;
            }
            if((numStudsLeft == numBooksLeft) || (pagesRead > maxPages)) {
                countStuds++;
                pagesRead = (pagesRead > maxPages) ? books[i] : 0;
            }

        }

        if(pagesRead > 0) {
            countStuds++;
        }

        if(countStuds != numStuds) return false;
        return true;
    }
}
