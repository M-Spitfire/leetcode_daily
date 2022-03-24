package Array;

public class _661 {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int[] sum = getSum(i, j, img);
                res[i][j] = sum[0] / sum[1];
            }
        }

        return res;
    }

    private int[] getSum(int x, int y, int[][] img) {
        int n = img.length - 1;
        int m = img[0].length - 1;

        int res = 0;
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(n, x + 1); i++){
            for (int j = Math.max(0, y - 1); j <= Math.min(m, y + 1); j++){
                res += img[i][j];
                count++;
            }
        }

        return new int[]{res, count};
    }
}
