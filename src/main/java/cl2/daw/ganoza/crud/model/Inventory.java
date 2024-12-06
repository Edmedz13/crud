package cl2.daw.ganoza.crud.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


}
