package pl.coderslab.charity.model;

import lombok.Data;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "dontations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity; //liczba worków
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Category> categories;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;


}
