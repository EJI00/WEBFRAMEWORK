package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.EJIProduct;
import com.example.day6cw3.repository.EJIProductRepo;

@Service
public class EJIProductService {
    public EJIProductRepo productRepo;
    public EJIProductService(EJIProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(EJIProduct product)
    {
        try{

            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<EJIProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<EJIProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public EJIProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
