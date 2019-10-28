package com.hzf.service;

import com.hzf.entity.Pictures;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PictureService {
    List<Pictures> findPictureById(Integer goodid);
    void savePic(Pictures pictures);
}
