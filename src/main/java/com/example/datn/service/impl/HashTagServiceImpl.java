package com.example.datn.service.impl;

import com.example.datn.dto.HashTagDto;
import com.example.datn.entity.HashTag;
import com.example.datn.exception.HashTagException;
import com.example.datn.repository.HashTagRepository;
import com.example.datn.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HashTagServiceImpl implements BaseService<HashTagDto, HashTag> {
    @Autowired
    HashTagRepository hashTagRepository;

    @Override
    public Page<HashTag> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HashTag> returnValue = hashTagRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public HashTagDto getOne(int id) {
        HashTagDto returnValue = new HashTagDto();
        HashTag hashTag = hashTagRepository.findById(id).orElseThrow(()->new EntityNotFoundException("HashTag không tông tại với id là: "+id));
        BeanUtils.copyProperties(hashTag, returnValue);
        return returnValue;
    }

    @Override
    public HashTagDto save(HashTagDto hashTagDto) {
        if (hashTagRepository.findByMa(hashTagDto.getMa())!= null){
            throw new HashTagException("Mã "+hashTagDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        HashTag hashTag = modelMapper.map(hashTagDto, HashTag.class);
        HashTag addHashTag = hashTagRepository.save(hashTag);
        HashTagDto returnValue = modelMapper.map(addHashTag, HashTagDto.class);

        return returnValue;
    }

    @Override
    public HashTagDto update(HashTagDto hashTagDto, int id) {
        if (hashTagRepository.findById(id)==null){
            throw new HashTagException("id "+id+" chưa tồn tại trong hệ thống");
        }
        hashTagRepository.update(hashTagDto,id);

        HashTagDto returnValue = new HashTagDto();
        HashTag hashTag = hashTagRepository.findById(id).get();
        BeanUtils.copyProperties(hashTag, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        hashTagRepository.deleteById(id);
    }

    @Override
    public Page<HashTag> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<HashTag> returnValue = hashTagRepository.findByTen(name, pageable);
        return returnValue;
    }
}
