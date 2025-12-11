package com.example.demo.request;

import com.example.demo.entity.KhachHang;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class DonHangRequest {
    private Integer id;

    @NotBlank(message = "Khong de trong ma don hang")
    private String maDonHang;

    private Date ngayDat;

    @NotNull(message = "Khong de trong tong tien")
    private Integer tongTien;

    private String tenKhachHang;

    private String diaChi;

    private Integer idKhachHang;



}
