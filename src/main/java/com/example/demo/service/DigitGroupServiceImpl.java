package com.example.demo.service;

import com.example.demo.entity.DigitGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/519:06
 */

@Service
public class DigitGroupServiceImpl implements DigitGroupService{

    @Autowired
    DigitGroup digitGroup;

    @Override
    public void initDigitGroup() {
        List<Integer> list = new ArrayList<>();
        int count =0;
        do {
            boolean flag = false;
            int ran = (int) (Math.random() * 10);
//            System.out.println("ran = " + ran);
            for (int i =0;i<list.size();i++) {
//                System.out.println("list的第"+i+"个数为"+list.get(i));
                if (ran == list.get(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            list.add(ran);
            count++;
        } while (count != 4);
        digitGroup.setList(list);
    }
}
