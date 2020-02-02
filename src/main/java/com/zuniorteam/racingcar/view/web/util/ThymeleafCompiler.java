package com.zuniorteam.racingcar.view.web.util;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public final class ThymeleafCompiler {

    private static final ThymeleafTemplateEngine THYMELEAF_TEMPLATE_ENGINE = new ThymeleafTemplateEngine();

    public static String render(Map<String, Object> model, String viewName) {
        return THYMELEAF_TEMPLATE_ENGINE.render(new ModelAndView(model, viewName));
    }
}
