package org.leanpoker.player.rainman;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface RainmanApi {

    @POST("/rank")
    @FormUrlEncoded
    RainmanResponse getRank(@Field("cards") String cards);

}
