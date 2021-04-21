package com.test.ancor.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PASSWORD")
public class Password implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            scope = Organization.class)
    @JsonIdentityReference(alwaysAsId=true)*/
    @ManyToOne(/*fetch = FetchType.LAZY, optional = false*/)
    @JoinColumn(name = "organizationId")
    private Organization organization;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "blocks_id")
    private List<Blocks> blocks;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "buttons_id")
    private List<Button> filesBtns;

}
