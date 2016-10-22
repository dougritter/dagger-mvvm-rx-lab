package com.ritterdouglas.imovirtual.networking;

import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface SearchAPI {

    @POST(NetworkingConstants.DEVICE_REGISTER + NetworkingConstants.MOCKED_QUERY_STRING)
    Observable<Response<RegisterDeviceResponse>> registerDevice();

}
