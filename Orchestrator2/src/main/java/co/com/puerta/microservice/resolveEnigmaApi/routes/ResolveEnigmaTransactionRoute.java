package co.com.puerta.microservice.resolveEnigmaApi.routes;

import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import co.com.puerta.microservice.resolveEnigmaApi.model.client.ClientJsonApiBodyResponseSuccess;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ResolveEnigmaTransactionRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:resolve-enigma")
                .routeId("resolveEnigma")
                .log("Request Body ${body}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        JsonApiBodyRequest request = (JsonApiBodyRequest) exchange.getIn().getBody();
                        exchange.setProperty("serviceId", request.getData().get(0).getHeader().getId());
                        exchange.setProperty("serviceType", request.getData().get(0).getHeader().getType());
                        exchange.setProperty("serviceEnigma", request.getData().get(0).getEnigma());
                    }
                })
                .to("direct:get-step-one")
                .to("direct:get-step-two")
                .to("direct:get-step-three")
                .to("freemarker:templates/ResolveEnigmaTransaction.ftl")
                .unmarshal().json(JsonLibrary.Jackson, JsonApiBodyResponseSuccess.class)
                .log("Response Body: ${body}");
    }
}
