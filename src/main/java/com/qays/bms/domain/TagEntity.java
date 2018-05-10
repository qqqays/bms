package com.qays.bms.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ListIndexBase;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 09:31
 */
@Entity
@Data
@Table(name = "tag")
public class TagEntity {

    @Id
    private Integer id;

    @Basic
    private String name;

    @Basic
    private String description;

}
