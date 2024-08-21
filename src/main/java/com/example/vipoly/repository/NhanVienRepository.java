package com.example.vipoly.repository;

import com.example.vipoly.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    //    Thêm mã nhân viên tự động
    @Query("SELECT COALESCE(MAX(n.maNhanvien), 'NV000') FROM NhanVien n")
    String findMaxMaNhanVien();
}
