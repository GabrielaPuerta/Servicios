package co.com.puerta.microservice.resolveEnigmaApi.routes;

import co.com.puerta.microservice.resolveEnigmaApi.model.client.ClientJsonApiBodyResponseSuccess;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class GetStepThreeClientRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception{
		
		from ("direct:get-step-three")
		.routeId("getStepThree")
		.setHeader(Exchange.HTTP_METHOD, constant ("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant ("application/json"))
		.to("freemarker:templates/GetStepOneClientTemplate.ftl")
		//.log("Request microservice step three ${body}")
		.hystrix()
		.hystrixConfiguration().executionTimeoutInMilliseconds(2000).end()
		.to("http4://localhost:8082/v1/getOneEnigma/getStep")
		.convertBodyTo(String.class)
		//.log("Response microservice step three ${body}")
		.unmarshal().json(JsonLibrary.Jackson, ClientJsonApiBodyResponseSuccess.class)
		//.log("Java response microservice step three ${body}")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				ClientJsonApiBodyResponseSuccess responseSuccess = (ClientJsonApiBodyResponseSuccess) exchange.getIn().getBody();
				if(responseSuccess.getData().get(0).getAnswer().contains("3")){
					exchange.setProperty("Step3", responseSuccess.getData().get(0).getAnswer());
				} else {
					exchange.setProperty("Error", "0001");
					exchange.setProperty("descError", "Step 3 invalid");
				}
			}
		})
		.endHystrix()
		.onFallback()
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.setProperty("Error", "0002");
				exchange.setProperty("descError", "Error getting Step 3");
			}
		})
		.end()
		.log("Response Code: ${exchangeProperty[Error]}")
		.log("Response Description: ${exchangeProperty[descError]}")
		.log("Response Description: ${exchangeProperty[Step3]}");
	}

}
