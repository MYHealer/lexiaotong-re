package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import com.hihonor.secure.android.common.ssl.SecureX509SingleInstance;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends AsyncTask<Context, Integer, InputStream> {
    private static final String TAG = "d";

    protected InputStream a(Context... contextArr) {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            g.e(TAG, "doInBackground: exception : " + e.getMessage());
            bksFromTss = null;
        }
        g.b(TAG, "doInBackground: get bks from Core tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return bksFromTss;
    }

    protected void b(InputStream inputStream) {
        String str = TAG;
        g.b(str, "onPostExecute: current thread name is : " + Thread.currentThread().getName());
        if (inputStream == null) {
            g.e(str, "get bks from tss error , result is null");
        } else {
            SecureX509SingleInstance.updateBks(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public InputStream doInBackground(Context... contextArr) {
        return a(contextArr);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        g.b(TAG, "onPreExecute: current thread name is : " + Thread.currentThread().getName());
    }

    protected void a(Integer... numArr) {
        g.c(TAG, "onProgressUpdate: current thread name is : " + Thread.currentThread().getName());
    }
}
