package com.lmy.demospringboot.handler;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.demospringboot.po.Grade;
import com.lmy.demospringboot.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GradeHandler {
    @Resource
    private GradeService gradeService;
    @RequestMapping("/findall")
    public String findall(Model model,Integer pageNum){
        //判断获取的当前页的状态
        if(pageNum==null){
            pageNum=1;
        }
        //获取当前的页数的条数
        PageHelper.startPage(pageNum,5);
        //判断年级的信息
        List<Grade> list = gradeService.findall();
        //获取总页数
        PageInfo pageInfo=new PageInfo(list);
        int pages=pageInfo.getPages();
        model.addAttribute("list",list);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        return "findall";
    }

    @RequestMapping("/load")
    public String load(){
        return "insert";
    }

    @RequestMapping("/insert")
    public String insert(Grade grade){
        gradeService.insert(grade);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        gradeService.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/findById")
    public String findById(int id,Model model){
        model.addAttribute("list",gradeService.findById(id));
        return "update";
    }
    @RequestMapping("update")
    public String update(Grade grade){
        gradeService.update(grade);
        return "redirect:/";
    }
}
