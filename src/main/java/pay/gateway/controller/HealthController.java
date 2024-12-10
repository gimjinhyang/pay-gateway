package pay.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/health")
public class HealthController {


  @GetMapping
  public ResponseEntity<?> doGetAsHealth() {
    log.info("Health check started");
    return ResponseEntity.ok("OK");
  }

}
