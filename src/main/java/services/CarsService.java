package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarsDetailsRepository;
import entity.CarsDetails;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    private final CarsDetailsRepository carsDetailsRepository;

    @Autowired
    public CarsService(CarsDetailsRepository carsDetailsRepository) {
        this.carsDetailsRepository = carsDetailsRepository;
    }

    public List<CarsDetails> getAllCarsDetails() {
        return carsDetailsRepository.findAll();
    }

    public Optional<CarsDetails> getCarDetailsById(Integer id) {
        return carsDetailsRepository.findById(id);
    }

    public CarsDetails saveCarDetails(CarsDetails carsDetails) {
        return carsDetailsRepository.save(carsDetails);
    }

    public void deleteCarDetails(Integer id) {
        carsDetailsRepository.deleteById(id);
    }
}
