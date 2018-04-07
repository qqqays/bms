package com.qays.bms.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-07-2018 13:52
 */
@Entity
@Table(name = "test_table")
public class JpaTestEntity {

    @Id
    String id;

    @Basic
    String contents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
