package com.zuniorteam.racingcar.view.web.util;

import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public final class ThymeleafTemplateRender {

    private ThymeleafTemplateRender() {
    }

    private static final TemplateEngine TEMPLATE_ENGINE = new ThymeleafTemplateEngine();

    public static String render(Map<String, Object> model, String viewName) {
        return TEMPLATE_ENGINE.render(new ModelAndView(model, viewName));
    }
}
