package com.grammer.kiosk.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grammer.kiosk.domain.ItemImage;
import com.grammer.kiosk.dto.ItemImageDTO;
import com.grammer.kiosk.repository.ItemImageRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemImageServiceImpl implements ItemImageService {


    private final ItemImageRepository itemImageRepository;

    @Override
    public List<ItemImageDTO> imgList() {
        List<ItemImage> result = itemImageRepository.findAll();
        
        List<ItemImageDTO> dtoList = result.stream().map(entity -> bindToDTO(entity)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public ItemImageDTO getImg(Long mno) {
        Optional<ItemImage> result = itemImageRepository.findById(mno);

        if(result.isPresent()){
            ItemImageDTO imgDTO = bindToDTO(result.get());

            return imgDTO;
        }
        return null;
    }

    @Override
    public void saveImg(ItemImageDTO imgDTO) {
        ItemImage entity = bindToEntity(imgDTO);

        log.info(itemImageRepository.save(entity));

        //itemImageRepository.save(entity);

    }

    @Override
    public void modifyImg(ItemImageDTO imgDTO) {
        Optional<ItemImage> result = itemImageRepository.findById(imgDTO.getMno());

        if(result.isPresent()){
            ItemImage img = result.get();
            
            if(imgDTO.getMainCheck() == null){
                img.setMainCheck(img.getMainCheck());
            }else{
                img.setMainCheck(imgDTO.getMainCheck());
            }

            if(imgDTO.getMname() == null){
                img.setMname(img.getMname());
            }else{
                img.setMname(imgDTO.getMname());
            }
            itemImageRepository.updateItem(img);
        }

    }

    @Override
    public void deleteImg(Long mno) {
        itemImageRepository.deleteById(mno);

    }
    
}