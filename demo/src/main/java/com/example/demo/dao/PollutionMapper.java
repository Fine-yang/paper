package com.example.demo.dao;
import com.example.demo.Entity.Pollution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PollutionMapper {
    int insert(Pollution pollution);

    List<Pollution> getAll();

    List<Pollution> getPollutionListByRegion(String region);

    List<Pollution> getPollutionListByYear(int year);



    List<Pollution> getPollutionList(String region,int year);

    List<String> getRegion();

    List<Integer> getYear();
}
