package codeasses;

import java.util.HashSet;
import java.util.Set;

/*
Write a program that takes one integer N and an array of N * N elements (the first line contains the integer N
and the next N lines contain N integers each, representing the two dimensional array).
Your program should give as output the size of the maximum square array(an array of size M * M)
that is a magic square and is a sub - array of the inputted array. A magic square is a square of numbers such that
when you pick any set of N cells from that square, each cell from the set doesn't share a row or a column
with any other cell from that set, and the sum of those N cells is the same for each such possible set of cells.

Example

Case 1:

For the input provided as follows :

2
23 40
9 26

Output of the program will be :

2

Description :

    As 23 + 26 is equal to 40 + 9, the inputted array is a magic square, giving us a maximum answer of 2.

    Case 2 :

    For the input provided as follows :

4
- 41 - 29 2 1
28 40 71 2
11 23 54 3
4 5 6 7 8

Output of the program will be :

3

Description :

    As the inputted array is not a magic square, the answer can not be 4. Looking at all the possible square arrays,
    we can check that the maximum answer is 3 with the following 3 x 3 array :

    -41 - 29 2
    28 40 71
    11 23 54
*/
public class MagicSquare {

    /**
     * first check if this square is a magic square if it is, return the number
     * <p>
     * for n-1 * n-1 sub square check
     * <p>
     * smallest n is 2
     * <p>
     * other wise return 0
     */

    private static boolean isMagicSquare(int[][] grid, int d, int row, int col) {
        if (grid == null || grid.length < 2 || d < 2) {
            return false;
        }

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();

        int sumTopLeftToBottomRight = 0;
        int sumLeftBottomToTopRight = 0;
        for (i = row; i < row + d; i++) {
            for ( j = col; j < col + d; j++) {

                if (set.contains(grid[i][j])) {
                    return false;
                }
                set.add(grid[i][j]);

                if (i == j) {
                    sumTopLeftToBottomRight += grid[i][j];
                }

                System.out.println("hey");
                System.out.println( i + j);

                if (i + j == d + row + col ) {
                    sumTopLeftToBottomRight += grid[i][j];
                }
            }
        }

        System.out.println("sumTopLeftToBottomRight: " + sumTopLeftToBottomRight);
        System.out.println("sumLeftBottomToTopRight: " + sumLeftBottomToTopRight);

//        if (sumTopLeftToBottomRight != sumLeftBottomToTopRight) {
//            return false;
//        }

        int sumCol = 0;
        for (int k = row; k < row + d; k++) {
            sumCol += grid[k][col];
        }
        if (sumCol != sumTopLeftToBottomRight) {
            return false;
        }

        int sumRow = 0;
        for (int k = col; k < col + d; k++) {
            sumRow += grid[row][k];
        }

        if (sumRow != sumTopLeftToBottomRight) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int initValue = 4;
        int[][] initSquare = new int[][]{{-41, -29, 2, 1}, {28, 40, 71, 2}, {11, 23, 54, 3}, {4, 5, 6, 7, 8}};

        int count = 0;

        for (int dimension = initValue; dimension >= 2; dimension--) {

            for (int i = 0; i <= initSquare.length - dimension; i++) {

                for (int j = 0; j < initSquare.length - dimension; j++) {

                    if (isMagicSquare(initSquare, dimension, i, j)) {
                        System.out.println("--");

                        System.out.println(dimension);
                        break;
                    } else {
                        System.out.println("not: " + dimension);
                    }
                }
            }
        }


    }
}
