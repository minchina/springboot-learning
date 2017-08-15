package org.ncmao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Station;
import org.ncmao.repository.StationRepository;
import org.ncmao.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StationDataIntegrationTest {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationRepository stationRepository;

    @Test
    public void shouldFindCQByStationName(){
        Station station = stationService.findByStationName("重庆");
        assertEquals("CQ", station.getStationCode());
    }
}
