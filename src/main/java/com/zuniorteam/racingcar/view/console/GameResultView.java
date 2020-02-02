package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.dto.StepResult;
import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.List;

public class GameResultView {

    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";
    private static final String BORDER = " : ";

    public void draw(GameResult result) {
        System.out.println("실행 결과");
        System.out.println(describeGameResult(result));
    }

    private String describeGameResult(GameResult result) {
        final StringBuilder drawing = new StringBuilder();

        final List<StepResult> stepResults = result.getStepResults();

        for (StepResult stepResult : stepResults) {
            drawing.append(drawStep(stepResult))
                    .append(NEW_LINE);
        }

        drawing.append(NEW_LINE);
        drawing.append(NEW_LINE);

        drawing.append(drawWinners(result.getWinners()));
        return drawing.toString().trim();
    }

    private String drawStep(StepResult stepResult) {
        final StringBuilder stepDrawing = new StringBuilder();
        final List<MoveHistory> moveHistories = stepResult.getMoveHistories();

        for (MoveHistory moveHistory : moveHistories) {
            stepDrawing.append(moveHistory.getCarName())
                    .append(BORDER)
                    .append(drawLine(moveHistory.getPosition()))
                    .append(NEW_LINE);
        }

        return stepDrawing.toString();
    }

    private String drawLine(Integer position) {
        final StringBuilder line = new StringBuilder();
        for (int i = 0; i < position; i++) {
            line.append(DASH);
        }

        return line.toString();
    }

    private String drawWinners(List<String> carNames) {
        return "승자는 " + carNames + " 입니다";
    }

}
