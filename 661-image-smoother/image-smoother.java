class Solution {
    public int[][] imageSmoother(int[][] img) {
        // int n=img.length;
        // int m=img[0].length;
        // int[][]directions={{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         int count=0,sum=0;
        //         for(int[] dir:directions){
        //             int new_i=i+dir[0];
        //             int new_j=j+dir[1];
        //             if(new_i>=0&&new_i<n&&new_j>=0&&new_j<m){
        //                 sum+=img[new_i][new_j];
        //                 count++;
        //             }
        //         }
        //         img[i][j]=(int)Math.floor((sum+img[i][j])/(count+1));
        //     }
        // }
        // return img;


        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int total_sum = 0;
                int count = 0;

                for (int l = Math.max(0, i-1); l < Math.min(rows, i+2); ++l) {
                    for (int k = Math.max(0, j-1); k < Math.min(cols, j+2); ++k) {
                        total_sum += img[l][k];
                        count += 1;
                    }
                }

                result[i][j] = total_sum / count;
            }
        }

        return result;
    }
}