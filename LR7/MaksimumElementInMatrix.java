public class MaksimumElementInMatrix {
    static class RowMaxFinder extends Thread {
        private int[] row;
        private int max;  

        public RowMaxFinder(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            max = row[0];
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        public int getMax() {
            return max;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 5, 9},
            {7, 1, 4},
            {8, 6, 2}
        };

        RowMaxFinder[] threads = new RowMaxFinder[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowMaxFinder(matrix[i]);
            threads[i].start();
        }

        for (RowMaxFinder thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int overallMax = threads[0].getMax(); 
        for (RowMaxFinder thread : threads) {
            if (thread.getMax() > overallMax) {
                overallMax = thread.getMax();
            }
        }

        System.out.println("Наибольший элемент в матрице: " + overallMax);
    }
}
