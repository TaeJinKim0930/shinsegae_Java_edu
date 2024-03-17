package com.ssg.springproduct.mapper;

import com.ssg.springproduct.domain.ProductVO;
import com.ssg.springproduct.dto.PageRequestDTO;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductMapperTests {
    @Autowired(required = false)
    private ProductMapper productMapper;



    @Test
    public void testGetTimeNow() {
        log.info(productMapper.getTime());
    }

    @Test public void testInsert() {
        ProductVO productVO = new ProductVO().builder()
                .pname("TJ")
                .price(123)
                .quantity(345)
                .build();
        productMapper.insert(productVO);

        log.info("insertion made");
    }

    @Test
    public void testSelectAll() {
        List<ProductVO> list = productMapper.selectAll();
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        ProductVO vo = productMapper.selectOne(3L);
        log.info("vo: " + vo);
    }

    @Test
    public void testDelete() {
        productMapper.delete(5L);
        log.info("Deletion Succeed");
    }

    @Test
    public void testUpdate() {
        ProductVO todoVO = new ProductVO().builder()
                .pname("TJ")
                .price(123)
                .quantity(345)
                .build();
        productMapper.update(todoVO);
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<ProductVO> voList = productMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }


}
