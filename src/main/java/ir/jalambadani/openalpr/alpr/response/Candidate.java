
package ir.jalambadani.openalpr.alpr.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plate",
    "confidence",
    "matches_template"
})
public class Candidate {

    @JsonProperty("plate")
    private String plate;
    @JsonProperty("confidence")
    private int confidence;
    @JsonProperty("matches_template")
    private int matchesTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("plate")
    public String getPlate() {
        return plate;
    }

    @JsonProperty("plate")
    public void setPlate(String plate) {
        this.plate = plate;
    }

    @JsonProperty("confidence")
    public int getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("matches_template")
    public int getMatchesTemplate() {
        return matchesTemplate;
    }

    @JsonProperty("matches_template")
    public void setMatchesTemplate(int matchesTemplate) {
        this.matchesTemplate = matchesTemplate;
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
