package car_rental.models.vehicle;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String model;

    @NotNull
    private LocalDate year;

    private String make;

    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull(message = "Vehicle Category is required")
    private VehicleCategory category;
    private String description;
    private double rentFee;

    public Vehicle(String model, String make, LocalDate year, String description, Double rentFee)
    {
        this.model = model;
        this.make = make;
        this.year = year;
        this.description = description;
        this.rentFee = rentFee;
    }

    public Vehicle()
    {

    }

    public boolean isAvailabe()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getModel()
    {
        return this.model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getMake()
    {
        return this.make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public LocalDate getYear()
    {
        return this.year;
    }

    public void setYear(LocalDate year)
    {
        this.year = year;
    }

    public VehicleCategory getCategory()
    {
        return this.category;
    }

    public void setCategory(VehicleCategory category)
    {
        this.category = category;
        category.addVehicle(this);
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setRentFee(Double rentFee)
    {
        this.rentFee = rentFee;
    }

    public Double getRentFee()
    {
        return this.rentFee;
    }


}