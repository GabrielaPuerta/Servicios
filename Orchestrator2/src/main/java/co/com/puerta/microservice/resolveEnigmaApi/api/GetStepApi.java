/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package co.com.puerta.microservice.resolveEnigmaApi.api;

import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.puerta.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-28T15:17:04.680969-05:00[America/Bogota]")
@Api(value = "getStep", description = "the getStep API")
public interface GetStepApi {

    @ApiOperation(value = "Get one enigma step API", nickname = "getStep", notes = "Get one enigma step API", response = JsonApiBodyResponseSuccess.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = JsonApiBodyResponseSuccess.class, responseContainer = "List"),
        @ApiResponse(code = 424, message = "bad input parameter", response = JsonApiBodyResponseErrors.class, responseContainer = "List") })
    @RequestMapping(value = "/getStep",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<?> getStep(@ApiParam(value = "request body get enigma step" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body);

}