
package ir.jalambadani.openalpr.alpr.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x",
    "y"
})
public class Coordinate {

    @JsonProperty("x")
    private int x;
    @JsonProperty("y")
    private int y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("x")
    public int getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(int x) {
        this.x = x;
    }

    @JsonProperty("y")
    public int getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(int y) {
        this.y = y;
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
