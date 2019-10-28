package com.hzf.service.impl;

import com.hzf.entity.Pictures;
import com.hzf.entity.PicturesExample;
import com.hzf.repository.PicturesMapper;
import com.hzf.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PicturesMapper picturesMapper;

    //通过图片id查找 所有图片
    @Override
    public List<Pictures> findPictureById(Integer goodid) {
        PicturesExample example = new PicturesExample();
        PicturesExample.Criteria criteria = example.createCriteria();
        criteria.andGoodIdEqualTo(goodid);
        List<Pictures> list = picturesMapper.selectByExample(example);
        return list;
    }
    //插入图片
    @Override
    public void savePic(Pictures pictures) {
        picturesMapper.insert(pictures);
    }
}
