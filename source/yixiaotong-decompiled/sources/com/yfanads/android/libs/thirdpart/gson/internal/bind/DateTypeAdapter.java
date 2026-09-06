package com.yfanads.android.libs.thirdpart.gson.internal.bind;

import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.JsonSyntaxException;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapter;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory;
import com.yfanads.android.libs.thirdpart.gson.internal.JavaVersion;
import com.yfanads.android.libs.thirdpart.gson.internal.PreJava9DateFormatProvider;
import com.yfanads.android.libs.thirdpart.gson.internal.bind.util.ISO8601Utils;
import com.yfanads.android.libs.thirdpart.gson.reflect.TypeToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonReader;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.yfanads.android.libs.thirdpart.gson.internal.bind.DateTypeAdapter.1
        @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> dateFormats;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    private synchronized Date deserializeToDate(String str) {
        Iterator<DateFormat> it = this.dateFormats.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return ISO8601Utils.parse(str, new ParsePosition(0));
        } catch (ParseException e) {
            throw new JsonSyntaxException(str, e);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return deserializeToDate(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public synchronized void write(JsonWriter jsonWriter, Date date) {
        try {
            if (date == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(this.dateFormats.get(0).format(date));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
