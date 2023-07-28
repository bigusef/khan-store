package com.bigusef.khan.catalog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttributeDataType dataType;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "value")
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name = "attr_id"))
    private List<String> options = new ArrayList<>();

    @Column(name = "is_required")
    private boolean required = false;

    @Column(name = "is_locked")
    private boolean locked = false;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
