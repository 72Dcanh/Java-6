package com.example.demo.response;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class DonHangResponse {
    private Integer id;

    private String maDonHang;

    private Date ngayDat;

    private Integer tongTien;

    private String tenKhachHang;

    private String diaChi;


    public DonHangResponse(DonHang donHang){
        this.id = donHang.getId();
        this.maDonHang = donHang.getMaDonHang();
        this.ngayDat = donHang.getNgayDat();
        this.tongTien = donHang.getTongTien();
        this.tenKhachHang = donHang.getKhachHang().getTenKhachHang();
        this.diaChi = donHang.getKhachHang().getDiaChi();
    }
}
