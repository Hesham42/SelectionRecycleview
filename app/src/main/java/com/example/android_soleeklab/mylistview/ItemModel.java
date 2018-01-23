package com.example.android_soleeklab.mylistview;

/**
 * Created by android-soleeklab on 1/23/2018.
 */

public class ItemModel {
    int id ;
    String title;

    public ItemModel(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
