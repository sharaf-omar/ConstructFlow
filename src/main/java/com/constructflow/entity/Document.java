package com.constructflow.entity;

import java.util.Date;
import java.util.Map;

public class Document {

    private int documentID;
    private String title;
    private double version;
    private String fileType;
    private Date uploadDate;
    private boolean isLocked;

    public Document() {
        System.out.println("[Entity] Default Document created.");
        this.version = 1.0;
        this.isLocked = false;
    }

    public Document(Map<String, Object> metadata) {
        System.out.println("[Entity] Document created with metadata.");
        if (metadata != null) {
            this.documentID = metadata.containsKey("documentID") ? (Integer) metadata.get("documentID") : 0;
            this.title = metadata.containsKey("title") ? (String) metadata.get("title") : "Untitled";
            this.fileType = metadata.containsKey("fileType") ? (String) metadata.get("fileType") : "Unknown";
            this.uploadDate = new Date();
        }
        this.version = 1.0;
        this.isLocked = false;
    }

    public void lock() {
        this.isLocked = true;
        System.out.println("[Entity] Document '" + this.title + "' is now locked.");
    }

    public void incrementVersion() {
        if (!isLocked) {
            this.version += 0.1;
            System.out.println("[Entity] Document '" + this.title + "' version incremented to " + String.format("%.1f", this.version));
        } else {
            System.out.println("[Entity] Cannot increment version. Document '" + this.title + "' is locked.");
        }
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", title='" + title + '\'' +
                ", version=" + version +
                ", fileType='" + fileType + '\'' +
                ", uploadDate=" + uploadDate +
                ", isLocked=" + isLocked +
                '}';
    }
}