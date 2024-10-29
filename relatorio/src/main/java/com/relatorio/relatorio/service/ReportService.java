package com.relatorio.relatorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.relatorio.relatorio.model.Report;

@org.springframework.stereotype.Service
public class ReportService {

	@Autowired
    private ReportRepository reportRepository;

    public List<Report> findAll() {
        return reportRepository.findAll(); 
// Retorna todos os relatórios.
    }

    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id); 
// Busca um relatório pelo ID.
    }

    public Report save(Report report)
    { 
        return reportRepository.save(report); 
// Salva ou atualiza um relatório.
    }

    public void delete(Long id) {
        reportRepository.deleteById(id); 
// Deleta um relatório pelo ID.
    }
	
}
