package com.example.Air_Ticket_Management.repository;

import com.example.Air_Ticket_Management.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select sum(t.ticketPrice) from Ticket t where t.orderDate = CURRENT_DATE")
    double getTotalSaleToday();

    @Query(value = "select t.order_date, SUM(t.ticket_price) as totalSaleAmmount FROM ticket t WHERE t.order_date BETWEEN :startDate AND :endDate GROUP BY t.order_date ORDER by totalSaleAmmount desc LIMIT 1", nativeQuery = true)
    Date getMaxSaleDayBetweenDates(Date startDate, Date endDate);

    @Query(value = """
    SELECT tt.route FROM (
        SELECT t.route, COUNT(t.route) as orderCount
        FROM ticket t
        GROUP BY t.route
        ORDER BY orderCount desc
        LIMIT 3
    ) tt
    """, nativeQuery = true)
    List<String> getTop3SellingRoute();
}
