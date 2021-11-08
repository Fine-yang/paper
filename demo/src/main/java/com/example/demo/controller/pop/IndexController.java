package com.example.demo.controller.pop;


import com.example.demo.Entity.Pollution;

import com.example.demo.service.PollutionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.vo.PollutionVO;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RestController
//@RequestMapping("/")
@Controller
public class IndexController {
//    private PollutionMapper pollutionMapper;
    @Resource
    private PollutionService pollutionService;
//    @ResponseBody
    @GetMapping({"/index", "/", "/index.html"})
    @ResponseBody
    public String index(){

        return "index";
    }
    @GetMapping("/getAll")
    @ResponseBody
    public List<PollutionVO> getAll(HttpServletRequest request) {
//        List<Pollution>=new ArrayList<Pollution>();
//        List<Pollution>pollutionList=pollutionService.selectAll();
        String region=request.getParameter("region");
        String year=request.getParameter("year");
        if (region==null && year==null) {
            return pollutionService.selectAll();
        }else if (year==null){
            return pollutionService.selectByRegion(region);
        }else if(region==null){
            int year1=Integer.parseInt(year);
            return pollutionService.selectByYear(year1);
        }else {
            int year1=Integer.parseInt(year);
            return pollutionService.selectPollutionList(region,year1);
        }
    }
}
