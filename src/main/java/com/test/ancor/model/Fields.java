package com.test.ancor.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "FIELDS")
public class Fields implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NAME")
    private String name;

    @Column(name = "UNIT")
    private String unit;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "values_id")
    private List<Value> fixedValues;

    @ManyToOne
    private Blocks blocks;
}
