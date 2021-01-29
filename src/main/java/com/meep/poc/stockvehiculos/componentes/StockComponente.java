package com.meep.poc.stockvehiculos.componentes;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StockComponente {

    @Scheduled(fixedDelay = 30000)
    public void scheduleFixedDelayTask() {
        log.info("Acabo de entrar en el metodo - " + System.currentTimeMillis() / 1000);
    }

}
