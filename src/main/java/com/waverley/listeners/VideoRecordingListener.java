package com.waverley.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import javax.annotation.CheckReturnValue;

import static com.waverley.utils.AttachAllureUtils.attachUri;

public class VideoRecordingListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }

    @Override
    @CheckReturnValue
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            final String fileName = String.format("http://localhost:4444/video/%s.mp4",
                    testResult.getAttribute("sessionId"));
            attachUri("Video", fileName);
        }
    }
}
