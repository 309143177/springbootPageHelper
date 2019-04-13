package com.lmy.demospringboot.service;

import com.lmy.demospringboot.dao.GradeDao;
import com.lmy.demospringboot.po.Grade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GradeServiceimpl implements GradeService {
    @Resource
    private GradeDao gd;
    @Override
    public List<Grade> findall() {
        return gd.findall();
    }

    @Override
    public Grade findById(int gradeid) {
        return gd.findById(gradeid);
    }

    @Override
    public int insert(Grade grade) {
        return gd.insert(grade);
    }

    @Override
    public int update(Grade grade) {
        return gd.update(grade);
    }

    @Override
    public int delete(int gradeid) {
        return gd.delete(gradeid);
    }
}
