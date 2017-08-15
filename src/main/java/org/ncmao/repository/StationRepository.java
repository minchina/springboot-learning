package org.ncmao.repository;


import org.ncmao.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {


    Station findStationByStationCode(String stationCode);

    Station findStationByStationName(String stationName);
}
