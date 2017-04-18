package com.nutmeg.wikipedia.api.service.deserialiser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.image.Thumbnail;

import java.lang.reflect.Type;
import java.util.Map;

public class ImageResultDeserialiser implements JsonDeserializer<ImageResult> {

    @Override
    public ImageResult deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
        JsonElement jsonElement = getNextJsonElement(json);

        if (jsonElement == null) {
            return null;
        }

        return getImageResult(jsonElement.getAsJsonObject(), context);
    }

    private JsonElement getNextJsonElement(JsonElement parent) {
        if (parent == null || !parent.isJsonObject()) {
            return null;
        } else {
            for (Map.Entry<String, JsonElement> next : parent.getAsJsonObject().entrySet()) {
                if ("pageid".equals(next.getKey())) {
                    return parent;
                }
            }
            return getNextJsonElement(pop(parent));
        }
    }

    private JsonElement pop(JsonElement json) {
        if (!json.isJsonObject()) {
            return null;
        }

        JsonObject jsonObject = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            final JsonElement value = entry.getValue();
            if (value.isJsonObject()) {
                return value;
            }
        }
        return null;
    }

    private ImageResult getImageResult(JsonObject jsonObject,
                                       JsonDeserializationContext context) {
        ImageResult imageResult = new ImageResult();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            if (value != null) {
                switch (entry.getKey()) {
                    case "pageid":
                        imageResult.setPageId(value.getAsInt());
                        break;

                    case "title":
                        imageResult.setTitle(value.getAsString());
                        break;

                    case "thumbnail":
                        imageResult.setThumbnail(context.<Thumbnail>deserialize(value,
                                Thumbnail.class));
                        break;
                }
            }
        }
        return imageResult;
    }
}
