package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.DonHangRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.request.DonHangRequest;
import com.example.demo.response.DonHangResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class DonHangService {
    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    KhachHangRepository khachHangRepository;

    public List<DonHangResponse> getAll(){
        return donHangRepository.findAll().stream()
                .map(DonHangResponse::new)
                .toList();
    }

    public DonHangResponse getDonHangById(Integer id){
        DonHang donHang = donHangRepository.findById(id).get();
        return new DonHangResponse(donHang);
    }

    public void add(DonHangRequest donHangRequest){
        DonHang donHang = new DonHang();
        BeanUtils.copyProperties(donHangRequest, donHang);

        KhachHang kh = khachHangRepository.findById(donHangRequest.getIdKhachHang()).get();
        donHang.setKhachHang(kh);

        donHangRepository.save(donHang);
    }

    public void update(DonHangRequest donHangRequest){
        DonHang donHang = new DonHang();
        BeanUtils.copyProperties(donHangRequest, donHang);

        KhachHang kh = khachHangRepository.findById(donHangRequest.getIdKhachHang()).get();
        donHang.setKhachHang(kh);
        donHangRepository.save(donHang);
    }

    public void delete(Integer id){
        donHangRepository.deleteById(id);
    }

}
