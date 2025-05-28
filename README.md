# Project: CPU Scheduling Algorithms Simulation
- Language/Platform: Java
- Project Type: Desktop Application (Educational/ Simulation)

# Overview:
 This Java-based simulation tool models and compares various CPU scheduling algorithms. It provides a visual and data-driven way to understand the internal workings and performance implications of different scheduling strategies used in operating systems.

# Implemented Algorithms:
- First-Come First-Served (FCFS) 
- Shortest Job First (SJF) 
- Priority Scheduling
- Round Robin (RR)
- Multilevel Queue Scheduling 

# Key Features:

- Performance Metrics Calculation:
  Automatically computes and displays key performance indicators for each algorithm:
  - Average Waiting Time
  - Turnaround Time
  - CPU Utilization
- Algorithm Comparisons:  Enables users to run simulations with various input parameters and compare the effectiveness of different algorithms under varying loads and priorities.                 
- Extensible Design: Modular architecture allows easy integration of new algorithms or enhancements to existing ones.

# Project Structure

- MainPage.java – Entry point; handles user interface and navigation.
- Job.java – Represents a process with attributes like arrival time, burst time, and priority.
- SchedulingAlgorithms/ – Package containing individual classes for each scheduling algorithm.
- ResultPage.java – Displays scheduling outcomes and visualizes performance metrics.

# Learning Outcome / Objective:
This project enhanced understanding of CPU scheduling principles and algorithm design, while reinforcing skills in:
- Java OOP and GUI programming
- Modular software architecture
- Performance analysis and simulation techniques


# Sample output


MainPage 
![Screenshot 2024-08-10 223847](https://github.com/user-attachments/assets/64b8a554-768a-421e-a4a0-4957e6a71df7)



Sample running for a Round Robin scheduling simulation:
![image](https://github.com/user-attachments/assets/eaa05b74-3d3e-4c19-9b82-7605444b9e28)
