# GOAT Debate Project

**Course:** Programming Workshop Lab Fall 2025 

**Team Members:**  
- Matthew Snell  
- Chase Collentro
- Aidan McWilliams  


## Project Overview

This project is a Java-based program that compares and analyzes written articles about three of basketball’s greatest players: **Stephen Curry**, **LeBron James**, and **Michael Jordan**. The goal is to figure out who is worthy to hold the “Greatest of All Time” title. 

Each player’s text data is processed separately to count and analyze words from multiple articles. The program demonstrates Java fundamentals such as file handling, looping structures, and modular class design.


## Classes & Functionality

### `CurryWordCounter.java`
- **Purpose:** Reads and counts words from Steph Curry’s text files (`Curry1.txt`, `Curry2.txt`, `Curry3.txt`).  
- **Key Methods:**
  - `main(String[] args)`:  
    Opens each file using a `Scanner`, iterates through all words, and prints the total count per article.  
  - Includes error handling (`FileNotFoundException`) to ensure missing files don’t crash the program.


### `LebronWordCounter.java`
- **Purpose:** Performs the same analysis for LeBron James articles.  
- **Key Methods:**
  - `main(String[] args)`:  
    Reads from `Lebron1.txt`, `Lebron2.txt`, and `Lebron3.txt`, counting words and displaying total counts.  
  - Error handling ensures smooth execution if a file is missing or misnamed.


### `MJWordCounter.java`
- **Purpose:** Handles Michael Jordan’s articles for text processing and word counting.  
- **Key Methods:**
  - `main(String[] args)`:  
    Scans through each MJ text file, counts total words, and prints the result to the console.  


### Reader Utility Classes
These classes modularize the reading process for each player:
- **`ReadCurryFiles.java`**
- **`ReadLebronFiles.java`**
- **`ReadMJFiles.java`**

## UML Class Diagram

```mermaid
classDiagram
  direction LR

  class CurryWordCounter {
    +main(String[] args) void
    -processFile(String path) int
  }

  class LebronWordCounter {
    +main(String[] args) void
    -processFile(String path) int
  }

  class MJWordCounter {
    +main(String[] args) void
    -processFile(String path) int
  }

  class ReadCurryFiles {
    +countWords(String filePath) int
  }

  class ReadLebronFiles {
    +countWords(String filePath) int
  }

  class ReadMJFiles {
    +countWords(String filePath) int
  }

  CurryWordCounter --> ReadCurryFiles : uses
  LebronWordCounter --> ReadLebronFiles : uses
  MJWordCounter --> ReadMJFiles : uses
