package com.project.apt.realestate.repository;

import com.project.apt.realestate.vo.LeaseHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseHistoryRepository extends JpaRepository<LeaseHistoryVO, Integer> {
}
