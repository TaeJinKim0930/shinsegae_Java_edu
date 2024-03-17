package com.ssg.springproduct.service;

import com.ssg.springproduct.dto.PageRequestDTO;
import com.ssg.springproduct.dto.PageResponseDTO;
import com.ssg.springproduct.dto.ProductDTO;


public interface ProductService {
    void register(ProductDTO productDTO);


    ProductDTO getOne(Long pno);

    void remove(Long pno);
    void modify(ProductDTO productDTO);

    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    boolean registerFilter(ProductDTO productDTO);
}
