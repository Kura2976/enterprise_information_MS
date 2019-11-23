package com.demon.dbserver.service.impl;


import com.demon.dbserver.bean.Value;
import com.demon.dbserver.dao.ValueDao;
import com.demon.dbserver.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {

    @Autowired
    private ValueDao valueDao;

    @Override
    public List<Value> getAllValues() {
        return valueDao.getAllValues();
    }

    @Override
    public Value getValueById(Integer id) {
        return valueDao.getValueById(id);
    }

    @Override
    public int getMaxId() {
        return valueDao.getMaxId();
    }

    @Override
    public boolean addValue(Value value) {
        try {
            int maxId = valueDao.getMaxId();
            value.setId(maxId + 1);
            valueDao.addValue(value);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateValue(Value value) {
        try {
            valueDao.updateValue(value);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteValue(Integer id) {
        try {
            valueDao.deleteValue(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
