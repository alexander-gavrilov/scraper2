package scraper;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by gavrilov_a on 07.12.2016.
 */
public class ZoneConverter  implements JsonDeserializer<Zone>{

    @Override
    public Zone deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("descrizione").getAsString();
        String code = jsonObject.get("codice").getAsString();
        return new Zone(name,code);
    }
}
