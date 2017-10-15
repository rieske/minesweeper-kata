package lt.rieske.kata.minesweeper;

public class BoardBuilder {

    private final boolean[][] mines;

    public BoardBuilder(int length, int width) {
        this.mines = new boolean[length][width];
    }

    public Board build() {
        return new Board(mines);
    }

    public BoardBuilder addMine(int x, int y) {
        mines[x][y] = true;
        return this;
    }
}
