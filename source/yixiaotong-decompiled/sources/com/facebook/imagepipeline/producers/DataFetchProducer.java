package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DataFetchProducer extends LocalFetchProducer {
    private static final String PRODUCER_NAME = "DataFetchProducer";

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, boolean z) {
        super(CallerThreadExecutor.getInstance(), pooledByteBufferFactory, z);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        byte[] data = getData(imageRequest.getSourceUri().toString());
        return getByteBufferBackedEncodedImage(new ByteArrayInputStream(data), data.length);
    }

    static byte[] getData(String str) {
        Preconditions.checkArgument(str.substring(0, 5).equals("data:"));
        int iIndexOf = str.indexOf(44);
        String strSubstring = str.substring(iIndexOf + 1, str.length());
        if (isBase64(str.substring(0, iIndexOf))) {
            return Base64.decode(strSubstring, 0);
        }
        return Uri.decode(strSubstring).getBytes();
    }

    static boolean isBase64(String str) {
        if (!str.contains(";")) {
            return false;
        }
        String[] strArrSplit = str.split(";");
        return strArrSplit[strArrSplit.length - 1].equals("base64");
    }
}
