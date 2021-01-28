package lt.rieske.kata.minesweeper;

class BoardBuilder {

    private final boolean[][] mines;

    BoardBuilder(int length, int width) {
        this.mines = new boolean[length][width];
    }

    Board build() {
        return new Board(mines);
    }

    BoardBuilder addMine(int x, int y) {
        mines[x][y] = true;
        return this;
    }
}
