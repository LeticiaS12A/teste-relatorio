package com.relatorio.relatorio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relatorio.relatorio.model.Report;
import com.relatorio.relatorio.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
	@Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.findAll(); 
// Retorna todos os relatórios.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Optional<Report> report = reportService.findById(id);
        return report.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); 
// Retorna o relatório ou 404 se não encontrado.
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.save(report); 
// Cria um novo relatório.
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody Report reportDetails) {
        Optional<Report> optionalReport = reportService.findById(id);
        if (!optionalReport.isPresent()) {
            return ResponseEntity.notFound().build(); 
// Retorna 404 se o relatório não existir.
        }
        Report report = optionalReport.get();
        report.setTitle(reportDetails.getTitle());
        report.setContent(reportDetails.getContent());
        return ResponseEntity.ok(reportService.save(report)); 
// Atualiza o relatório existente.
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id){ 
        reportService.delete(id); 
// Deleta o relatório.
        return ResponseEntity.noContent().build(); 
// Retorna 204 No Content.
    }
}
