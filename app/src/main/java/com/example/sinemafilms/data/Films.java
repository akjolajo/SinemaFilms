package com.example.sinemafilms.data;

import com.google.gson.annotations.SerializedName;

public class Films {
    String id;
    String title;
    @SerializedName("original_title")
    String originaltitle;
    @SerializedName("description")
    String description;
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
