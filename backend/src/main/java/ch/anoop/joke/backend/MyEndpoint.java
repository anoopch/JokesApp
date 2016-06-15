package ch.anoop.joke.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import ch.anoop.joke.producer.JokeProducer;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joke.anoop.ch",
                ownerName = "backend.joke.anoop.ch",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "fetchJoke")
    public MyBean fetchJoke(@Named("index") Integer index) {
        MyBean response = new MyBean();
        response.setData(JokeProducer.fetchJoke(index));
        return response;
    }

}
