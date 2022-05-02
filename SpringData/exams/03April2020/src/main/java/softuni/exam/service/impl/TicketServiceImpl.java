package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneRootImportDTO;
import softuni.exam.models.dto.TicketRootImportDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class TicketServiceImpl implements TicketService {
    public static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TicketRepository ticketRepository;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final XmlParser xmlParser;

    public TicketServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, TicketRepository ticketRepository, TownService townService, PassengerService passengerService, PlaneService planeService, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.ticketRepository = ticketRepository;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 1;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TicketRootImportDTO ticketRootImportDTO = xmlParser.readFromFile(TICKETS_FILE_PATH, TicketRootImportDTO.class);

        ticketRootImportDTO.getTickets()
                .forEach(ticketImportDTO -> {

                    if (!validationUtil.isValid(ticketImportDTO)) {
                        sb.append("Invalid Ticket");
                    } else {
                        Town toTown = townService.findTownByName(ticketImportDTO.getToTown().getName());
                        Town fromTown = townService.findTownByName(ticketImportDTO.getFromTown().getName());
                        Passenger passenger = passengerService.findPassengerByEmail(ticketImportDTO.getPassenger().getEmail());
                        Plane plane = planeService.findPlaneByRegisterNumber(ticketImportDTO.getPlane().getRegisterNumber());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime takeOff = LocalDateTime.parse(ticketImportDTO.getTakeOff(), formatter);

                        Ticket ticket = modelMapper.map(ticketImportDTO, Ticket.class)
                                .setFromTown(fromTown)
                                .setPassenger(passenger)
                                .setPlane(plane)
                                .setToTown(toTown)
                                .setTakeOff(takeOff);
                        this.ticketRepository.save(ticket);
                        sb.append(String.format("Successfully imported Ticket %s - %s",fromTown.getName(), toTown.getName()));
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
