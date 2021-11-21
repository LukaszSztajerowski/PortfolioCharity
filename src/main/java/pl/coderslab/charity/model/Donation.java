package pl.coderslab.charity.model;

import lombok.Data;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Min(value = 1,message = "możesz oddać minimum 1 worek")
    private Integer quantity; //liczba worków
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Category> categories;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Institution institution;
    @Size(min=2, message = "za krótka nazwa ulicy")
    private String street;
    @Size(min=2, message = "za krótka nazwa Miasta")
    private String city;
    @Pattern(regexp = "\\d\\d\\-\\d\\d\\d")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;


}
