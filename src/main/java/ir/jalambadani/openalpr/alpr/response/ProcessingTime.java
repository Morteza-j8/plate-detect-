
package ir.jalambadani.openalpr.alpr.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "plates",
    "vehicles"
})
public class ProcessingTime {

    @JsonProperty("total")
    private int total;
    @JsonProperty("plates")
    private int plates;
    @JsonProperty("vehicles")
    private int vehicles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    @JsonProperty("plates")
    public int getPlates() {
        return plates;
    }

    @JsonProperty("plates")
    public void setPlates(int plates) {
        this.plates = plates;
    }

    @JsonProperty("vehicles")
    public int getVehicles() {
        return vehicles;
    }

    @JsonProperty("vehicles")
    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
