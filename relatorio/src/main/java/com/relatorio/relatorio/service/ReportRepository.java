package com.relatorio.relatorio.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relatorio.relatorio.model.Report;


public interface ReportRepository extends JpaRepository<Report,Long> {

}
