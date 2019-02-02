
package ir.jalambadani.openalpr.alpr.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "processing_time",
    "img_width",
    "img_height",
    "credit_cost",
    "credits_monthly_used",
    "credits_monthly_total",
    "results",
    "regions_of_interest",
    "epoch_time",
    "version",
    "data_type"
})
public class AlprResponse {

    @JsonProperty("processing_time")
    private ProcessingTime processingTime;
    @JsonProperty("img_width")
    private int imgWidth;
    @JsonProperty("img_height")
    private int imgHeight;
    @JsonProperty("credit_cost")
    private int creditCost;
    @JsonProperty("credits_monthly_used")
    private int creditsMonthlyUsed;
    @JsonProperty("credits_monthly_total")
    private int creditsMonthlyTotal;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("regions_of_interest")
    private List<RegionsOfInterest> regionsOfInterest = null;
    @JsonProperty("epoch_time")
    private long epochTime;
    @JsonProperty("version")
    private int version;
    @JsonProperty("data_type")
    private String dataType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("processing_time")
    public ProcessingTime getProcessingTime() {
        return processingTime;
    }

    @JsonProperty("processing_time")
    public void setProcessingTime(ProcessingTime processingTime) {
        this.processingTime = processingTime;
    }

    @JsonProperty("img_width")
    public int getImgWidth() {
        return imgWidth;
    }

    @JsonProperty("img_width")
    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    @JsonProperty("img_height")
    public int getImgHeight() {
        return imgHeight;
    }

    @JsonProperty("img_height")
    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    @JsonProperty("credit_cost")
    public int getCreditCost() {
        return creditCost;
    }

    @JsonProperty("credit_cost")
    public void setCreditCost(int creditCost) {
        this.creditCost = creditCost;
    }

    @JsonProperty("credits_monthly_used")
    public int getCreditsMonthlyUsed() {
        return creditsMonthlyUsed;
    }

    @JsonProperty("credits_monthly_used")
    public void setCreditsMonthlyUsed(int creditsMonthlyUsed) {
        this.creditsMonthlyUsed = creditsMonthlyUsed;
    }

    @JsonProperty("credits_monthly_total")
    public int getCreditsMonthlyTotal() {
        return creditsMonthlyTotal;
    }

    @JsonProperty("credits_monthly_total")
    public void setCreditsMonthlyTotal(int creditsMonthlyTotal) {
        this.creditsMonthlyTotal = creditsMonthlyTotal;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("regions_of_interest")
    public List<RegionsOfInterest> getRegionsOfInterest() {
        return regionsOfInterest;
    }

    @JsonProperty("regions_of_interest")
    public void setRegionsOfInterest(List<RegionsOfInterest> regionsOfInterest) {
        this.regionsOfInterest = regionsOfInterest;
    }

    @JsonProperty("epoch_time")
    public long getEpochTime() {
        return epochTime;
    }

    @JsonProperty("epoch_time")
    public void setEpochTime(long epochTime) {
        this.epochTime = epochTime;
    }

    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(int version) {
        this.version = version;
    }

    @JsonProperty("data_type")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("data_type")
    public void setDataType(String dataType) {
        this.dataType = dataType;
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
