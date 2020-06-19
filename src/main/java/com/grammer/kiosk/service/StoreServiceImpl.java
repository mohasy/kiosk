package com.grammer.kiosk.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grammer.kiosk.domain.Store;
import com.grammer.kiosk.dto.StoreDTO;
import com.grammer.kiosk.repository.StoreRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public List<StoreDTO> getStoreList() {
        List<Store> result = storeRepository.findAll();
        List<StoreDTO> dtoList = result.stream().map(entity -> bindToDTO(entity)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public StoreDTO getStore(Long sno) {

        Optional<Store> result = storeRepository.findById(sno);

        if(result.isPresent()){
            StoreDTO store =  bindToDTO(result.get());

            return store;
        }

        return null;
    }

    @Override
    public void saveStore(StoreDTO storeDTO) {
        Store entity = bindToEntity(storeDTO);

        storeRepository.save(entity);
    }

    @Override
    public void modifyStore(StoreDTO storeDTO) {
        
        Optional<Store> result = storeRepository.findById(storeDTO.getSno());

        if(result.isPresent()){
            Store store = result.get();
            
            if(storeDTO.getAddress() == null){
                store.setAddress(store.getAddress());
            }else{
                store.setAddress(storeDTO.getAddress());
            }

            if(storeDTO.getBusinessNo() == null){
                store.setBusinessNo(store.getBusinessNo());
            }else{
                store.setBusinessNo(storeDTO.getBusinessNo());
            }

            if(storeDTO.getContact() == null){
                store.setContact(store.getContact());
            }else{
                store.setContact(storeDTO.getContact());
            }

            if(storeDTO.getMname() == null){
                store.setSname(store.getSname());
            }else{
                store.setSname(storeDTO.getMname());
            }

            if(storeDTO.getOpenStatus() == null){
                store.setOpenStatus(store.getOpenStatus());
            }else{
                store.setOpenStatus(storeDTO.getOpenStatus());
            }

            if(storeDTO.getWorkplace() == null){
                store.setWorkplace(store.getWorkplace());
            }else{
                store.setWorkplace(storeDTO.getWorkplace());
            }
            storeRepository.updateStore(store);
        }
    }

    @Override
    public void removeStore(Long sno) {
        storeRepository.deleteById(sno);
    }
    
}