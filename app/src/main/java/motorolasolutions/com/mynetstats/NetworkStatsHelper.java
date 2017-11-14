package motorolasolutions.com.mynetstats;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.RemoteException;
import android.telephony.TelephonyManager;

@TargetApi(Build.VERSION_CODES.M)
public class NetworkStatsHelper {

    private NetworkStatsManager networkStatsManager;
    private int packageUid;

    NetworkStatsHelper(NetworkStatsManager networkStatsManager, int packageUid) {
        this.networkStatsManager = networkStatsManager;
        this.packageUid = packageUid;
    }

    public long getAllRxBytesMobile(Context context, long timeInterval) {
        NetworkStats.Bucket bucket;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            bucket = networkStatsManager.querySummaryForDevice(ConnectivityManager.TYPE_MOBILE,
                    getSubscriberId(context, ConnectivityManager.TYPE_MOBILE),
                    startTime,
                    endTime);
        } catch (RemoteException e) {
            return -1;
        }
        return bucket.getRxBytes();
    }

    public long getAllTxBytesMobile(Context context, long timeInterval) {
        NetworkStats.Bucket bucket;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            bucket = networkStatsManager.querySummaryForDevice(ConnectivityManager.TYPE_MOBILE,
                    getSubscriberId(context, ConnectivityManager.TYPE_MOBILE),
                    startTime,
                    endTime);
        } catch (RemoteException e) {
            return -1;
        }
        return bucket.getTxBytes();
    }

    public long getAllRxBytesWifi(long timeInterval) {
        NetworkStats.Bucket bucket;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            bucket = networkStatsManager.querySummaryForDevice(ConnectivityManager.TYPE_WIFI,
                    "",
                    startTime,
                    endTime);
        } catch (RemoteException e) {
            return -1;
        }
        return bucket.getRxBytes();
    }

    public long getAllTxBytesWifi(long timeInterval) {
        NetworkStats.Bucket bucket;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            bucket = networkStatsManager.querySummaryForDevice(ConnectivityManager.TYPE_WIFI,
                    "",
                    startTime,
                    endTime);
        } catch (RemoteException e) {
            return -1;
        }
        return bucket.getTxBytes();
    }

    long getPackageRxBytesMobile(Context context, long timeInterval) {
        NetworkStats networkStats;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            networkStats = networkStatsManager.queryDetailsForUid(
                    ConnectivityManager.TYPE_MOBILE,
                    getSubscriberId(context, ConnectivityManager.TYPE_MOBILE),
                    startTime,
                    endTime,
                    packageUid);
        } catch (RemoteException e) {
            return -1;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        networkStats.getNextBucket(bucket);
        networkStats.getNextBucket(bucket);
        return bucket.getRxBytes();
    }

    long getPackageTxBytesMobile(Context context, long timeInterval) {
        NetworkStats networkStats;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            networkStats = networkStatsManager.queryDetailsForUid(
                    ConnectivityManager.TYPE_MOBILE,
                    getSubscriberId(context, ConnectivityManager.TYPE_MOBILE),
                    startTime,
                    endTime,
                    packageUid);
        } catch (RemoteException e) {
            return -1;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        networkStats.getNextBucket(bucket);
        return bucket.getTxBytes();
    }

    long getPackageRxBytesWifi(long timeInterval) {
        NetworkStats networkStats;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            networkStats = networkStatsManager.queryDetailsForUid(
                    ConnectivityManager.TYPE_WIFI,
                    "",
                    startTime,
                    endTime,
                    packageUid);
        } catch (RemoteException e) {
            return -1;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        networkStats.getNextBucket(bucket);
        return bucket.getRxBytes();
    }

    long getPackageTxBytesWifi(long timeInterval) {
        NetworkStats networkStats;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - timeInterval;
        try {
            networkStats = networkStatsManager.queryDetailsForUid(
                    ConnectivityManager.TYPE_WIFI,
                    "",
                    startTime,
                    endTime,
                    packageUid);
        } catch (RemoteException e) {
            return -1;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        networkStats.getNextBucket(bucket);
        return bucket.getTxBytes();
    }

    private String getSubscriberId(Context context, int networkType) {
        if (ConnectivityManager.TYPE_MOBILE == networkType) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getSubscriberId();
        }
        return "";
    }
}
