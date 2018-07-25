package cn.cj.app;

import cn.cj.model.Recruitment;
import cn.cj.service.RecruitmentService;
import cn.cj.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/25.
 */
@Controller
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/getrealRecruitment.do")
    public String getrealRecruitment(int rt_id,HttpSession session)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);
        session.setAttribute("ret",recruitment);
        return "details";
    }
}
