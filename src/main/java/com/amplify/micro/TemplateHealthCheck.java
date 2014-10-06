package com.amplify.micro;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/19/14
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
