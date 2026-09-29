package utils;

import base.BaseTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestWatcherExtension implements TestWatcher {

    @Override
    public void testFailed(
            ExtensionContext context,
            Throwable cause
    ) {

        Object testInstance =
                context.getRequiredTestInstance();

        if (testInstance instanceof BaseTest baseTest) {

            if (baseTest.getDriver() != null) {

                ScreenshotUtils.capture(
                        baseTest.getDriver(),
                        context.getDisplayName()
                );
            }
        }
    }
}