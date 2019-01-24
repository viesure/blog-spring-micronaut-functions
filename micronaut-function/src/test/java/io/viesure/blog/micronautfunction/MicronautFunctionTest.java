package io.viesure.blog.micronautfunction;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MicronautFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        MicronautFunctionClient client = server.getApplicationContext().getBean(MicronautFunctionClient.class);

        assertEquals(client.apply("Test").blockingGet(), "tseT");
        server.stop();
    }
}
