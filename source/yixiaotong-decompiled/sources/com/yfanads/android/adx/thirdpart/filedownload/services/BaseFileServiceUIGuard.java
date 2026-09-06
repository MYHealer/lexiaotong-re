package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloadEventPool;
import com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy;
import com.yfanads.android.adx.thirdpart.filedownload.event.DownloadServiceConnectChangedEvent;
import com.yfanads.android.adx.thirdpart.filedownload.util.ExtraKeys;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseFileServiceUIGuard<CALLBACK extends Binder, INTERFACE extends IInterface> implements IFileDownloadServiceProxy, ServiceConnection {
    private volatile INTERFACE service;
    private final Class<?> serviceClass;
    protected boolean runServiceForeground = false;
    private final HashMap<String, Object> uiCacheMap = new HashMap<>();
    private final List<Context> bindContexts = new ArrayList();
    private final ArrayList<Runnable> connectedRunnableList = new ArrayList<>();
    private final CALLBACK callback = (CALLBACK) createCallback();

    public BaseFileServiceUIGuard(Class<?> cls) {
        this.serviceClass = cls;
    }

    public abstract INTERFACE asInterface(IBinder iBinder);

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void bindStartByContext(Context context) {
        bindStartByContext(context, null);
    }

    public abstract CALLBACK createCallback();

    public CALLBACK getCallback() {
        return this.callback;
    }

    public INTERFACE getService() {
        return this.service;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isConnected() {
        return getService() != null;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isRunServiceForeground() {
        return this.runServiceForeground;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.service = (INTERFACE) asInterface(iBinder);
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "onServiceConnected %s %s", componentName, this.service);
        }
        try {
            registerCallback(this.service, this.callback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List list = (List) this.connectedRunnableList.clone();
        this.connectedRunnableList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        FileDownloadEventPool.getImpl().asyncPublishInNewThread(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.serviceClass));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "onServiceDisconnected %s %s", componentName, this.service);
        }
        releaseConnect(true);
    }

    public Object popCache(String str) {
        return this.uiCacheMap.remove(str);
    }

    public String putCache(Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        this.uiCacheMap.put(string, obj);
        return string;
    }

    public abstract void registerCallback(INTERFACE r1, CALLBACK callback) throws RemoteException;

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void unbindByContext(Context context) {
        if (this.bindContexts.contains(context)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "unbindByContext %s", context);
            }
            this.bindContexts.remove(context);
            if (this.bindContexts.isEmpty()) {
                releaseConnect(false);
            }
            Intent intent = new Intent(context, this.serviceClass);
            context.unbindService(this);
            context.stopService(intent);
        }
    }

    public abstract void unregisterCallback(INTERFACE r1, CALLBACK callback) throws RemoteException;

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void bindStartByContext(Context context, Runnable runnable) {
        if (FileDownloadUtils.isDownloaderProcess(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.serviceClass);
        if (runnable != null && !this.connectedRunnableList.contains(runnable)) {
            this.connectedRunnableList.add(runnable);
        }
        if (!this.bindContexts.contains(context)) {
            this.bindContexts.add(context);
        }
        boolean zNeedMakeServiceForeground = FileDownloadUtils.needMakeServiceForeground(context);
        this.runServiceForeground = zNeedMakeServiceForeground;
        intent.putExtra(ExtraKeys.IS_FOREGROUND, zNeedMakeServiceForeground);
        context.bindService(intent, this, 1);
        if (!this.runServiceForeground) {
            context.startService(intent);
            return;
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "start foreground service", new Object[0]);
        }
        context.startForegroundService(intent);
    }

    private void releaseConnect(boolean z) {
        DownloadServiceConnectChangedEvent.ConnectStatus connectStatus;
        if (!z && this.service != null) {
            try {
                unregisterCallback(this.service, this.callback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "release connect resources %s", this.service);
        }
        this.service = null;
        FileDownloadEventPool impl = FileDownloadEventPool.getImpl();
        if (z) {
            connectStatus = DownloadServiceConnectChangedEvent.ConnectStatus.lost;
        } else {
            connectStatus = DownloadServiceConnectChangedEvent.ConnectStatus.disconnected;
        }
        impl.asyncPublishInNewThread(new DownloadServiceConnectChangedEvent(connectStatus, this.serviceClass));
    }
}
