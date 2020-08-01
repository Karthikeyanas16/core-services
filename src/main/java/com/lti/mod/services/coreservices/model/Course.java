package com.lti.mod.services.coreservices.model;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;

@Data
@Entity
@Table(name="course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mentor_id", referencedColumnName = "id")
    private User mentor;


}
