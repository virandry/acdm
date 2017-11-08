package io.virandry.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

	public static void logInfo(Object o) {
		logger.info("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}

	public static void logDebug(Object o) {
		logger.debug("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}

	public static void logError(Object o) {
		logger.error("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}
}
