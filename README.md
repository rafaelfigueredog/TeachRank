# TeachRank

This repository contains notes, analysis, and a solution guide for the project of optimized and fair allocation of teachers to courses at IFPB. This project was proposed by the Analysis and Algorithm Techniques course, taught by Professor Ruan Delgado Gomes.

## Requirements Overview
According to the project description, we can highlight some points that should be present in the logic of the algorithm development:

- Allocate the most qualified teachers for specific subjects.
- Meet requirements for workload equalization.
- Meet requirements regarding the maximum workload limit per teacher.
- Coordinators and Directors have a different workload.
- In the allocation, we should not consider only the workload as a factor of fairness.
- Define metrics and formalize the objective function.

## Algorithm
Our teacher allocation algorithm consists of using priority queue data structures to rank the teacher based on the aforementioned parameters, so that each ranking will be performed with the state of the teacher being altered.

## Authors
- Rafael Guimarães
- Ramon Lino
