# Walmart Ticket Booking System 

# Assumptions
1. An additional, parameter is taken to add the show time. In this case, there is 1 show per day.
2. Seats can be chosen via UI and put on hold. 
3. There can be multiple shows / day

# Project Structure

- booking
   - framework
      - common (jar)
      - exception (jar)
   - security
      - TicketService (war)
      - security (war)
      - user (war)

booking - the overall application.<br/>
framework - contains modules representing cross cutting concers.<br/>
common - contains reusable utility classes. Can be used in any module.<br/>
exception - handles exception as a service.<br/>
TicketService - the main application to book tickets.<br/>
security - intented for API security. Can be implemented using spring ssecurity.<br/>
user - module to store user information as a service.<br/>

# Maven 
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
