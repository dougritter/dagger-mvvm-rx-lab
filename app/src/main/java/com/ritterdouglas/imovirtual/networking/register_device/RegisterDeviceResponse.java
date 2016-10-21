
package com.ritterdouglas.imovirtual.networking.register_device;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RegisterDeviceResponse {

    @SerializedName("device_info")
    private DeviceInfo mDeviceInfo;
    @SerializedName("response")
    private String mResponse;
    @SerializedName("status")
    private String mStatus;

    public DeviceInfo getDeviceInfo() {
        return mDeviceInfo;
    }

    public void setDeviceInfo(DeviceInfo device_info) {
        mDeviceInfo = device_info;
    }

    public String getResponse() {
        return mResponse;
    }

    public void setResponse(String response) {
        mResponse = response;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
