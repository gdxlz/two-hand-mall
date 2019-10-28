package com.hzf.repository;

import com.hzf.entity.Pictures;
import com.hzf.entity.PicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesMapper {
    int countByExample(PicturesExample example);

    int deleteByExample(PicturesExample example);

    int deleteByPrimaryKey(Integer pictureId);

    int insert(Pictures record);

    int insertSelective(Pictures record);

    List<Pictures> selectByExample(PicturesExample example);

    Pictures selectByPrimaryKey(Integer pictureId);

    int updateByExampleSelective(@Param("record") Pictures record, @Param("example") PicturesExample example);

    int updateByExample(@Param("record") Pictures record, @Param("example") PicturesExample example);

    int updateByPrimaryKeySelective(Pictures record);

    int updateByPrimaryKey(Pictures record);
}