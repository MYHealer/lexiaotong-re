package com.yfanads.android.libs.thirdpart.gson.internal.bind;

import com.yfanads.android.libs.thirdpart.gson.JsonSyntaxException;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapter;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory;
import com.yfanads.android.libs.thirdpart.gson.internal.C$Gson$Preconditions;
import com.yfanads.android.libs.thirdpart.gson.internal.JavaVersion;
import com.yfanads.android.libs.thirdpart.gson.internal.PreJava9DateFormatProvider;
import com.yfanads.android.libs.thirdpart.gson.internal.bind.util.ISO8601Utils;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonReader;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.gson.internal.bind.DefaultDateTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<Date>(Date.class) { // from class: com.yfanads.android.libs.thirdpart.gson.internal.bind.DefaultDateTypeAdapter.DateType.1
            @Override // com.yfanads.android.libs.thirdpart.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public Date deserialize(Date date) {
                return date;
            }
        };
        private final Class<T> dateClass;

        public DateType(Class<T> cls) {
            this.dateClass = cls;
        }

        private final TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory createAdapterFactory(int i) {
            return createFactory(new DefaultDateTypeAdapter<>(this, i, (AnonymousClass1) null));
        }

        public final TypeAdapterFactory createAdapterFactory(int i, int i2) {
            return createFactory(new DefaultDateTypeAdapter<>(this, i, i2, null));
        }

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return createFactory(new DefaultDateTypeAdapter<>(this, str, (AnonymousClass1) null));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            int i = 2;
            return createFactory(new DefaultDateTypeAdapter<>(this, i, i, null));
        }

        public abstract T deserialize(Date date);
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int i) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, int i, int i2, AnonymousClass1 anonymousClass1) {
        this(dateType, i, i2);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, int i, AnonymousClass1 anonymousClass1) {
        this(dateType, i);
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) C$Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, String str, AnonymousClass1 anonymousClass1) {
        this(dateType, str);
    }

    private Date deserializeToDate(String str) {
        synchronized (this.dateFormats) {
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
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return (T) this.dateType.deserialize(deserializeToDate(jsonReader.nextString()));
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        return sb.append(simpleName).append(')').toString();
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(this.dateFormats.get(0).format(date));
        }
    }
}
