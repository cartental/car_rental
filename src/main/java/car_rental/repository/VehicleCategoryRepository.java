package car_rental.repository;

import org.springframework.data.repository.CrudRepository;

import car_rental.models.VehicleCategory;

public interface VehicleCategoryRepository extends CrudRepository<VehicleCategory, Long>
{
    
}