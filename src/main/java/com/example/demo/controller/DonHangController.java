package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.request.DonHangRequest;
import com.example.demo.response.DonHangResponse;
import com.example.demo.service.DonHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/don-hang")
public class DonHangController {
    @Autowired
    DonHangService donHangService;

    @Autowired
    KhachHangRepository khachHangRepository;

    @GetMapping("/hien-thi")
    public List<DonHangResponse> hienThi(){
        return donHangService.getAll();
    }

    @GetMapping("/khach-hang")
    public List<KhachHang> getAllKhachHang(){
        return khachHangRepository.findAll();
    }

    @PostMapping("/them")
    public void themDonHang(@RequestBody @Valid DonHangRequest donHangRequest){
        donHangService.add(donHangRequest);
    }

    @GetMapping("/{id}")
    public DonHangResponse detail(@PathVariable("id") Integer id){
        return donHangService.getDonHangById(id);
    }

    @PutMapping("/sua")
    public void updateDonHang(@RequestBody @Valid DonHangRequest donHangRequest){
        donHangService.update(donHangRequest);
    }

    @DeleteMapping("/xoa")
    public void deleteDonHang(@RequestParam("id")Integer id){
        donHangService.delete(id);
    }


}
