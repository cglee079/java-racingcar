package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.view.console.RacingGameBoard;
import com.zuniorteam.racingcar.view.console.GameInputView;
import com.zuniorteam.racingcar.view.console.GameResultView;

public class ConsoleMain {

    public static void main(String[] args){
        final GameInputView gameInputView = new GameInputView();
        final GameResultView gameResultView = new GameResultView();
        final MovingStrategy movingStrategy = new RandomMovingStrategy();

        new RacingGameBoard(gameInputView, gameResultView).start(movingStrategy);
    }
}
