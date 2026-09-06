package com.hihonor.adsdk.base.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends CallAdapter.Factory {

    public class a<R> implements CallAdapter<ApiResult<R>, com.hihonor.adsdk.base.net.a<R>> {
        private final Type hnadsa;
        private final Annotation[] hnadsb;

        a(Type type, Annotation[] annotationArr) {
            this.hnadsa = type;
            this.hnadsb = annotationArr;
        }

        @Override // retrofit2.CallAdapter
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public com.hihonor.adsdk.base.net.a<R> adapt(Call<ApiResult<R>> call) {
            return new com.hihonor.adsdk.base.net.a<>(call);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return new l(new Type[]{this.hnadsa}, null, ApiResult.class);
        }
    }

    private b() {
    }

    public static b hnadsa() {
        return new b();
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != com.hihonor.adsdk.base.net.a.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
