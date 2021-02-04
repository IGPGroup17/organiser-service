package com.igp.organiserservice.util;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EnvironmentLogger {

    public static void log(APIGatewayProxyRequestEvent event, Context context) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LambdaLogger logger = context.getLogger();

        log(logger, "ENVIRONMENTAL VARIABLES: " + System.getenv());
        log(logger, "CONTEXT: " + gson.toJson(context));
        log(logger, "EVENT: " + gson.toJson(event));
        log(logger, "EVENT TYPE: " + event.getClass().getSimpleName());
    }

    private static void log(LambdaLogger lambdaLogger, String string) {
        lambdaLogger.log(string);
    }
}
