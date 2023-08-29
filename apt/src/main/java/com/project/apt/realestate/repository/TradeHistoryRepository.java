package com.project.apt.realestate.repository;

import com.project.apt.realestate.vo.TradeHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryRepository extends JpaRepository<TradeHistoryVO, Integer> {
}
