# Quarkus RESTful Bagel App

This is a project to put together all the knowledge I read from Understanding Quarkus. It was original going to be a small and simple RESTful API which only returned static data hile using an in memory List as a pseudo database. It slowly evolved into learning a few other frameworks at the same time.

Additional frameworks to learn:
- Flyway - Datbase migrations
- JOOQ - Java type safe SQL queries
- Immutables - Value objects code generation
- RESTassured - REST API test framework
- EqualsVerifier - Equals and hashCode test framework
- ArchUnit - Java architecture test framework

## Object and Appraoch

When working on this project there was one goal: "Retrieve a list of bagels and make a simple sale, like a bagel shop". The approach to get there was to do the smallest and simplest goal first. After that is was like a painting. I kept adding little functionality on top of additional functionality with little commits every day.

When I felt that it was complete, it went from a project with just a couple of APIs and POJOs to an application with several new frameworks I have not worked with and backing database model.

## Database Diagram


## Demostration

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
