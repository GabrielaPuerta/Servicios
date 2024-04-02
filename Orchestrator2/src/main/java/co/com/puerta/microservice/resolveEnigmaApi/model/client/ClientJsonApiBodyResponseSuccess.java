package co.com.puerta.microservice.resolveEnigmaApi.model.client;

import co.com.puerta.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ClientJsonApiBodyResponseSuccess
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-28T15:17:04.680969-05:00[America/Bogota]")
@Component
public class ClientJsonApiBodyResponseSuccess {
  @JsonProperty("data")
  @Valid
  private List<GetEnigmaStepResponse> data = new ArrayList<GetEnigmaStepResponse>();

  public ClientJsonApiBodyResponseSuccess data(List<GetEnigmaStepResponse> data) {
    this.data = data;
    return this;
  }

  public ClientJsonApiBodyResponseSuccess addDataItem(GetEnigmaStepResponse dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<GetEnigmaStepResponse> getData() {
    return data;
  }

 
  public void setData(List<GetEnigmaStepResponse> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientJsonApiBodyResponseSuccess clientJsonApiBodyResponseSuccess = (ClientJsonApiBodyResponseSuccess) o;
    return Objects.equals(this.data, clientJsonApiBodyResponseSuccess.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientJsonApiBodyResponseSuccess {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
