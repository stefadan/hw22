package com.fasttrackit.payrollapplication.service;

import com.fasttrackit.payrollapplication.model.Employee;
import com.fasttrackit.payrollapplication.model.Payroll;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

@Repository
public class PayrollReader {

    public static int payrollId = 0;
    @Value("${file.monthlypayroll}")
    private String filePayrollPath;
    public List<Payroll> getPayroll() {

        try {
            return Files.lines(Path.of(filePayrollPath))
                    .map(this::lineToPayroll)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Payroll lineToPayroll(String line) {
        String[] payrollParts = line.split("\\|");
        //Long venitBrut = sum(Long.parseLong(payrollParts[2]), Long.parseLong(payrollParts[3]));
        return new Payroll(//payrollId++,
                Integer.parseInt(payrollParts[0]),
                Integer.parseInt(payrollParts[1]),
                Long.parseLong(payrollParts[2]),
                Long.parseLong(payrollParts[3]),
                Long.parseLong(payrollParts[4]),
                new Employee(payrollParts[5], payrollParts[6]),
                sum(Long.parseLong(payrollParts[2]), Long.parseLong(payrollParts[3]))
        );

    }


}
