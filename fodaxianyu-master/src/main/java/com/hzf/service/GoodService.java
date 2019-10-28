package com.hzf.service;

import com.hzf.entity.Good;
import com.hzf.entity.GoodPicture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodService {
    List<GoodPicture> findAllGoodPicture();
    Good findGoodById(Integer goodid);
    void saveGood(Good good);
    Integer findLastGood();

}
