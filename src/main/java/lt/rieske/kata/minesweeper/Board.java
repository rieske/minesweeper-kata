package lt.rieske.kata.minesweeper;

public class Board {
    private final boolean[][] mines;

    public Board(boolean[][] mines) {
        this.mines = mines;
    }

    public boolean isMine(int x, int y) {
        if (x >= 0 && x < mines.length && y >= 0 && y < mines[0].length) {
            return mines[x][y];
        }
        return false;
    }

    public int adjacentMines(int x, int y) {
        int adjacentMines = 0;
        for (int i = x-1; i <= x+1; ++i) {
            for (int j = y-1; j <= y+1; ++j) {
                if (isMine(i, j)) {
                    ++adjacentMines;
                }
            }
        }
        return adjacentMines;
    }
}
