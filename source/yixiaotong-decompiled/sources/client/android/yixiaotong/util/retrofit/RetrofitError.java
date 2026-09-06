package client.android.yixiaotong.util.retrofit;

import client.android.yixiaotong.util.retrofit.client.Response;
import client.android.yixiaotong.util.retrofit.converter.ConversionException;
import client.android.yixiaotong.util.retrofit.converter.Converter;
import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RetrofitError extends RuntimeException {
    private final Converter converter;
    private final Kind kind;
    private final Response response;
    private final Type successType;
    private final String url;

    public enum Kind {
        NETWORK,
        CONVERSION,
        HTTP,
        UNEXPECTED
    }

    public Kind getKind() {
        return this.kind;
    }

    public Response getResponse() {
        return this.response;
    }

    public Type getSuccessType() {
        return this.successType;
    }

    public String getUrl() {
        return this.url;
    }

    public static RetrofitError networkError(String str, IOException iOException) {
        return new RetrofitError(iOException.getMessage(), str, null, null, null, Kind.NETWORK, iOException);
    }

    public static RetrofitError conversionError(String str, Response response, Converter converter, Type type, ConversionException conversionException) {
        return new RetrofitError(conversionException.getMessage(), str, response, converter, type, Kind.CONVERSION, conversionException);
    }

    public static RetrofitError httpError(String str, Response response, Converter converter, Type type) {
        return new RetrofitError(response.getStatus() + PPSLabelView.Code + response.getReason(), str, response, converter, type, Kind.HTTP, null);
    }

    public static RetrofitError unexpectedError(String str, Throwable th) {
        return new RetrofitError(th.getMessage(), str, null, null, null, Kind.UNEXPECTED, th);
    }

    RetrofitError(String str, String str2, Response response, Converter converter, Type type, Kind kind, Throwable th) {
        super(str, th);
        this.url = str2;
        this.response = response;
        this.converter = converter;
        this.successType = type;
        this.kind = kind;
    }

    @Deprecated
    public boolean isNetworkError() {
        return this.kind == Kind.NETWORK;
    }

    public Object getBody() {
        return getBodyAs(this.successType);
    }

    public Object getBodyAs(Type type) {
        TypedInput body;
        Response response = this.response;
        if (response == null || (body = response.getBody()) == null) {
            return null;
        }
        try {
            return this.converter.fromBody(body, type);
        } catch (ConversionException e) {
            throw new RuntimeException(e);
        }
    }
}
