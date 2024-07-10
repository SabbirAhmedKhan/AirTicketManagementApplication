package com.example.Air_Ticket_Management.service.impl;

import com.example.Air_Ticket_Management.repository.FoodRepository;
import com.example.Air_Ticket_Management.repository.TicketRepository;
import com.example.Air_Ticket_Management.service.SalesReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesReportServiceImpl implements SalesReportService {
    private FoodRepository foodRepository;
    private TicketRepository ticketRepository;
    @Override
    public Double getTotalSalesAmountsForToday() {
        Double ticketSalesAmmount = ticketRepository.getTotalSaleToday();
        Double foodSalesAmmount = foodRepository.getTotalFoodSaleToday();
        System.out.printf(ticketSalesAmmount + "=============  " + foodSalesAmmount);

        return Math.floor(((ticketSalesAmmount+foodSalesAmmount)*100) / 100);
    }

    @Override
    public Date getMaxSaleDay(Date startDate, Date endDate) {
        return ticketRepository.getMaxSaleDayBetweenDates(startDate, endDate);
    }

    @Override
    public List<String> getTop3SellingRoute() {
        return ticketRepository.getTop3SellingRoute();
    }
}
