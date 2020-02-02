package com.zuniorteam.racingcar.view.web.route;

import com.zuniorteam.racingcar.util.StringUtils;
import com.zuniorteam.racingcar.view.web.util.ThymeleafCompiler;
import org.json.JSONArray;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

public final class NameRoute {

    private NameRoute() {
    }

    public static class post implements Route {

        private static final String PARAMETER_NAMES = "names";
        private static final String SPLIT_TOKEN = "\\s";
        private static final String GAME_VIEW_NAME = "game";

        @Override
        public Object handle(Request request, Response response) throws Exception {

            final JSONArray names = getNames(request);

            final Map<String, Object> model = Collections.singletonMap("names", names);

            return ThymeleafCompiler.render(model, GAME_VIEW_NAME);
        }

        private JSONArray getNames(Request request) {
            final String namesString = request.queryParams(PARAMETER_NAMES);

            validate(namesString);

            return new JSONArray(namesString.split(SPLIT_TOKEN));
        }

        private void validate(String namesString) {
            if (StringUtils.isEmpty(namesString)) {
                throw new IllegalArgumentException("자동차 이름이 없습니다");
            }
        }

    }
}
