package com.example.datn.service.impl;

import com.example.datn.controller.RequestOperationName;
import com.example.datn.dto.ChatLieuDto;
import com.example.datn.entity.ChatLieu;
import com.example.datn.exception.ChatLieuException;
import com.example.datn.repository.ChatLieuRepository;
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
public class ChatLieuServiceImpl implements BaseService<ChatLieuDto, ChatLieu> {
    @Autowired
    ChatLieuRepository chatLieuRepository;

    @Override
    public Page<ChatLieu> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChatLieu> returnValue = chatLieuRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public ChatLieuDto getOne(int id) {
        ChatLieuDto chatLieuDto = new ChatLieuDto();
        ChatLieu chatLieu = chatLieuRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Chất liệu không tồn tại với id là: "+id));
        BeanUtils.copyProperties(chatLieu,chatLieuDto);
        return chatLieuDto;
    }

    @Override
    public ChatLieuDto save(ChatLieuDto chatLieuDto) {
        if(chatLieuRepository.findByMa(chatLieuDto.getMa()) != null){
            throw new ChatLieuException("Mã chất liệu đã tồn tại");
        }
        ModelMapper modelMapper = new ModelMapper();
        ChatLieu chatLieu = modelMapper.map(chatLieuDto, ChatLieu.class);
        ChatLieu addChatLieu = chatLieuRepository.save(chatLieu);
        ChatLieuDto returnValue = modelMapper.map(addChatLieu, ChatLieuDto.class);
        return returnValue;
    }

    @Override
    public ChatLieuDto update(ChatLieuDto chatLieuDto, int id) {
        ChatLieuDto returnValue =new ChatLieuDto();
        if(chatLieuRepository.findByMa(chatLieuDto.getMa()) != null){
            throw new ChatLieuException("Mã chất liệu đã tồn tại");
        }
        chatLieuRepository.update(chatLieuDto,id);

        ChatLieu chatLieu = chatLieuRepository.findById(id).get();
        BeanUtils.copyProperties(chatLieu,returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        chatLieuRepository.deleteById(id);
    }

    @Override
    public Page<ChatLieu> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ChatLieu> returnValue = chatLieuRepository.search(name,pageable);
        return returnValue;
    }
}
