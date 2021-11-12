package com.example.demo.controller.pop;


import com.example.demo.Entity.Pollution;

import com.example.demo.service.PollutionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.vo.PollutionVO;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

//@RestController
//@RequestMapping("/")
@Controller
public class IndexController {
//    private PollutionMapper pollutionMapper;
    @Resource
    private PollutionService pollutionService;
//    @ResponseBody
//    @GetMapping({"/index", "/", "/index.html"})
//    @ResponseBody
//    public String index(){
//
//        return "index";
//    }
    @GetMapping({"/initTable"})
    @ResponseBody
    public List<String> initTable(HttpServletRequest request){
//        JSONObject result = new JSONObject();
        List<String> columns = new LinkedList<>();
        columns.add("region");
        columns.add("year");
        columns.add("others");
        return columns;
    }
    @GetMapping("/getAll")
    @ResponseBody
    public List<PollutionVO> getAll(HttpServletRequest request) {
//        List<Pollution>=new ArrayList<Pollution>();
//        List<Pollution>pollutionList=pollutionService.selectAll();
        String region=request.getParameter("region");
        String year=request.getParameter("year");
        System.out.println("#######################################################################3#######################################################################");
        System.out.println(region);
        System.out.println(year);
        String regionStr = "Select a region...";
        String yearStr = "Select a year...";
        if (region==null && year==null || region.equals(regionStr)&&year.equals(yearStr)) {
            return pollutionService.selectAll();
        }else if (year==null || year.equals(yearStr)){
            return pollutionService.selectByRegion(region);
        }else if(region==null || region.equals(regionStr)){
            int year1=Integer.parseInt(year);
            return pollutionService.selectByYear(year1);
        }else {
            int year1=Integer.parseInt(year);
            return pollutionService.selectPollutionList(region,year1);
        }
    }
    @GetMapping("/getRegion")
    @ResponseBody
    public List<String> getRegion(){
        return pollutionService.selectRegion();
    }
    @GetMapping("/getYear")
    @ResponseBody
    public List<String> getYear(){
        return pollutionService.selectYear();
    }

}
