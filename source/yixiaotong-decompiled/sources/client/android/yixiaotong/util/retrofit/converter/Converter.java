package client.android.yixiaotong.util.retrofit.converter;

import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import client.android.yixiaotong.util.retrofit.mime.TypedOutput;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface Converter {
    Object fromBody(TypedInput typedInput, Type type) throws ConversionException;

    Object fromBody(TypedInput typedInput, Type type, String str) throws ConversionException;

    TypedOutput toBody(Object obj);
}
