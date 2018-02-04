package org.leanpoker.player.rainman;

import com.google.gson.Gson;
import org.leanpoker.player.models.HoleCard;
import retrofit.RestAdapter;

import java.util.List;

public class RainmanUtils {

    private static Gson gson = new Gson();

    private static RainmanApi rainmanApi = new RestAdapter.Builder()
            .setEndpoint("http://rainman.leanpoker.org")
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build()
            .create(RainmanApi.class);

    public static RainmanResponse getRank(List<HoleCard> cards) {
        return rainmanApi.getRank(gson.toJson(cards));
    }


}
