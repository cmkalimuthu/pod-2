package com.prototype.auditbenchmark.model;
/**
 * test class for AuditBenchmark
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class BenchmarkTest {

	private BenchMark benchmark;
	
	@Before
	public void testMethod() {
		benchmark = new BenchMark("Internal", 3);
	}
	
	@Test
	
	public void testGetSetAuditType() {
		log.info("start");
		assertEquals("Internal", benchmark.getAuditType());
		benchmark.setAuditType("SOX");
		assertEquals("SOX", benchmark.getAuditType());
		log.info("end");
		
	}
	@Test
	public void testGetSetAccNoAnswers() {
		log.info("start");
		assertEquals(3,benchmark.getNoOfnos());
		benchmark.setNoOfnos(1);
		assertEquals(1, benchmark.getNoOfnos());
		log.info("end");
	}
}
