package com.grammer.kiosk.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grammer.kiosk.domain.Item;
import com.grammer.kiosk.domain.ItemImage;
import com.grammer.kiosk.dto.ItemDTO;
import com.grammer.kiosk.repository.ItemRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getItems() {
        List<Item> result = itemRepository.getItemList();
        List<ItemDTO> dtoList = result.stream().map(entity -> bindToDTO(entity)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public ItemDTO getItem(Long ino) {
        Item item = itemRepository.getItem(ino);

        ItemDTO itemDTO = bindToDTO(item);

        return itemDTO;
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        
        Item entity = bindToEntity(itemDTO);
        
        for(ItemImage im: entity.getImages()){
            im.setItem(entity);
        }

        
        itemRepository.save(entity);
    }

    @Override
    public void modifyItem(ItemDTO itemDTO) {
        Optional<Item> result = itemRepository.findById(itemDTO.getIno());

        if (result.isPresent()) {
            Item item = result.get();

            if (itemDTO.getContent() == null) {
                item.setContent(item.getContent());
            } else {
                item.setContent(itemDTO.getContent());
            }

            if (itemDTO.getDescription() == null) {
                item.setDescription(item.getDescription());
            } else {
                item.setDescription(itemDTO.getDescription());
            }

            if (itemDTO.getIname() == null) {
                item.setIname(item.getIname());
            } else {
                item.setIname(itemDTO.getIname());
            }

            if (itemDTO.getPrice() == null) {
                item.setPrice(item.getPrice());
            } else {
                item.setPrice(itemDTO.getPrice());
            }

            if (itemDTO.getState() == null) {
                item.setState(item.getState());
            } else {
                item.setState(itemDTO.getState());
            }

            if (itemDTO.getType() == null) {
                item.setType(item.getType());
            } else {
                item.setType(itemDTO.getType());
            }
            itemRepository.updateItem(item);
        }

    }

    @Override
    public void removeItem(Long ino) {
        itemRepository.deleteById(ino);

    }


    
}