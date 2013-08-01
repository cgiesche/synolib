/*
 * Copyright 2013 Christoph Giesche
 *
 * This file is part of synolib.
 *
 * synolib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * synolib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with synolib.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.perdoctus.synolib.responses;

/**
 * @author Christoph Giesche
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
