 package com.deeptrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deeptrain.dto.LearnerKpiDto;
import com.deeptrain.service.KpiService;

/*@RestController
@RequestMapping("/api/v1/kpi")
public class KpiController {

    private final KpiService kpiService;

    public KpiController(KpiService kpiService) {
        this.kpiService = kpiService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<LearnerKpiDto> getKpi(@PathVariable Long userId) {
        return ResponseEntity.ok(kpiService.computeKpiForUser(userId));
    }
}
 */
@RestController
@RequestMapping("/api/v1/kpi")
public class KpiController {

    @Autowired
    private KpiService kpiService;

    @GetMapping("/{userId}")
    public ResponseEntity<LearnerKpiDto> getKpi(@PathVariable Long userId) {
        LearnerKpiDto dto = kpiService.computeKpiForUser(userId);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}
