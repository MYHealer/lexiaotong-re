package client.android.yixiaotong.util.retrofit.converter;

import android.text.TextUtils;
import client.android.yixiaotong.util.retrofit.mime.MimeUtil;
import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import client.android.yixiaotong.util.retrofit.mime.TypedOutput;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GsonConverter implements Converter {
    private String charset;
    private final Gson gson;

    public GsonConverter(Gson gson) {
        this(gson, "UTF-8");
    }

    public GsonConverter(Gson gson, String str) {
        this.gson = gson;
        this.charset = str;
    }

    @Override // client.android.yixiaotong.util.retrofit.converter.Converter
    public Object fromBody(TypedInput typedInput, Type type) throws Throwable {
        String charset = this.charset;
        if (typedInput.mimeType() != null) {
            charset = MimeUtil.parseCharset(typedInput.mimeType(), charset);
        }
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(typedInput.in(), charset);
                try {
                    List<String> lines = IOUtils.readLines(inputStreamReader2);
                    StringBuilder sb = new StringBuilder();
                    if (lines != null) {
                        Iterator<String> it = lines.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                        }
                    }
                    String string = sb.toString();
                    if (string.contains("code") && string.contains("data") && string.contains(CrashHianalyticsData.MESSAGE)) {
                        JsonObject asJsonObject = new JsonParser().parse(string).getAsJsonObject();
                        if (TextUtils.isEmpty(asJsonObject.get("data").toString()) || asJsonObject.get("data").toString().equals("\"\"") || asJsonObject.get("data").toString().equals("{}") || asJsonObject.get("data").toString().equals("[{}]")) {
                            asJsonObject.remove("data");
                        }
                        Object objFromJson = this.gson.fromJson(asJsonObject, type);
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused) {
                        }
                        return objFromJson;
                    }
                    if (string.contains("serial") && string.contains("code") && string.contains("data") && string.contains(CrashHianalyticsData.MESSAGE)) {
                        JsonObject asJsonObject2 = new JsonParser().parse(string).getAsJsonObject();
                        if (TextUtils.isEmpty(asJsonObject2.get("data").toString()) || asJsonObject2.get("data").toString().equals("\"\"") || asJsonObject2.get("data").toString().equals("{}") || asJsonObject2.get("data").toString().equals("[{}]")) {
                            asJsonObject2.remove("data");
                        }
                        Object objFromJson2 = this.gson.fromJson(asJsonObject2, type);
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused2) {
                        }
                        return objFromJson2;
                    }
                    JsonObject asJsonObject3 = new JsonParser().parse(string).getAsJsonObject();
                    if (!string.contains("Data")) {
                        asJsonObject3.addProperty("Data", "");
                    }
                    if (TextUtils.isEmpty(asJsonObject3.get("Data").toString()) || asJsonObject3.get("Data").toString().equals("\"\"") || asJsonObject3.get("Data").toString().equals("[{}]")) {
                        asJsonObject3.remove("Data");
                    }
                    if (string.contains("goWhite")) {
                        asJsonObject3.addProperty(CrashHianalyticsData.MESSAGE, "");
                        asJsonObject3.addProperty("code", (Number) 0);
                    }
                    LogUtil.d("GsonConverter", "result:" + string + "  " + asJsonObject3.toString());
                    Object objFromJson3 = this.gson.fromJson(asJsonObject3, type);
                    try {
                        inputStreamReader2.close();
                    } catch (IOException unused3) {
                    }
                    return objFromJson3;
                } catch (JsonParseException e) {
                    e = e;
                    throw new ConversionException(e);
                } catch (IOException e2) {
                    e = e2;
                    throw new ConversionException(e);
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader = inputStreamReader2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (JsonParseException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    @Override // client.android.yixiaotong.util.retrofit.converter.Converter
    public Object fromBody(TypedInput typedInput, Type type, String str) throws Throwable {
        String charset = this.charset;
        if (typedInput.mimeType() != null) {
            charset = MimeUtil.parseCharset(typedInput.mimeType(), charset);
        }
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(typedInput.in(), charset);
                try {
                    List<String> lines = IOUtils.readLines(inputStreamReader2);
                    StringBuilder sb = new StringBuilder();
                    if (lines != null) {
                        Iterator<String> it = lines.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                        }
                    }
                    String string = sb.toString();
                    if (string.contains("serial") && string.contains("code") && string.contains("data") && string.contains(CrashHianalyticsData.MESSAGE)) {
                        JsonObject asJsonObject = new JsonParser().parse(string).getAsJsonObject();
                        if (TextUtils.isEmpty(asJsonObject.get("data").toString()) || asJsonObject.get("data").toString().equals("\"\"") || asJsonObject.get("data").toString().equals("{}") || asJsonObject.get("data").toString().equals("[{}]")) {
                            asJsonObject.remove("data");
                        }
                        Object objFromJson = this.gson.fromJson(asJsonObject, type);
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused) {
                        }
                        return objFromJson;
                    }
                    JsonObject asJsonObject2 = new JsonParser().parse(string).getAsJsonObject();
                    asJsonObject2.addProperty("TokenInfo", str);
                    LogUtil.d("GsonConverterlogin", "result:" + string + "  " + str);
                    Object objFromJson2 = this.gson.fromJson(asJsonObject2, type);
                    try {
                        inputStreamReader2.close();
                    } catch (IOException unused2) {
                    }
                    return objFromJson2;
                } catch (JsonParseException e) {
                    e = e;
                    throw new ConversionException(e);
                } catch (IOException e2) {
                    e = e2;
                    throw new ConversionException(e);
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader = inputStreamReader2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (JsonParseException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    @Override // client.android.yixiaotong.util.retrofit.converter.Converter
    public TypedOutput toBody(Object obj) {
        try {
            return new JsonTypedOutput(this.gson.toJson(obj).getBytes(this.charset), this.charset);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
        public String fileName() {
            return null;
        }

        @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        JsonTypedOutput(byte[] bArr, String str) {
            this.jsonBytes = bArr;
            this.mimeType = "application/json; charset=" + str;
        }

        @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
        public long length() {
            return this.jsonBytes.length;
        }

        @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.jsonBytes);
        }
    }
}
