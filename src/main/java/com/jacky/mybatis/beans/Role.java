package com.jacky.mybatis.beans;

/**
 * Created by jacky on 2017/10/23.
 */
public class Role {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String name;
    private String note;

    @Override
    public String toString(){
        return "Role:id is "+getId()+" name is "+getName()+",note is "+getNote();
    }
}
