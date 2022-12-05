package com.example.dictionaryappsql;

import java.io.Serializable;

public class Term implements Serializable {
// khởi tạo khai báo cacs đội tượng cần quản lý trong sql
    private long id;
    private String term;
    private String full_form;

    public Term(long id, String term, String full_form) {
        this.id = id;
        this.term = term;
        this.full_form = full_form;
    }
    // over các đối tương hay là genret các đối tượng được khai báo ở trên
    public long getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public String getFull_form() {
        return full_form;
    }
}
