package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.core.MovingStrategy;

import java.util.Objects;

public class RacingGameBoard {

    private final GameInputView gameInputView;
    private final GameResultView gameResultView;

    public RacingGameBoard(GameInputView gameInputView, GameResultView gameResultView) {
        assert gameInputView != null;
        assert gameResultView != null;

        this.gameInputView = gameInputView;
        this.gameResultView = gameResultView;
    }

    public void start(MovingStrategy movingStrategy) {
        validate(movingStrategy);

        final GameInput gameInput = gameInputView.listen();
        final GameResult result = playGame(gameInput, movingStrategy);

        gameResultView.draw(result);
    }

    private void validate(MovingStrategy movingStrategy) {
        if (Objects.isNull(movingStrategy)) {
            throw new RuntimeException("무빙전략을 지정해주세요");
        }
    }

    private GameResult playGame(GameInput gameInput, MovingStrategy movingStrategy) {
        final RacingGame racingGame = new RacingGame(gameInput);
        return racingGame.playGame(movingStrategy);
    }

}
