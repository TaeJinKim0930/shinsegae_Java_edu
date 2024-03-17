package com.ssg.springproduct.mapper;


import com.ssg.springproduct.domain.ProductVO;
import com.ssg.springproduct.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ProductMapper {
    String getTime();
    void insert(ProductVO productVO);

    List<ProductVO> selectAll();

    ProductVO selectOne(Long pno);

    void delete(Long pno);

    void update(ProductVO productVO);

    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

    boolean nameExist(@Param("pname") String pname);
}
