package org.jpa.demo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 10:28
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;
}
