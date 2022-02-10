package Recursion;
/*
Problem Constraints
1 <= A <= 18
 */
public class TowersOfHanoi {

    private int currentMove = 0;

    public int[][] towerOfHanoi(int A) {
        int numberOfMoves = (1<<A)-1; // 2^A-1
        int[][] allMoves = new int[numberOfMoves][3];
        toh(allMoves, A, 1, 3, 2);
        return allMoves;
    }
    //S, D, T
    private void toh(int[][] allMoves, int disks, int start, int stop, int temp) {
        if(disks == 0) return;
        toh(allMoves, disks-1, start, temp, stop);
        allMoves[currentMove++] = new int[] {disks, start, stop};
        toh(allMoves, disks-1, temp, stop, start);
    }
}
