package client.android.yixiaotong.sdk.runnable.ble;

import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LogWriter {
    private static SimpleDateFormat df;
    private static LogWriter mLogWriter;
    private static String mPath;
    private static Writer mWriter;

    private LogWriter(String str) {
        mPath = str;
        mWriter = null;
    }

    public static LogWriter open(String str) throws IOException {
        if (mLogWriter == null) {
            mLogWriter = new LogWriter(str);
        }
        new File(mPath);
        mWriter = new BufferedWriter(new FileWriter(mPath), 2048);
        df = new SimpleDateFormat("[yy-MM-dd hh:mm:ss]: ");
        return mLogWriter;
    }

    public void close() throws IOException {
        mWriter.close();
    }

    public void print(String str) throws IOException {
        mWriter.write(df.format(new Date()));
        mWriter.write(str);
        mWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        mWriter.flush();
    }

    public void print(Class cls, String str) throws IOException {
        mWriter.write(df.format(new Date()));
        mWriter.write(cls.getSimpleName() + PPSLabelView.Code);
        mWriter.write(str);
        mWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        mWriter.flush();
    }
}
