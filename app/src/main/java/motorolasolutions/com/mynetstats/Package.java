package motorolasolutions.com.mynetstats;

public class Package {
    private String name;
    private String packageName;
    private int uid;
    private long dataWifiRx;
    private long dataWifiTx;
    private long dataMobileRx;
    private long dataMobileTx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public long getDataWifiRx() {
        return dataWifiRx;
    }

    public void setDataWifiRx(long dataWifiRx) {
        this.dataWifiRx = dataWifiRx;
    }

    public long getDataWifiTx() {
        return dataWifiTx;
    }

    public void setDataWifiTx(long dataWifiTx) {
        this.dataWifiTx = dataWifiTx;
    }
    public long getDataMobileRx() {
        return dataMobileRx;
    }

    public void setDataMobileRx(long dataMobileRx) {
        this.dataMobileRx = dataMobileRx;
    }

    public long getDataMobileTx() {
        return dataMobileTx;
    }

    public void setDataMobileTx(long dataMobileTx) {
        this.dataMobileTx = dataMobileTx;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", uid=" + uid +
                ", dataWifiRx=" + dataWifiRx +
                ", dataWifiTx=" + dataWifiTx +
                ", dataMobileRx=" + dataMobileRx +
                ", dataMobileTx=" + dataMobileTx +
                '}'+ "\n\n";
    }
}
