package edu.miu.cs.cs425.webapp.homib_tcms.module;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "loads")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadId;
    @Column(name = "load_date", nullable = false)
    @NotBlank(message = "*This field is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate loadDate;
    @Column(name = "load_time", nullable = false)
    @NotBlank(message = "*This field is required")
    private String loadTime;
    @Column(name = "weight", nullable = false)
    @NotBlank(message = "*This field is required")
    private float weight;
   @Column(name = "price", nullable = false)
    @NotBlank(message = "*This field is required")
    private float price;
    @Column(name = "pickup_from", nullable = false)
    @NotBlank(message = "*This field is required")
    private String pickupFrom;
    @Column(name = "deliver_to", nullable = false)
    @NotBlank(message = "*This field is required")
    private String deliverTO;
    @Column(name = "load_type")
    private String loadType;

    //Booking
    @OneToMany(mappedBy = "load", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public Load(Long loadId,
                @NotBlank(message = "*This field is required") LocalDate loadDate,
                @NotBlank(message = "*This field is required") String loadTime,
                @NotBlank(message = "*This field is required") float weight,
                @NotBlank(message = "*This field is required") float price,
                @NotBlank(message = "*This field is required") String pickupFrom,
                @NotBlank(message = "*This field is required") String deliverTO, String loadType) {
        this.loadId = loadId;
        this.loadDate = loadDate;
        this.loadTime = loadTime;
        this.weight = weight;
        this.price = price;
        this.pickupFrom = pickupFrom;
        this.deliverTO = deliverTO;
        this.loadType = loadType;
    }

    public Load(@NotBlank(message = "*This field is required") LocalDate loadDate,
                @NotBlank(message = "*This field is required") String loadTime,
                @NotBlank(message = "*This field is required") float weight,
                @NotBlank(message = "*This field is required") float price,
                @NotBlank(message = "*This field is required") String pickupFrom,
                @NotBlank(message = "*This field is required") String deliverTO, String loadType) {
        this.loadDate = loadDate;
        this.loadTime = loadTime;
        this.weight = weight;
        this.price = price;
        this.pickupFrom = pickupFrom;
        this.deliverTO = deliverTO;
        this.loadType = loadType;
    }

    public Load() {
    }

    public Long getLoadId() {
        return loadId;
    }

    public void setLoadId(Long loadId) {
        this.loadId = loadId;
    }

    public LocalDate getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(LocalDate loadDate) {
        this.loadDate = loadDate;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPickupFrom() {
        return pickupFrom;
    }

    public void setPickupFrom(String pickupFrom) {
        this.pickupFrom = pickupFrom;
    }

    public String getDeliverTO() {
        return deliverTO;
    }

    public void setDeliverTO(String deliverTO) {
        this.deliverTO = deliverTO;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.Load.class.getSimpleName() + "[", "]")
                .add("loadId=" + loadId)
                .add("loadDate=" + loadDate)
                .add("loadTime='" + loadTime + "'")
                .add("weight=" + weight)
                .add("price=" + price)
                .add("pickupFrom='" + pickupFrom + "'")
                .add("deliverTO='" + deliverTO + "'")
                .add("loadType='" + loadType + "'")
                .add("booking=" + booking)
                .toString();
    }
}
