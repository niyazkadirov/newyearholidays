/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyearhollidays.AMQ;

import java.io.Serializable;
import java.util.logging.Logger;


public class Bean implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
