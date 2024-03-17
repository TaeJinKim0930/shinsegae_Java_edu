package com.ssg.springproduct.service;

import com.ssg.springproduct.domain.ProductVO;
import com.ssg.springproduct.dto.PageRequestDTO;
import com.ssg.springproduct.dto.PageResponseDTO;
import com.ssg.springproduct.dto.ProductDTO;
import com.ssg.springproduct.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor // 생성자 DI 방식으로 필요한 BEAN 주입
public class ProductServiceImpl implements ProductService {
    /**
     * Constructor Injection 을 위한 private final
     */
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(ProductDTO productDTO) {
        log.info("TodoServiceImpl/register ...");
        try {
            if(registerFilter(productDTO)) {
                ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
                productMapper.insert(productVO);
                log.info("등록성공");
            } else {
                throw new Exception("예외처리 더 필요");
            }
        } catch (Exception e) {
            log.info("등록실패: 이유모름");
            throw new RuntimeException("등록중 등록실패 했음 문의바람", e);
        }
    }



    @Override
    public ProductDTO getOne(Long pno) {
        return modelMapper.map(productMapper.selectOne(pno), ProductDTO.class);
    }

    @Override
    public void remove(Long pno) {
        productMapper.delete(pno);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        try {
            if(registerFilter(productDTO)) {
                productMapper.update(modelMapper.map(productDTO, ProductVO.class));
                log.info("수정성공");
            } else {
                throw new Exception("예외처리 더 필요");
            }
        }  catch (Exception e) {
            log.info("수정실패: 이유모름");
            throw new RuntimeException("수정중 실패 했음 문의바람", e);
        }
    }

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        List<ProductVO> vos = productMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtos = vos.stream()
                .map(vo -> modelMapper.map(vo, ProductDTO.class))
                .toList();

        int total = productMapper.getCount(pageRequestDTO);

        PageResponseDTO<ProductDTO> pageResponseDTO = PageResponseDTO.<ProductDTO>All()
                .dtoList(dtos)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public boolean registerFilter(ProductDTO productDTO) {
        try {
            if (productMapper.nameExist(productDTO.getPname())) {
                throw new DataIntegrityViolationException("이미 존재하는 이름입니다");
            }
            if (productDTO.getPname().length() > 100 || productDTO.getPname().length() < 1) {
                throw new DataIntegrityViolationException("글자수는 1~100자로 입력해주세요");
            }
            if (productDTO.getPrice() < 0 || productDTO.getPrice() > 1000000) {
                throw new DataIntegrityViolationException("가격은 0원 ~ 1,000,000 원 사이로 입력해주세요");
            }
            if (productDTO.getQuantity() < 0 || productDTO.getQuantity() >= 100000) {
                throw new DataIntegrityViolationException("재고 수량은 0개 ~ 99,999 개로 입력해주세요");
            }
            return true;
        } catch (DataIntegrityViolationException e) {
            log.info("실패: " + e.getMessage());
            throw e; // Re-throw the exception to fail the test
        } catch (Exception e) {
            log.info("실패: 이유모름");
            throw new RuntimeException("실패 했음 문의바람", e);
        }
    }


}
