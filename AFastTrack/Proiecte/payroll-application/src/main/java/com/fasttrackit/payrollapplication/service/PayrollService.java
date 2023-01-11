package com.fasttrackit.payrollapplication.service;

import com.fasttrackit.payrollapplication.exception.ResourceNotFoundException;
import com.fasttrackit.payrollapplication.model.Payroll;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class PayrollService {

    private PayrollRepository payrollRepository;

    public PayrollService(PayrollReader payrollReader, PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
        payrollRepository.saveAll(payrollReader.getPayroll());
        System.out.println("Finished reading payroll");
    }

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getById(int id) {
        Optional<Payroll> byId = payrollRepository.findById((long) id);
        return byId.orElseThrow(() -> new ResourceNotFoundException("Payroll missing", id));
    }


}
