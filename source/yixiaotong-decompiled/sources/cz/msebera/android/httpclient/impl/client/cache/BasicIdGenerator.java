package cz.msebera.android.httpclient.impl.client.cache;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class BasicIdGenerator {
    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            hostName = "localhost";
        }
        this.hostname = hostName;
        try {
            this.rnd = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }

    public synchronized void generate(StringBuilder sb) {
        this.count++;
        int iNextInt = this.rnd.nextInt();
        sb.append(System.currentTimeMillis());
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        Formatter formatter = new Formatter(sb, Locale.US);
        formatter.format("%1$016x-%2$08x", Long.valueOf(this.count), Integer.valueOf(iNextInt));
        formatter.close();
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.hostname);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        generate(sb);
        return sb.toString();
    }
}
