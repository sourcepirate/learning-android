package org.blacknights.dummybooks.models;

import java.util.ArrayList;

/**
 * Created by plasmashadow on 3/5/18.
 */

public class Book {
    private String id;
    private String url;
    private String name;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;

    public Book(String id, String name, String url, String tag){
        this.id = id;
        this.name = name;
        this.url = url;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Book> generateData(){
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("sathya", "sathya", "https://someurl.com", "java"));
        list.add(new Book("sathya", "sathya", "https://someurl.com", "java"));
        list.add(new Book("sathya", "sathya", "https://someurl.com", "java"));
        list.add(new Book("sathya", "sathya", "https://someurl.com", "java"));
        list.add(new Book("sathya", "sathya", "https://someurl.com", "java"));
        return list;
    }
}
