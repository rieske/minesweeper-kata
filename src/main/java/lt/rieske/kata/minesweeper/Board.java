package lt.rieske.kata.minesweeper;

import java.util.stream.IntStream;

class Board {
    private final boolean[][] mines;

    Board(boolean[][] mines) {
        this.mines = mines;
    }

    boolean isMine(int x, int y) {
        if (x >= 0 && x < mines.length && y >= 0 && y < mines[0].length) {
            return mines[x][y];
        }
        return false;
    }

    int adjacentMines(int x, int y) {
        return IntStream.rangeClosed(x - 1, x + 1)
                .map(i -> IntStream.rangeClosed(y - 1, y + 1)
                        .map(j -> isMine(i, j) ? 1 : 0).sum())
                .sum();
    }
}
