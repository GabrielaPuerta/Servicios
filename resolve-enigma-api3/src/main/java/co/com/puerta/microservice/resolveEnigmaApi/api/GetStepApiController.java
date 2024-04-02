package co.com.puerta.microservice.resolveEnigmaApi.api;

import co.com.puerta.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-28T15:17:04.680969-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private JsonApiBodyResponseSuccess response;

    private List<JsonApiBodyResponseSuccess> listresponse;
    
    private GetEnigmaStepResponse enigma;
    
    private List<GetEnigmaStepResponse> enigmas;


    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request, List<GetEnigmaStepResponse> enigmas,GetEnigmaStepResponse enigma, JsonApiBodyResponseSuccess response, List<JsonApiBodyResponseSuccess> listresponse ) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.enigma = enigma;
        this.enigmas = enigmas;
        this.response = response;
        this.listresponse = listresponse;
    }

    public ResponseEntity<List<JsonApiBodyResponseSuccess>> getStep(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        JsonApiBodyResponseSuccess response = new JsonApiBodyResponseSuccess();
        List<JsonApiBodyResponseSuccess> listresponse = new  ArrayList<JsonApiBodyResponseSuccess>();
        List<GetEnigmaStepResponse> dataResponse = new ArrayList<GetEnigmaStepResponse>();
        GetEnigmaStepResponse responseAttributes = new GetEnigmaStepResponse();
        responseAttributes.setHeader(body.getData().get(0).getHeader());
        
        	responseAttributes.setAnswer("Step3: Cierra la Puerta");
        	dataResponse.add(responseAttributes);
        	response.setData(dataResponse);
        	
        	listresponse.add(response);
            
        
        return new ResponseEntity<List<JsonApiBodyResponseSuccess>>(listresponse, HttpStatus.OK);
        
    	}
    
    @GetMapping(value = "/getStepString")
    public ResponseEntity<String> getStepString() {
        String enigmaString = "Step3: Cierra la Puerta";
        return new ResponseEntity<>(enigmaString, HttpStatus.OK);
    }

}
