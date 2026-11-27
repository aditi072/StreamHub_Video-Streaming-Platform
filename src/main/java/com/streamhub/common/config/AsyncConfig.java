package com.streamhub.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Turns on @Async so long-running work (like video encoding) runs in the
 * background inside this same app. This stands in for a message queue for now.
 */
@Configuration
@EnableAsync
public class AsyncConfig {
}
