package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;

import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;

    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();

        this.exploredPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);

        }
        astronautRepository.add(astronaut);

        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
//        for (Astronaut astronaut : this.astronautRepository.getModels()) {
//            if (astronaut.getName().equals(astronautName)) {
//                this.astronautRepository.remove(astronaut);
//
//            }
//        }
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if(astronaut== null){
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = this.astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if(suitableAstronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet,suitableAstronauts);
        exploredPlanets++;
        List<Astronaut> deadAstronauts = suitableAstronauts.stream().filter(a -> a.getOxygen() == 0).collect(Collectors.toList());
        return String.format(PLANET_EXPLORED,planetName,deadAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format(REPORT_PLANET_EXPLORED,exploredPlanets)).append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : this.astronautRepository.getModels() ) {
            report.append(astronaut).append(System.lineSeparator());

        }

        return report.toString().trim();
    }
}
