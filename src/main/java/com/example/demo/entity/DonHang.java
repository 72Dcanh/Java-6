package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_don_hang")
    private String maDonHang;

    @Column(name = "ngay_dat")
    private Date ngayDat;

    @Column(name = "tong_tien")
    private Integer tongTien;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id",referencedColumnName = "id")
    private KhachHang khachHang;
}
