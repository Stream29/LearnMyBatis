package com.stream.learnmybatis;

import com.stream.learnmybatis.mapper.StackMapper;
import com.stream.learnmybatis.pojo.StringPiece;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class LearnMyBatisApplicationTests
{
    @Autowired
    private StackMapper stackMapper;

    @Test
    void delete()
    {
        System.out.println("stackMapper.delete(1) = " + stackMapper.delete(1));
    }

    @Test
    void selectAll()
    {
        System.out.println("stackMapper.selectAll() = ");
        stackMapper.selectAll()
                   .forEach(System.out::println);
    }

    @Test
    void insert()
    {
        StringPiece instance = new StringPiece(1,
                                               LocalTime.now().toString());
        System.out.println("stackMapper.insert() = " + stackMapper.insert(instance));
        System.out.println("instance.getId() = " + instance.getId());
    }

    @Test
    void update()
    {
        StringPiece instance = new StringPiece(6,
                                               LocalTime.now().toString());
        System.out.println("stackMapper.update() = " + stackMapper.update(instance));
        selectAll();
    }

    @Test
    void selectById()
    {
        System.out.println("stackMapper.selectById() = " + stackMapper.selectById(6));
    }

    @Test
    void dynamicSelect()
    {
        System.out.println("stackMapper.dynamicSelect() = " + stackMapper.dynamicSelect("09:53:49.876194"));
    }

    @Test
    void dynamicDelete()
    {
        System.out.println("stackMapper.deleteByIds() = " + stackMapper.deleteByIds(List.of(6, 7, 8)));
        selectAll();
    }
}
