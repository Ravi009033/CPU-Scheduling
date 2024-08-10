CPU Scheduling Algorithms Simulation

Overview

This Java project simulates various CPU scheduling algorithms, providing a platform to analyze and compare their performance. The implemented algorithms include:

First-ComeFirst-Served (FCFS), 
Shortest Job First (SJF), 
Priority Scheduling, 
Round Robin (RR), 
Multilevel Queue Scheduling 

Features

Performance Metrics:  Calculates and displays metrics such as waiting time, turnaround time, and CPU utilization for each scheduling algorithm.
Algorithm Comparisons:  Allows users to compare the efficiency of different scheduling policies under various scenarios.                 
Extensible Design: The project is structured to easily add new scheduling algorithms or modify existing ones.

Project Structure

MainPage.java: Entry point of the application.                  
Job.java: Class representing a process with attributes like arrival time, burst time, and priority.               
SchedulingAlgorithms/: Contains different classes for each scheduling algorithm.             
ResultPage.java : Class display the processes of Cpu Scheduling and display the waiting time, turnaround time

Sample output


MainPage 
![Screenshot 2024-08-10 223847](https://github.com/user-attachments/assets/64b8a554-768a-421e-a4a0-4957e6a71df7)



Sample running for a Round Robin scheduling simulation:
![image](https://github.com/user-attachments/assets/eaa05b74-3d3e-4c19-9b82-7605444b9e28)
