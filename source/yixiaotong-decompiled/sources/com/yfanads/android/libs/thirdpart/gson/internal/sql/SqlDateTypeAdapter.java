package com.yfanads.android.libs.thirdpart.gson.internal.sql;

import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.JsonSyntaxException;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapter;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory;
import com.yfanads.android.libs.thirdpart.gson.reflect.TypeToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonReader;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.yfanads.android.libs.thirdpart.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format;

    private SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public synchronized Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.format.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public synchronized void write(JsonWriter jsonWriter, Date date) {
        jsonWriter.value(date == null ? null : this.format.format((java.util.Date) date));
    }
}
