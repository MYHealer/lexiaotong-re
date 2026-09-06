package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.content.Intent;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadBroadcastHandler {
    public static final String ACTION_COMPLETED = "filedownloader.intent.action.completed";
    public static final String KEY_MODEL = "model";

    public static FileDownloadModel parseIntent(Intent intent) {
        if (ACTION_COMPLETED.equals(intent.getAction())) {
            return (FileDownloadModel) intent.getParcelableExtra("model");
        }
        throw new IllegalArgumentException(FileDownloadUtils.formatString("can't recognize the intent with action %s, on the current version we only support action [%s]", intent.getAction(), ACTION_COMPLETED));
    }

    public static void sendCompletedBroadcast(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            throw new IllegalArgumentException();
        }
        if (fileDownloadModel.getStatus() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent(ACTION_COMPLETED);
        intent.putExtra("model", fileDownloadModel);
        FileDownloadHelper.getAppContext().sendBroadcast(intent);
    }
}
