package subject;

public class 保持城市天际线_807 {
    /*
        在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
    最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
    建筑物高度可以增加的最大总和是多少？

    例子：
    输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    输出： 35
    解释：
    The grid is:
    [ [3, 0, 8, 4],
      [2, 4, 5, 7],
      [9, 2, 6, 3],
      [0, 3, 1, 0] ]
    从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
    从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
    在不影响天际线的情况下对建筑物进行增高后，新数组如下：
    gridNew = [ [8, 4, 8, 7],
                [7, 4, 7, 7],
                [9, 4, 8, 7],
                [3, 3, 3, 3] ]

     */
    public int myMaxIncreaseKeepingSkyline(int[][] grid) {
        int upSize = 0;
        Integer temp = null;
        Integer temp1 = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (temp == null) {
                    temp = grid[i][j];
                }
                if (grid[i][j] > temp) {
                    temp = grid[i][j];
                }

                if (temp1 == null) {
                    temp1 = grid[j][i];
                }
                if (grid[j][i] > temp1) {
                    temp1 = grid[j][i];
                }

                if (grid[i][j] > temp && grid[i][j] > temp1) {
                    continue;
                }
                if (temp < temp1 && i != j) {
                    upSize += temp - grid[i][j];
                } else if (i != j){
                    upSize += temp1 - grid[i][j];
                }

                temp = 0;
                temp1 = 0;
            }
        }
        return upSize;
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] h = new int[grid.length];
        int[] w = new int[grid[0].length];
        int count = 0;
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (w[i] < grid[i][j]) {
                    w[i] = grid[i][j];
                }
                if (h[i] < grid[j][i]) {
                    h[i] = grid[j][i];
                }
            }
            for (int j = 0; j <= i; j++) {
                if (w[i] < h[j]) {
                    count += w[i] - grid[i][j];
                } else {
                    count += h[j] - grid[i][j];
                }
                if (w[j] < h[i] && i != j) {
                    count += w[j] - grid[j][i];
                } else if (i != j) {
                    count += h[i] - grid[j][i];
                }
            }
        }
        return  count;
    }
}
