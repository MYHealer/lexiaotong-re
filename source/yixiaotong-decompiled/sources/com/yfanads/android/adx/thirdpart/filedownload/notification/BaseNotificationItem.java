package com.yfanads.android.adx.thirdpart.filedownload.notification;

import android.app.NotificationManager;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseNotificationItem {
    private String desc;
    private int id;
    private NotificationManager manager;
    private int sofar;
    private String title;
    private int total;
    private int status = 0;
    private int lastStatus = 0;

    public BaseNotificationItem(int i, String str, String str2) {
        this.id = i;
        this.title = str;
        this.desc = str2;
    }

    public void cancel() {
        getManager().cancel(this.id);
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.id;
    }

    public int getLastStatus() {
        return this.lastStatus;
    }

    public int getSofar() {
        return this.sofar;
    }

    public int getStatus() {
        int i = this.status;
        this.lastStatus = i;
        return i;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isChanged() {
        return this.lastStatus != this.status;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setSofar(int i) {
        this.sofar = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public void show(boolean z) {
        show(isChanged(), getStatus(), z);
    }

    public abstract void show(boolean z, int i, boolean z2);

    public void updateStatus(int i) {
        this.status = i;
    }

    public NotificationManager getManager() {
        if (this.manager == null) {
            this.manager = (NotificationManager) FileDownloadHelper.getAppContext().getSystemService("notification");
        }
        return this.manager;
    }

    public void update(int i, int i2) {
        this.sofar = i;
        this.total = i2;
        show(true);
    }
}
