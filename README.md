# JPA Examples

The purpose of this repository is to provide examples of CRUDing JPA Relationships in Spring Boot.

### Setup

1. Clone this project
1. Add an application.properties file in the `resources` folder based off of `example.properties`
1. Run the project to build the database tables
1. Run the seeder in the `database` directory
1. Open up the RelationshipController and test out the various routes

### Structure

This project works with the following relationships:

1. one-to-one: Ad and AdDetails
1. one-to-many: Ad and Comments
1. many-to-many: Ad and Tag

It is especially helpful to look at the various entity classes to observe how the JPA relationship mapping is setup.