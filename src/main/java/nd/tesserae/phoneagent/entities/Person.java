package nd.tesserae.phoneagent.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dscottnull on 7/17/18.
 */

@Entity
@Table(name = "person")
public class Person {
    @Id
    private String uid;             // tess9601
    private String hashedPass;      //
    private String appVersion;      // 3.40
    private String bundleId;        // tesserae.phoneagent
    private String systemVersion;   // 11.3.1
    private String deviceInfo;      // iPhone10,1
    private String pushToken;       // 36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4
    private boolean isSandbox;      // 0,  NULL
    private Integer deviceBindAt;   // 1529596876820
    private Integer createdAt;      // 1513632469879
    private Integer fileUploadedAt; // 1529597411388
    private String osType;          // ios, android, NULL
    private String deviceSessionToken;  // NULL, i0whf4nt0z911xnc

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHashedPass() {
        return hashedPass;
    }

    public void setHashedPass(String hashedPass) {
        this.hashedPass = hashedPass;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public boolean isSandbox() {
        return isSandbox;
    }

    public void setSandbox(boolean sandbox) {
        isSandbox = sandbox;
    }

    public Integer getDeviceBindAt() {
        return deviceBindAt;
    }

    public void setDeviceBindAt(Integer deviceBindAt) {
        this.deviceBindAt = deviceBindAt;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFileUploadedAt() {
        return fileUploadedAt;
    }

    public void setFileUploadedAt(Integer fileUploadedAt) {
        this.fileUploadedAt = fileUploadedAt;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getDeviceSessionToken() {
        return deviceSessionToken;
    }

    public void setDeviceSessionToken(String deviceSessionToken) {
        this.deviceSessionToken = deviceSessionToken;
    }
}
