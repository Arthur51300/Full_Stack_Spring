package fr.polytech.fsback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Guide")
public class GuideEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "guide_jn_livre",
            joinColumns = @JoinColumn(name = "id_restaurant"),
            inverseJoinColumns = @JoinColumn(name = "id_guide"))
    private List<RestaurantEntity> restaurants;

}
