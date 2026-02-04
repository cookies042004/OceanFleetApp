# OceanFleetApp

## Overview

OceanFleetApp is a simple console-based Java application that manages vessel performance records in memory.
It allows users to add vessels, search by vessel ID, and identify high-performance vessels.

This project is built using core OOPS principles such as encapsulation, modularity, and separation of concerns.

---

## Features

* Add multiple vessels using delimited input
* Retrieve vessel by ID (case-sensitive)
* Identify vessel(s) with highest average speed
* Display formatted vessel details
* Clean modular design using OOPS

---

## Input Format

User must enter vessel details in the following format:

```
vesselId:vesselName:averageSpeed:vesselType
```

Example:

```
V001:Sea King:25.5:Cargo
```

---

## Output Format

```
V001 | Sea King | Cargo | 25.5 knots
```

---

## Project Structure

* `Vessel` → Data model class
* `VesselUtil` → Business logic class
* `UserInterface` → Console interaction
* `OceanFleetApp` → Main entry point

---

## OOPS Concepts Used

* Encapsulation
* Abstraction
* Separation of Concerns
* Modularity
* Reusability

---

## How to Run

Compile:

```
javac OceanFleetApp.java
```

Run:

```
java OceanFleetApp
```

---

## Version

UC6 – Refactored Using OOPS Principles
Version 6.0

