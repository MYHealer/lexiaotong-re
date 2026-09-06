package client.android.yixiaotong.util.retrofit.http;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@Target({ElementType.METHOD})
@RestMethod("DELETE")
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DELETE {
    String value();
}
