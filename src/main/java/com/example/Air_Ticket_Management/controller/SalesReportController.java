package com.example.Air_Ticket_Management.controller;

import com.example.Air_Ticket_Management.service.SalesReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/salesReport", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SalesReportController {
    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }


    @GetMapping("/getTotalSalesAmountsForToday")
    public Double getTotalSalesAmountsForToday(){
        return salesReportService.getTotalSalesAmountsForToday();
    }

    @GetMapping("/getMaxSaleDay")
    public Date getMaxSaleDay(@RequestParam Date startDate, @RequestParam Date endDate){
        return salesReportService.getMaxSaleDay(startDate, endDate);
    }

    @GetMapping("/getTop3SellingRoute")
    public List<String> getTop3SellingRoute(){
        return salesReportService.getTop3SellingRoute();
    }
}
