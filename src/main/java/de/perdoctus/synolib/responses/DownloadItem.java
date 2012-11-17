/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.perdoctus.synolib.responses;

/**
 *
 * @author Christoph Giesche <christoph.giesche@gmx.net>
 */
public class DownloadItem {
    
    private int availablePieces;
    private int connectedPeers;
    private long createdTime;
    private String currentRate;
    private String currentSize;
    private int downloadedPieces;
    private String extraInfo;
    private String filename;
    private int id;
    private int pid;
    private String progress;
    private int seedingInterval;
    private int seedingRatio;
    private long startedTime;
    private int status;
    private int totalPeers;
    private int totalPieces;
    private String totalSize;
    private String totalUpload;
    private String uploadRate;
    private String url;
    private String username;
    
    
    
    
    /*   "availablePieces" : 0,
         "connectedPeers" : 0,
         "createdTime" : 1330176006,
         "currentRate" : 0,
         "currentSize" : "86.72 KB",
         "downloadedPieces" : 0,
         "extraInfo" : "",
         "filename" : "index.html",
         "id" : 286,
         "pid" : -1,
         "progress" : "100.0%",
         "seedingInterval" : 0,
         "seedingRatio" : 0,
         "startedTime" : 1330176012,
         "status" : 5,
         "totalPeers" : 0,
         "totalPieces" : 0,
         "totalSize" : "86.72 KB",
         "totalUpload" : 0,
         "uploadRate" : 0,
         "url" : "http://www.golem.de",
         "username" : "admin"
     */

    public int getAvailablePieces() {
        return availablePieces;
    }

    public void setAvailablePieces(int availablePieces) {
        this.availablePieces = availablePieces;
    }

    public int getConnectedPeers() {
        return connectedPeers;
    }

    public void setConnectedPeers(int connectedPeers) {
        this.connectedPeers = connectedPeers;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public String getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(String currentSize) {
        this.currentSize = currentSize;
    }

    public int getDownloadedPieces() {
        return downloadedPieces;
    }

    public void setDownloadedPieces(int downloadedPieces) {
        this.downloadedPieces = downloadedPieces;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getSeedingInterval() {
        return seedingInterval;
    }

    public void setSeedingInterval(int seedingInterval) {
        this.seedingInterval = seedingInterval;
    }

    public int getSeedingRatio() {
        return seedingRatio;
    }

    public void setSeedingRatio(int seedingRatio) {
        this.seedingRatio = seedingRatio;
    }

    public long getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(long startedTime) {
        this.startedTime = startedTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalPeers() {
        return totalPeers;
    }

    public void setTotalPeers(int totalPeers) {
        this.totalPeers = totalPeers;
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(int totalPieces) {
        this.totalPieces = totalPieces;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getTotalUpload() {
        return totalUpload;
    }

    public void setTotalUpload(String totalUpload) {
        this.totalUpload = totalUpload;
    }

    public String getUploadRate() {
        return uploadRate;
    }

    public void setUploadRate(String uploadRate) {
        this.uploadRate = uploadRate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
