package com.bigusef.khan.catalog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Required field, must have a category name.")
    @Column(nullable = false)
    private String name;

    @Column(name = "is_locked")
    private boolean locked = false;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    @ToString.Exclude
    private Set<Attribute> attributes = new LinkedHashSet<>();

}
