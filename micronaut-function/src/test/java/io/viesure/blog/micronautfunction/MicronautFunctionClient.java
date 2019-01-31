package io.viesure.blog.micronautfunction;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface MicronautFunctionClient {

    @Named("micronaut-function")
    Single<String> apply(@Body String request);

}
