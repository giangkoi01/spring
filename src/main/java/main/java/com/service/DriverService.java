package main.java.com.service;

import main.java.com.entity.Driver;
import main.java.com.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
	DriverRepository driverRepository = new DriverRepository();
	public List<Driver> getAll(){
		return driverRepository.getAll();
	}
	
	public boolean insert(Driver driver) {

		return driverRepository.insert(driver);
	}
	
	public Driver findById(int id) {
        return driverRepository.findById(id);
    }

	public Boolean update(Driver driver){
		return driverRepository.update(driver);
	}

	public Boolean deleteById(int id){
		return driverRepository.deleteById(id);
	}
	
}
