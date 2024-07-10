package com.example.Air_Ticket_Management.repository;

import com.example.Air_Ticket_Management.entity.Food;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("select COALESCE(sum(f.netPrice), 0) from Food f where f.orderDate = CURRENT_DATE")
    double getTotalFoodSaleToday();



}
