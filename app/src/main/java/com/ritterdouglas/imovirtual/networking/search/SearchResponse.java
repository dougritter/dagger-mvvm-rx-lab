
package com.ritterdouglas.imovirtual.networking.search;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SearchResponse {

    @SerializedName("expanded_info")
    private ExpandedInfo mExpandedInfo;
    @SerializedName("expanded_location")
    private String mExpandedLocation;
    @SerializedName("expanded_location_string")
    private ExpandedLocationString mExpandedLocationString;
    @SerializedName("limit_per_results")
    private String mLimitPerResults;
    @SerializedName("no_results_changes")
    private Object mNoResultsChanges;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("total_results")
    private String mTotalResults;

    public ExpandedInfo getExpandedInfo() {
        return mExpandedInfo;
    }

    public void setExpandedInfo(ExpandedInfo expanded_info) {
        mExpandedInfo = expanded_info;
    }

    public String getExpandedLocation() {
        return mExpandedLocation;
    }

    public void setExpandedLocation(String expanded_location) {
        mExpandedLocation = expanded_location;
    }

    public ExpandedLocationString getExpandedLocationString() {
        return mExpandedLocationString;
    }

    public void setExpandedLocationString(ExpandedLocationString expanded_location_string) {
        mExpandedLocationString = expanded_location_string;
    }

    public String getLimitPerResults() {
        return mLimitPerResults;
    }

    public void setLimitPerResults(String limit_per_results) {
        mLimitPerResults = limit_per_results;
    }

    public Object getNoResultsChanges() {
        return mNoResultsChanges;
    }

    public void setNoResultsChanges(Object no_results_changes) {
        mNoResultsChanges = no_results_changes;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    public String getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(String total_results) {
        mTotalResults = total_results;
    }

}
