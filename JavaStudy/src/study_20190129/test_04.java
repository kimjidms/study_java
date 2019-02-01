package study_20190129;

import java.util.Arrays;

class test_04 {
    public static void main(String[] args) {
        
        int[][] matrix1 = {
             { 15, 43},
             { -2, 38},
             { 72, -48},
        };
        
        int[][] matrix2 = {
             { 34, 0, 42 },
             { 4, 49, 40 },
        };
        
        int[][] result = new int[matrix1.length][matrix2[0].length];
        
        for(int i = 0; i<result.length; i++) {
            for(int j = 0; j<result[0].length; j++) {
                for(int k = 0; k<matrix1[0].length; k++) {
                    
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    
                }
            }
        }
        
        System.out.println(Arrays.deepToString(result));
     }
}