package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@Retention(RetentionPolicy.CLASS)
public @interface Update {
    Class<?> entity() default Object.class;

    int onConflict() default 3;
}
