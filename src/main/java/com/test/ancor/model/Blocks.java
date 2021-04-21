package com.test.ancor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BLOCKS")
public class Blocks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "HEADER")
    private String header;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fields_id")
    private List<Fields> fields;

    @ManyToOne
    private Password password;






}
