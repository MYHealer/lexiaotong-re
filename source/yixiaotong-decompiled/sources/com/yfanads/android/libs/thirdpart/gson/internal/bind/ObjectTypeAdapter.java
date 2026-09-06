package com.yfanads.android.libs.thirdpart.gson.internal.bind;

import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.ToNumberPolicy;
import com.yfanads.android.libs.thirdpart.gson.ToNumberStrategy;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapter;
import com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory;
import com.yfanads.android.libs.thirdpart.gson.internal.LinkedTreeMap;
import com.yfanads.android.libs.thirdpart.gson.reflect.TypeToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonReader;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonToken;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.gson = gson;
        this.toNumberStrategy = toNumberStrategy;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        return toNumberStrategy == ToNumberPolicy.DOUBLE ? DOUBLE_FACTORY : newFactory(toNumberStrategy);
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() { // from class: com.yfanads.android.libs.thirdpart.gson.internal.bind.ObjectTypeAdapter.1
            @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Object.class) {
                    return new ObjectTypeAdapter(gson, toNumberStrategy);
                }
                return null;
            }
        };
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        switch (AnonymousClass2.$SwitchMap$com$yfanads$android$libs$thirdpart$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return this.toNumberStrategy.readNumber(jsonReader);
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(jsonWriter, obj);
        } else {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
    }
}
