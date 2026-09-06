package com.huawei.hms.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ed {
    private static final FloatBuffer B;
    private static final float[] I;
    private static final float[] V;
    private static final FloatBuffer Z;
    private final FloatBuffer C = Z;
    private final FloatBuffer S = B;
    private final int F = 2;
    private final int D = V.length / 2;

    static {
        float[] fArr = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        V = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        I = fArr2;
        Z = Code(fArr);
        B = Code(fArr2);
    }

    private static FloatBuffer Code(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    int B() {
        return 8;
    }

    int C() {
        return 2;
    }

    FloatBuffer Code() {
        return this.C;
    }

    int I() {
        return this.D;
    }

    FloatBuffer V() {
        return this.S;
    }

    int Z() {
        return 8;
    }
}
