package com.esliceu.dwes.boot.model;

import java.util.Date;
import java.util.List;

/**
 * Created by dcatalans on 10/03/17.
 */
public class FiltrarUsuari {

    private List<String> users;
    private Date from;
    private Date to;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
