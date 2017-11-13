package io.virandry.search.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.virandry.search.model.GenericError;
import io.virandry.search.model.GenericErrorResponse;
import io.virandry.search.util.Constant;

@CrossOrigin(origins = {"${cors.dev}","${cors.prd}"})
public abstract class AbstractRest {
	private static final Logger logger = LoggerFactory.getLogger(AbstractRest.class);

	public static void logInfo(Object o) {
		logger.info("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}
	
	public static void logDebug(Object o) {
		logger.debug("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}
	
	public static void logError(Object o) {
		logger.error("\r\n\r\n INFO: " + o + "\r\n\r\n");
	}
	
	public GenericErrorResponse getErrorResponse() {
		GenericError error = new GenericError(Constant.STATUS_NOT_FOUND,Constant.MESSAGE_NOT_FOUND);
		return new GenericErrorResponse(error);
	}
}
