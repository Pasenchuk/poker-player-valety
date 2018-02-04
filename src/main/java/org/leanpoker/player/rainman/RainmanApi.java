package org.leanpoker.player.rainman;

import org.leanpoker.player.models.HoleCard;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import java.util.List;

public interface RainmanApi {

    @POST("/rank")
    @FormUrlEncoded
    RainmanResponse getRank(@Field("cards") String cards);

}
