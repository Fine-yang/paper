package com.example.demo.service;

import com.example.demo.dao.PollutionMapper;
import com.example.demo.Entity.Pollution;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.vo.PollutionVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollutionService {
    @Autowired
    private PollutionMapper pollutionMapper;

    public List<PollutionVO> selectAll(){
        List<Pollution> pollutionList=pollutionMapper.getAll();
        List<PollutionVO> pollutionVOS=new ArrayList<PollutionVO>();
        pollutionVOS= BeanUtil.copyList(pollutionList,PollutionVO.class);
        return pollutionVOS;
//        return pollutionMapper.getAll();
    }
    public List<PollutionVO> selectByRegion(String region){
        List<Pollution> pollutionList=pollutionMapper.getPollutionListByRegion(region);
        List<PollutionVO> pollutionVOS=new ArrayList<PollutionVO>();
        pollutionVOS= BeanUtil.copyList(pollutionList,PollutionVO.class);
        return pollutionVOS;
//        return pollutionMapper.getAll();
    }
    public List<PollutionVO> selectByYear(int year){
        List<Pollution> pollutionList=pollutionMapper.getPollutionListByYear(year);
        List<PollutionVO> pollutionVOS=new ArrayList<PollutionVO>();
        pollutionVOS= BeanUtil.copyList(pollutionList,PollutionVO.class);
        return pollutionVOS;
//        return pollutionMapper.getAll();
    }


    public List<PollutionVO> selectPollutionList(String region,int year){
        List<Pollution> pollutionList=pollutionMapper.getPollutionList(region,year);
        List<PollutionVO> pollutionVOS=new ArrayList<PollutionVO>();
        pollutionVOS= BeanUtil.copyList(pollutionList,PollutionVO.class);
        return pollutionVOS;
    }
}
