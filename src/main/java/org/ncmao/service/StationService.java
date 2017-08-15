package org.ncmao.service;


import org.ncmao.domain.Station;
import org.ncmao.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Station findByStationCode(String stationCode) {
        return stationRepository.findStationByStationCode(stationCode);
    }

    public Station findByStationName(String stationName) {
        return stationRepository.findStationByStationName(stationName);
    }
}
