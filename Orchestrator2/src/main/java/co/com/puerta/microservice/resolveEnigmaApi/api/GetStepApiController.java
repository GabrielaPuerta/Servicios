package co.com.puerta.microservice.resolveEnigmaApi.api;

import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import co.com.puerta.microservice.resolveEnigmaApi.model.client.ClientJsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-28T15:17:04.680969-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private Object response;
    
    @EndpointInject(uri="direct:resolve-enigma")
    private FluentProducerTemplate producerTemplateResolveEnigma;
    
    
    
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		super();
		this.objectMapper = objectMapper;
		this.request = request;
	}



	public ResponseEntity<?> getStep(@ApiParam(value= "body", required=true)@Valid @RequestBody JsonApiBodyRequest body) {
        try {
            response = producerTemplateResolveEnigma.withBody(body).request();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + "Respuesta del Servicio");
            return new ResponseEntity<JsonApiBodyResponseSuccess>((JsonApiBodyResponseSuccess)response, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<JsonApiBodyResponseErrors>((JsonApiBodyResponseErrors)response, HttpStatus.FAILED_DEPENDENCY);
        }
    }
}

