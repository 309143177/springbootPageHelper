package com.lmy.demospringboot.service;

import com.lmy.demospringboot.po.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> findall();

    public Grade findById(int gradeid);

    public int insert(Grade grade);

    public int update(Grade grade);

    public int delete(int gradeid);
}
