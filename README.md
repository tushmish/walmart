# Walmart Ticket Booking System 

# Assumptions
1. An additional, parameter is taken to add the show time. In this case, there is 1 show per day.
2. Selecting the seats, puts them on hold. 
multiple shows / day

# Project Structure

booking
   framework
      common (jar)
      exception (jar)
   security
      TicketService (war)
      security (war)
      user (war)

booking - the overall application. 
framework - contains modules representing cross cutting concers.
common - contains reusable utility classes. Can be used in any module.
exception - handles exception as a service.
TicketService - the main application to book tickets.
security - intented for API security. Can be implemented using spring ssecurity.
user - module to store user information as a service.

# Maven - 
Modules have been created as parent/child or injected as dependecies. Please refer to the respective POM files for details.

# Tech Stack
1. Spring REST, AoP
2. Hibernate 4.x
3. Oracle 11g XE
4. Spring JUnit, Mockito
5. tools - FindBugs, PMD, Google formatter and checkstyle, SourceTree, SQL Developer and data modeler, 

# Database
load_data.sql -> load all the master data. Satic information like seats and seat levels.
data_model_booking_system.pdf - physical data model
