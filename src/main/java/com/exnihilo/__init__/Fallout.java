package com.exnihilo.__init__;

import com.exnihilo.domains.dtos.AssignmentDto;
import com.exnihilo.domains.dtos.MessageDto;
import com.exnihilo.domains.dtos.PersonDto;
import com.exnihilo.domains.dtos.TagDto;
import com.exnihilo.domains.dtos.TicketDto;
import com.exnihilo.services.AssignmentService;
import com.exnihilo.services.MessageService;
import com.exnihilo.services.PersonService;
import com.exnihilo.services.TagService;
import com.exnihilo.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.exnihilo.domains.enums.PersonRole.ADMIN;
import static com.exnihilo.domains.enums.PersonRole.USER;
import static com.exnihilo.domains.enums.TicketStatus.ASSIGNED;
import static com.exnihilo.domains.enums.TicketStatus.NEW;
import static com.exnihilo.domains.enums.TicketStatus.PENDING;
import static com.exnihilo.domains.enums.TicketStatus.REJECTED;
import static com.exnihilo.domains.enums.TicketStatus.RESOLVED;

/**
 * Database seeding
 */
@Component
@RequiredArgsConstructor
public class Fallout implements CommandLineRunner {

    private final TagService tagService;
    private final PersonService personService;
    private final TicketService ticketService;
    private final AssignmentService assignmentService;
    private final MessageService messageService;

    private final Random random = new Random();

    @Override
    public void run(String... args) {

        // Création de tags

        TagDto tag1 = tagService.create(new TagDto("Urgent"));
        TagDto tag2 = tagService.create(new TagDto("Problèmes matériels"));
        TagDto tag3 = tagService.create(new TagDto("Problèmes logiciels"));
        TagDto tag4 = tagService.create(new TagDto("Sécurité informatique"));
        TagDto tag5 = tagService.create(new TagDto("Assistance utilisateur"));
        TagDto tag6 = tagService.create(new TagDto("Demandes générales"));
        TagDto tag7 = tagService.create(new TagDto("Performances"));


        // Création des utilisateurs

        PersonDto person01 = personService.create(new PersonDto("Thierry", "TRAORE", "thierry.traore@exnihilo.com", ADMIN));
        PersonDto person02 = personService.create(new PersonDto("Arthur", "TRAORE", "arthur.traore@exnihilo.com", USER));
        PersonDto person03 = personService.create(new PersonDto("Emmanuel", "TRAORE", "emmanuel.traore@exnihilo.com", USER));
        PersonDto person04 = personService.create(new PersonDto("Kyle", "TRAORE", "kyle.traore@exnihilo.com", USER));
        PersonDto person05 = personService.create(new PersonDto("Alice", "DURAND", "alice.durand@exnihilo.com", ADMIN));
        PersonDto person06 = personService.create(new PersonDto("Lucas", "DUPONT", "lucas.dupont@exnihilo.com", USER));
        PersonDto person07 = personService.create(new PersonDto("Camille", "MARTIN", "camille.martin@exnihilo.com", USER));
        PersonDto person08 = personService.create(new PersonDto("Manon", "THOMAS", "manon.thomas@exnihilo.com", USER));
        PersonDto person09 = personService.create(new PersonDto("Alexandre", "ROBERT", "alexandre.robert@exnihilo.com", USER));
        PersonDto person10 = personService.create(new PersonDto("Clara", "PETIT", "clara.petit@exnihilo.com", USER));
        PersonDto person11 = personService.create(new PersonDto("Léo", "RICHARD", "leo.richard@exnihilo.com", USER));
        PersonDto person12 = personService.create(new PersonDto("Louise", "DURAND", "louise.durand@exnihilo.com", USER));
        PersonDto person13 = personService.create(new PersonDto("Hugo", "DUPONT", "hugo.dupont@exnihilo.com", USER));
        PersonDto person14 = personService.create(new PersonDto("Jade", "MARTIN", "jade.martin@exnihilo.com", USER));
        PersonDto person15 = personService.create(new PersonDto("Maxime", "THOMAS", "maxime.thomas@exnihilo.com", USER));
        PersonDto person16 = personService.create(new PersonDto("Zoé", "ROBERT", "zoe.robert@exnihilo.com", USER));
        PersonDto person17 = personService.create(new PersonDto("Théo", "PETIT", "theo.petit@exnihilo.com", USER));
        PersonDto person18 = personService.create(new PersonDto("Manon", "RICHARD", "manon.richard@exnihilo.com", USER));
        PersonDto person19 = personService.create(new PersonDto("Emma", "DURAND", "emma.durand@exnihilo.com", USER));
        PersonDto person20 = personService.create(new PersonDto("Enzo", "DUPONT", "enzo.dupont@exnihilo.com", USER));

        List<PersonDto> persons = Arrays.asList(
                person01, person02, person03, person04, person05,
                person06, person07, person08, person09, person10,
                person11, person12, person13, person14, person15,
                person16, person17, person18, person19, person20
        );


        // Création des tickets

        TicketDto ticket01 = ticketService.create(new TicketDto("Ticket 01", "Description 01 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", NEW, Arrays.asList(tag1, tag2, tag7), personService.getByEmail("emmanuel.traore@exnihilo.com").id(), personService.getByEmail("emmanuel.traore@exnihilo.com").id()));
        TicketDto ticket02 = ticketService.create(new TicketDto("Ticket 02", "Description 02 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag1, tag4, tag5), personService.getByEmail("arthur.traore@exnihilo.com").id(), personService.getByEmail("arthur.traore@exnihilo.com").id()));
        TicketDto ticket03 = ticketService.create(new TicketDto("Ticket 03", "Description 03 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag1, tag7), personService.getByEmail("kyle.traore@exnihilo.com").id(), personService.getByEmail("kyle.traore@exnihilo.com").id()));
        TicketDto ticket04 = ticketService.create(new TicketDto("Ticket 04", "Description 04 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag1, tag6), personService.getByEmail("lucas.dupont@exnihilo.com").id(), personService.getByEmail("lucas.dupont@exnihilo.com").id()));
        TicketDto ticket05 = ticketService.create(new TicketDto("Ticket 05", "Description 05 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag1, tag3), personService.getByEmail("camille.martin@exnihilo.com").id(), personService.getByEmail("camille.martin@exnihilo.com").id()));
        TicketDto ticket06 = ticketService.create(new TicketDto("Ticket 06", "Description 06 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", NEW, Arrays.asList(tag1, tag2, tag3), personService.getByEmail("alexandre.robert@exnihilo.com").id(), personService.getByEmail("alexandre.robert@exnihilo.com").id()));
        TicketDto ticket07 = ticketService.create(new TicketDto("Ticket 07", "Description 07 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag2, tag4), personService.getByEmail("clara.petit@exnihilo.com").id(), personService.getByEmail("clara.petit@exnihilo.com").id()));
        TicketDto ticket08 = ticketService.create(new TicketDto("Ticket 08", "Description 08 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag1, tag2, tag4), personService.getByEmail("leo.richard@exnihilo.com").id(), personService.getByEmail("leo.richard@exnihilo.com").id()));
        TicketDto ticket09 = ticketService.create(new TicketDto("Ticket 09", "Description 09 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag1, tag2), personService.getByEmail("louise.durand@exnihilo.com").id(), personService.getByEmail("louise.durand@exnihilo.com").id()));
        TicketDto ticket10 = ticketService.create(new TicketDto("Ticket 10", "Description 10 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", PENDING, Arrays.asList(tag1, tag2), personService.getByEmail("hugo.dupont@exnihilo.com").id(), personService.getByEmail("hugo.dupont@exnihilo.com").id()));
        TicketDto ticket11 = ticketService.create(new TicketDto("Ticket 11", "Description 11 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag1, tag2, tag3, tag6), personService.getByEmail("jade.martin@exnihilo.com").id(), personService.getByEmail("jade.martin@exnihilo.com").id()));
        TicketDto ticket12 = ticketService.create(new TicketDto("Ticket 12", "Description 12 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag3, tag7), personService.getByEmail("maxime.thomas@exnihilo.com").id(), personService.getByEmail("maxime.thomas@exnihilo.com").id()));
        TicketDto ticket13 = ticketService.create(new TicketDto("Ticket 13", "Description 13 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag1, tag2, tag5, tag6, tag7), personService.getByEmail("zoe.robert@exnihilo.com").id(), personService.getByEmail("zoe.robert@exnihilo.com").id()));
        TicketDto ticket14 = ticketService.create(new TicketDto("Ticket 14", "Description 14 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", PENDING, Arrays.asList(tag7, tag2, tag1), personService.getByEmail("theo.petit@exnihilo.com").id(), personService.getByEmail("theo.petit@exnihilo.com").id()));
        TicketDto ticket15 = ticketService.create(new TicketDto("Ticket 15", "Description 15 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", PENDING, Arrays.asList(tag5, tag2), personService.getByEmail("manon.richard@exnihilo.com").id(), personService.getByEmail("manon.richard@exnihilo.com").id()));
        TicketDto ticket16 = ticketService.create(new TicketDto("Ticket 16", "Description 16 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag4, tag3, tag6), personService.getByEmail("emma.durand@exnihilo.com").id(), personService.getByEmail("emma.durand@exnihilo.com").id()));
        TicketDto ticket17 = ticketService.create(new TicketDto("Ticket 17", "Description 17 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", ASSIGNED, Arrays.asList(tag5, tag6), personService.getByEmail("enzo.dupont@exnihilo.com").id(), personService.getByEmail("enzo.dupont@exnihilo.com").id()));
        TicketDto ticket18 = ticketService.create(new TicketDto("Ticket 18", "Description 18 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", PENDING, Arrays.asList(tag1, tag2, tag7), personService.getByEmail("thierry.traore@exnihilo.com").id(), personService.getByEmail("thierry.traore@exnihilo.com").id()));
        TicketDto ticket19 = ticketService.create(new TicketDto("Ticket 19", "Description 19 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", RESOLVED, Arrays.asList(tag3, tag4), personService.getByEmail("arthur.traore@exnihilo.com").id(), personService.getByEmail("arthur.traore@exnihilo.com").id()));
        TicketDto ticket20 = ticketService.create(new TicketDto("Ticket 20", "Description 20 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et metus ac dolor gravida tempus sit amet nec turpis. Sed imperdiet venenatis dui a venenatis.", REJECTED, Arrays.asList(tag1, tag2), personService.getByEmail("emmanuel.traore@exnihilo.com").id(), personService.getByEmail("emmanuel.traore@exnihilo.com").id()));

        List<TicketDto> tickets = Arrays.asList(
                ticket01, ticket02, ticket03, ticket04, ticket05, ticket06, ticket07, ticket08, ticket09, ticket10,
                ticket11, ticket12, ticket13, ticket14, ticket15, ticket16, ticket17, ticket18, ticket19, ticket20
        );


        // Création des affections

        List<AssignmentDto> assignments = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            int personIndex = random.nextInt(persons.size());
            int ticketIndex = random.nextInt(tickets.size());
            AssignmentDto assignment = assignmentService.create(new AssignmentDto(persons.get(personIndex).id(), tickets.get(ticketIndex).id(), "Assignment " + (i + 1)));
            assignments.add(assignment);
        });


        // Création des messages

        IntStream.range(0, 500).forEach(i ->
                messageService.create(new MessageDto(assignments.get(i % assignments.size()).id(), "Message --> " + (i + 1) + " Lorem Ipsum Dolor Sit Amet !"))
        );
    }
}
