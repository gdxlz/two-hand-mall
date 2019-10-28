package com.hzf.service.impl;

import com.hzf.entity.*;
import com.hzf.repository.GoodMapper;
import com.hzf.repository.GoodPictureMapper;
import com.hzf.repository.PicturesMapper;
import com.hzf.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private PicturesMapper picturesMapper;
    @Autowired
    private GoodPictureMapper goodPictureMapper;

//    返回所有的商品以及其对应的一张图片
    @Override
    public List<GoodPicture> findAllGoodPicture() {
        List<GoodPicture> list = goodPictureMapper.findAllGoodPicture();
        return list;
    }
//  通过商品id查找商品
    @Override
    public Good findGoodById(Integer goodid) {
        Good good =goodMapper.selectByPrimaryKey(goodid);
        return good;
    }

//插入商品
    @Override
    public void saveGood(Good good) {
        goodMapper.insert(good);
    }


// 查找最新的商品的id
    @Override
    public Integer findLastGood() {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("good_id desc");
        List<Good> list = goodMapper.selectByExample(example) ;
        return list.get(0).getGoodId();
    }


}
