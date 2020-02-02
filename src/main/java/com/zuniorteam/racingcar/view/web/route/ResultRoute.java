package com.zuniorteam.racingcar.view.web.route;

import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.util.StringUtils;
import com.zuniorteam.racingcar.view.web.util.ThymeleafTemplateRender;
import org.json.JSONArray;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

import static java.util.stream.Collectors.toList;

public final class ResultRoute {

    private ResultRoute() {
    }

    public static class post implements Route {

        private static final String PARAMETER_TURN = "turn";
        private static final String PARAMETER_NAMES = "names";
        private static final String RESULT_VIEW_NAME = "result";

        @Override
        public Object handle(Request request, Response response) throws Exception {

            final List<String> names = getNames(request);
            final int turn = getTurn(request);

            final GameInput gameInput = new GameInput(names, turn);
            final GameResult gameResult = new RacingGame(gameInput).playGame(new RandomMovingStrategy());

            final Map<String, Object> model = new HashMap<>();
            model.put("gameResult", gameResult);

            return ThymeleafTemplateRender.render(model, RESULT_VIEW_NAME);
        }

        private List<String> getNames(Request request) {
            final String namesString = request.queryParams(PARAMETER_NAMES);

            validateNames(namesString);

            return new JSONArray(namesString).toList()
                    .stream()
                    .map(Object::toString)
                    .collect(toList());
        }

        private void validateNames(String namesString) {
            if (StringUtils.isEmpty(namesString)) {
                throw new IllegalArgumentException("자동차 이름이 없습니다");
            }
        }

        private int getTurn(Request request) {
            final String turnString = request.queryParams(PARAMETER_TURN);

            validateTurn(turnString);

            return Integer.parseInt(turnString);
        }

        private void validateTurn(String turnString) {
            if (StringUtils.isEmpty(turnString)) {
                throw new IllegalArgumentException("시도 횟수를 입력해주세요");
            }
        }
    }
}
