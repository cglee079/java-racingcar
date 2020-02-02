package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.view.console.RacingGameBoard;
import com.zuniorteam.racingcar.view.console.GameInputView;
import com.zuniorteam.racingcar.view.console.GameResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameBoardTest {

    @DisplayName("New Instance, Assert 에러")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new RacingGameBoard(new GameInputView(), new GameResultView()));
    }

    @DisplayName("New Instance, Assert 에러")
    @Test
    void testNewInstance02() {

        assertAll(
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(new GameInputView(), null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, new GameResultView()))
        );
    }

}
