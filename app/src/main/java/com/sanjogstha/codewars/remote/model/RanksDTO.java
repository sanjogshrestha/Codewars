package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class RanksDTO {
    @SerializedName("overall")
    @Expose
    private OverallDTO overall;

    public OverallDTO getOverall() {
        return overall;
    }

    public void setOverall(OverallDTO overall) {
        this.overall = overall;
    }
}
