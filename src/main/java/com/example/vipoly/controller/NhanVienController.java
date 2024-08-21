package com.example.vipoly.controller;

import com.example.vipoly.model.NhanVien;
import com.example.vipoly.repository.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nvRepository;

    @GetMapping("hien-thi")
    public String FillNV(Model model) {
        List<NhanVien> nvList = nvRepository.findAll();
        model.addAttribute("data", nvList);
        return "index";
    }

    @GetMapping("create")
    public String Create(Model model) {
        String maNhanVienMax = nvRepository.findMaxMaNhanVien();
        String newMaNhanVien = generateNextMaNhanVien(maNhanVienMax);
        model.addAttribute("maNhanVienMoi", newMaNhanVien);
        model.addAttribute("nhanVien", new NhanVien()); // Đảm bảo tạo đối tượng NhanVien mới
        return "create";
    }

    @PostMapping("store")
    public String Store(@ModelAttribute @Valid NhanVien nv, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Trả về trang tạo với lỗi xác thực
            String maNhanVienMax = nvRepository.findMaxMaNhanVien();
            String newMaNhanVien = generateNextMaNhanVien(maNhanVienMax);
            model.addAttribute("maNhanVienMoi", newMaNhanVien);
            return "create";
        }
        nvRepository.save(nv);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        nvRepository.deleteById(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        NhanVien nv = nvRepository.findById(id).orElse(null);
        model.addAttribute("data", nv);
        return "edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute @Valid NhanVien nv, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Đảm bảo ID được đặt để cập nhật đúng đối tượng và trả về trang sửa với lỗi xác thực
            nv.setId(id);
            return "edit";
        }
        nv.setId(id);
        nvRepository.save(nv);
        return "redirect:/nhan-vien/hien-thi";
    }

    private String generateNextMaNhanVien(String currentMaxMaNhanVien) {
        String prefix = "NV";
        int currentMax = 0;
        if (currentMaxMaNhanVien != null && !currentMaxMaNhanVien.isEmpty()) {
            currentMax = Integer.parseInt(currentMaxMaNhanVien.substring(2));
        }
        int next = currentMax + 1;
        return prefix + String.format("%03d", next);
    }
}
