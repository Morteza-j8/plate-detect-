
package ir.jalambadani.openalpr.alpr.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plate",
    "matches_template",
    "requested_topn",
    "processing_time_ms",
    "confidence",
    "region",
    "region_confidence",
    "coordinates",
    "candidates",
    "vehicle_region",
    "vehicle"
})
public class Result {

    @JsonProperty("plate")
    private String plate;
    @JsonProperty("matches_template")
    private int matchesTemplate;
    @JsonProperty("requested_topn")
    private int requestedTopn;
    @JsonProperty("processing_time_ms")
    private int processingTimeMs;
    @JsonProperty("confidence")
    private int confidence;
    @JsonProperty("region")
    private String region;
    @JsonProperty("region_confidence")
    private int regionConfidence;
    @JsonProperty("coordinates")
    private List<Coordinate> coordinates = null;
    @JsonProperty("candidates")
    private List<Candidate> candidates = null;
    @JsonProperty("vehicle_region")
    private VehicleRegion vehicleRegion;
    @JsonProperty("vehicle")
    private Vehicle vehicle;
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

    @JsonProperty("matches_template")
    public int getMatchesTemplate() {
        return matchesTemplate;
    }

    @JsonProperty("matches_template")
    public void setMatchesTemplate(int matchesTemplate) {
        this.matchesTemplate = matchesTemplate;
    }

    @JsonProperty("requested_topn")
    public int getRequestedTopn() {
        return requestedTopn;
    }

    @JsonProperty("requested_topn")
    public void setRequestedTopn(int requestedTopn) {
        this.requestedTopn = requestedTopn;
    }

    @JsonProperty("processing_time_ms")
    public int getProcessingTimeMs() {
        return processingTimeMs;
    }

    @JsonProperty("processing_time_ms")
    public void setProcessingTimeMs(int processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    @JsonProperty("confidence")
    public int getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("region_confidence")
    public int getRegionConfidence() {
        return regionConfidence;
    }

    @JsonProperty("region_confidence")
    public void setRegionConfidence(int regionConfidence) {
        this.regionConfidence = regionConfidence;
    }

    @JsonProperty("coordinates")
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("candidates")
    public List<Candidate> getCandidates() {
        return candidates;
    }

    @JsonProperty("candidates")
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @JsonProperty("vehicle_region")
    public VehicleRegion getVehicleRegion() {
        return vehicleRegion;
    }

    @JsonProperty("vehicle_region")
    public void setVehicleRegion(VehicleRegion vehicleRegion) {
        this.vehicleRegion = vehicleRegion;
    }

    @JsonProperty("vehicle")
    public Vehicle getVehicle() {
        return vehicle;
    }

    @JsonProperty("vehicle")
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
