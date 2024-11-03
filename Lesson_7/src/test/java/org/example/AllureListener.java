package org.example;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AllureListener implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        String displayName = context.getDisplayName();
        step("Test started: " + displayName);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        String displayName = context.getDisplayName();

        if (context.getExecutionException().isPresent()) {
            Throwable exception = context.getExecutionException().get();
            step(String.format("Test failed: %s with exception: %s", displayName, exception.getMessage()));
        } else {
            step("Test finished: " + displayName);
        }
    }
}
