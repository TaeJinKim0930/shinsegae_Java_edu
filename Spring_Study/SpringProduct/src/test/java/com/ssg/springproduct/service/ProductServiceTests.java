package com.ssg.springproduct.service;


import com.ssg.springproduct.dto.PageRequestDTO;
import com.ssg.springproduct.dto.PageResponseDTO;
import com.ssg.springproduct.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductServiceTests {
    @Autowired(required = false)
    private ProductService productService;

    @Test
    public void testRegister() {
        ProductDTO dto = new ProductDTO().builder()
                .pname("tjkfood")
                .price(222)
                .quantity(200)
                .build();

        productService.register(dto);

    }

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(2)
                .build();

        PageResponseDTO<ProductDTO> responseDTO = productService.getList(pageRequestDTO);
        log.info(responseDTO);
        responseDTO.getDtoList().stream().forEach((productDTO -> log.info(productDTO)));
    }


}
