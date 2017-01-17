import java.util.Arrays;

/**
 * Created by posam on 2017-01-17.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Generation {
    private int[][] cells;

    public Generation(int[][] cells) {
        this.cells = cells;


    }

    Generation createNextGeneration() {
        int[] neighbors = new int[8];
        int sumPerCell;
        int rows = this.cells.length;
        int cols = this.cells[0].length;
        int[] pos = new int[2];
        int[][] newGen = new int[3][3];
        for (pos[1] = 0; pos[1] < rows; pos[1]++) {
            for (pos[0] = 0; pos[0] < cols; pos[0]++) {
                sumPerCell = 0;

                if (-1 < pos[1] - 1 && -1 < pos[0] - 1) { // upper left
                    neighbors[0] = this.cells[pos[0] - 1][pos[1] - 1];
                    sumPerCell += neighbors[0];
                }

                if (-1 < pos[1] - 1) { //upper
                    neighbors[1] = this.cells[pos[0]][pos[1] - 1];
                    sumPerCell += neighbors[1];
                }

                if (-1 < pos[1] - 1 && pos[0] + 1 < rows) { //upper right
                    neighbors[2] = this.cells[pos[0] + 1][pos[1] - 1];
                    sumPerCell += neighbors[2];
                }

                if (pos[0] + 1 < rows) { //right
                    neighbors[3] = this.cells[pos[0] + 1][pos[1]];
                    sumPerCell += neighbors[3];
                }

                if (pos[1] + 1 < cols && pos[0] + 1 < cols) { //lower right
                    neighbors[4] = this.cells[pos[0] + 1][pos[1] + 1];
                    sumPerCell += neighbors[4];
                }

                if (pos[1] + 1 < cols) { //lower
                    neighbors[5] = this.cells[pos[0]][pos[1] + 1];
                    sumPerCell += neighbors[5];
                }

                if (pos[1] + 1 < cols && -1 < pos[0] - 1) { //lower left
                    neighbors[6] = this.cells[pos[0] - 1][pos[1] + 1];
                    sumPerCell += neighbors[6];
                }

                if (-1 < pos[0] - 1) { //left
                    neighbors[7] = this.cells[pos[0] - 1][pos[1]];
                    sumPerCell += neighbors[7];
                }
                newGen[pos[0]][pos[1]] = sumPerCell;
            }
        }

        return new Generation(killOrResurrect(newGen));
    }

    int[][] killOrResurrect(int[][] neighborSum) {
        for (int i = 0; i < neighborSum.length; i++) {
            for (int j = 0; j < neighborSum[0].length; j++) {
                if ((neighborSum[j][i] == 2 || neighborSum[j][i] == 3)) {
                    neighborSum[j][i] = 1;
                } else neighborSum[j][i] = 0;
            }
        }
        return neighborSum;
    }

    @Override
    public boolean equals(Object obj) {
        Generation masik = ((Generation) obj);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!(cells[i][j] == masik.cells[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String print = "Generation{cells=\n";
        for (int[] row : cells) {
            print += Arrays.toString(row) + "\n";
        }
        return print;
    }

    //    public Generation createNextGeneration() {
//        return new Generation(new int[][]{{0, 1, 1},
//                {0, 1, 1},
//                {0, 0, 0}});
//    }

    public static void main(String[] args) {
        Generation origin = new Generation(new int[][]{{0, 1, 0},
                {0, 1, 1},
                {0, 0, 0}});

        Generation result = origin.createNextGeneration();

        System.out.println(origin.toString());
        System.out.println(result.toString());
        System.out.println(result.createNextGeneration().toString());
    }

}
