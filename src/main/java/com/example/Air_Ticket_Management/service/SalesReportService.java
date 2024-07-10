package com.example.Air_Ticket_Management.service;

import java.sql.Date;
import java.util.List;

public interface SalesReportService {
    Double getTotalSalesAmountsForToday();
    Date getMaxSaleDay(Date startDate, Date endDate);
    List<String> getTop3SellingRoute();
}
