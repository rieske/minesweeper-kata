package lt.rieske.kata.minesweeper;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void boardWithoutMinesContainsNoMines() {
        int length = 4;
        int width = 4;
        Board board = new BoardBuilder(length, width).build();

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < width; ++j) {
                assertThat(board.isMine(i, j)).isFalse();
            }
        }
    }

    @Test
    public void onlyMinedFieldsContainMines() {
        int length = 4;
        int width = 4;

        Board board = new BoardBuilder(length, width)
                .addMine(2, 2)
                .build();

        assertThat(board.isMine(2, 2)).isTrue();

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < width; ++j) {
                if (i != 2 && j != 2) {
                    assertThat(board.isMine(i, j)).isFalse();
                }
            }
        }
    }

    @Test
    public void oneAdjacentMineAroundCentralMine() {
        int length = 3;
        int width = 3;

        Board board = new BoardBuilder(length, width)
                .addMine(1, 1)
                .build();

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < width; ++j) {
                if (i != 1 && j != 1) {
                    assertThat(board.adjacentMines(i, j)).isEqualTo(1);
                }
            }
        }
    }

    @Test
    public void exampleBoardWithMines() {
        /*
        *100
        2210
        1*10
        1110
         */
        int length = 4;
        int width = 4;

        Board board = new BoardBuilder(length, width)
                .addMine(0, 0)
                .addMine(1, 2)
                .build();

        assertThat(board.adjacentMines(0, 1)).isEqualTo(2);
        assertThat(board.adjacentMines(0, 2)).isEqualTo(1);
        assertThat(board.adjacentMines(0, 3)).isEqualTo(1);

        assertThat(board.adjacentMines(1, 0)).isEqualTo(1);
        assertThat(board.adjacentMines(1, 1)).isEqualTo(2);
        assertThat(board.adjacentMines(1, 3)).isEqualTo(1);

        assertThat(board.adjacentMines(2, 0)).isZero();
        assertThat(board.adjacentMines(2, 1)).isEqualTo(1);
        assertThat(board.adjacentMines(2, 2)).isEqualTo(1);
        assertThat(board.adjacentMines(2, 3)).isEqualTo(1);

        assertThat(board.adjacentMines(3, 0)).isZero();
        assertThat(board.adjacentMines(3, 1)).isZero();
        assertThat(board.adjacentMines(3, 2)).isZero();
        assertThat(board.adjacentMines(3, 3)).isZero();
    }
}
