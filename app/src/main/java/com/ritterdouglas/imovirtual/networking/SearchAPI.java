package com.ritterdouglas.imovirtual.networking;

import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;
import com.ritterdouglas.imovirtual.networking.search.SearchResponse;

import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface SearchAPI {

    String LOCATION = "location";
    String TYPE = "type";
    String CAT = "cat";
    String SIZE_TO = "size_to";
    String PRICE_FROM = "price_from";
    String PRICE_TO = "price_to";
    String WIDTH = "width";
    String HEIGHT = "height";
    String LANG = "lang";
    String C = "c";
    String SEARCH_PAGE = "search_page";

    @POST(NetworkingConstants.DEVICE_REGISTER + NetworkingConstants.MOCKED_QUERY_STRING)
    Observable<Response<RegisterDeviceResponse>> registerDevice();

    @POST(NetworkingConstants.SEARCH)
    Observable<Response<SearchResponse>> search(@Query(LOCATION) String location, @Query(SEARCH_PAGE) String searchPage, @Query(TYPE) String type, @Query(CAT) String cat, @Query(SIZE_TO) String sizeTo,
                                                @Query(PRICE_FROM) String priceFrom, @Query(PRICE_TO) String priceTo, @Query(WIDTH) String width, @Query(HEIGHT) String height,
                                                @Query(LANG) String lang, @Query(C) String c);


}
