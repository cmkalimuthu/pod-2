package com.prototype.auditseverity.feignclients;


/**
 * 
 * This feign client is used to call methods of  Audit Benchmark microservice
 */
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.prototype.auditseverity.pojo.AuditBenchmark;

@FeignClient(name="audit-benchmark",url="${audit.benchmark.url}")
public interface AuditBenchmarkFeign {
	@GetMapping("/benchmark")
	public ResponseEntity<List<AuditBenchmark>> getBenchMark(@RequestHeader("Authorization") String token);

}
