
package com.ritterdouglas.imovirtual.networking.register_device;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DeviceInfo {

    @SerializedName("agent")
    private String mAgent;
    @SerializedName("app")
    private App mApp;
    @SerializedName("manufacturer")
    private String mManufacturer;
    @SerializedName("model")
    private String mModel;
    @SerializedName("os")
    private Os mOs;
    @SerializedName("user_agent")
    private String mUserAgent;

    public String getAgent() {
        return mAgent;
    }

    public void setAgent(String agent) {
        mAgent = agent;
    }

    public App getApp() {
        return mApp;
    }

    public void setApp(App app) {
        mApp = app;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public Os getOs() {
        return mOs;
    }

    public void setOs(Os os) {
        mOs = os;
    }

    public String getUserAgent() {
        return mUserAgent;
    }

    public void setUserAgent(String user_agent) {
        mUserAgent = user_agent;
    }

}
