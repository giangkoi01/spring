package main.java.com.service;

import main.java.com.entity.Router;
import main.java.com.repository.RouterRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RouterService {
	RouterRepository routerRepository = new RouterRepository();
	
	public List<Router> getAll(){
		return routerRepository.getAll();
	}

	public boolean insert(Router router) {
		return routerRepository.insert(router);
	}

	public boolean update(Router router){
		return routerRepository.update(router);
	}
	
	public Router findRouterId(int id) {

        return routerRepository.findById(id);
    }

	public Boolean deleteById(int id){
		return routerRepository.deleteById(id);
	}


}
