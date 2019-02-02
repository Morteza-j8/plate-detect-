
package ir.jalambadani.openalpr.alpr.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "color",
    "make",
    "make_model",
    "body_type"
})
public class Vehicle {

    @JsonProperty("color")
    private List<Color> color = null;
    @JsonProperty("make")
    private List<Make> make = null;
    @JsonProperty("make_model")
    private List<MakeModel> makeModel = null;
    @JsonProperty("body_type")
    private List<BodyType> bodyType = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("color")
    public List<Color> getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(List<Color> color) {
        this.color = color;
    }

    @JsonProperty("make")
    public List<Make> getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(List<Make> make) {
        this.make = make;
    }

    @JsonProperty("make_model")
    public List<MakeModel> getMakeModel() {
        return makeModel;
    }

    @JsonProperty("make_model")
    public void setMakeModel(List<MakeModel> makeModel) {
        this.makeModel = makeModel;
    }

    @JsonProperty("body_type")
    public List<BodyType> getBodyType() {
        return bodyType;
    }

    @JsonProperty("body_type")
    public void setBodyType(List<BodyType> bodyType) {
        this.bodyType = bodyType;
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
