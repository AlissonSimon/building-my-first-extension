package org.acme.greeting.extension.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;
import org.acme.greeting.extension.GreetingExtensionServlet;

class GreetingExtensionProcessor {

    private static final String FEATURE = "greeting-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ServletBuildItem createServlet() {
        var servletBuildItem = ServletBuildItem.builder("greeting-extension", GreetingExtensionServlet.class.getName())
                .addMapping("/greeting")
                .build();
        return servletBuildItem;
    }
}
