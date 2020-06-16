package com.grammer.kiosk.service;

import java.util.Optional;
import java.util.Set;

import com.grammer.kiosk.domain.Store;
import com.grammer.kiosk.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Set<Store> getStoreList() {
        storeRepository.findAll().forEach(i -> {
            log.info(i.toString());
        });

        return (Set<Store>) storeRepository.findAll();
    }

    public Optional<Store> getStore(Long sno) {
         Optional<Store> store = storeRepository.findById(sno);
         return store;
    }

    public void saveStore(Store store){
        storeRepository.save(store);
    }

    public void modifyStore(Store store){
        storeRepository.updateStore(store);
    }

    public void deleteStore(Long sno){
        storeRepository.deleteById(sno);
    }
    
}