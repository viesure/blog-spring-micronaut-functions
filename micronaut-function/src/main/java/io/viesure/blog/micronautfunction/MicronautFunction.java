package io.viesure.blog.micronautfunction;

import io.micronaut.function.FunctionBean;

import java.util.function.Function;

@FunctionBean("micronaut-function")
public class MicronautFunction implements Function<String, String> {
    @Override
    public String apply(String request) {
        return new StringBuilder(request).reverse().toString();
    }
}
