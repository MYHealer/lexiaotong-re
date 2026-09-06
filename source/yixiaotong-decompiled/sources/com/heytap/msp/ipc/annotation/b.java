package com.heytap.msp.ipc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    IPCType a() default IPCType.UNKNOWN;

    String b() default "";

    String c() default "";

    String[] d() default {};

    String e() default "com.heytap.htms";
}
