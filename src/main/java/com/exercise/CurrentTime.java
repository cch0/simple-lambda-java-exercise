package com.exercise;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Date;

public class CurrentTime implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        LambdaLogger logger = context.getLogger();

        logger.log(String.format("name:%s, requestId:%s, function:%s, groupName:%s, logStreamName:%s",
            request.getName(), context.getAwsRequestId(), context.getFunctionName(),
            context.getLogGroupName(), context.getLogStreamName()));

        Response response = new Response();
        response.setMessage((new Date()).toString());

        return response;
    }
}
