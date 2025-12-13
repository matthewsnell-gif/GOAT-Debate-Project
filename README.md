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
## Milestone 1
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

## Milestone 2 Updates!
- `WordCounter` consumes **CleanedWords** directly
- `CountPlayerWords(List<String>)` returns **frequencies** aligned to the words' first appearance
- `UniqueWords` returns **only words that appear once** in an article
- `WordCountList(List<String>)` builds a **ranked frequency list** of all the words (bubble sort) and displays it in descending order

### `VocabAnalysis.Java`
- Analyzes the words in a given article and uses text files full of positive and negative words to:
- Keep track of how many positive and negative words appear in the article
- Determine whether the overall tone of the article was positive or negative

### `Main.java`
- Added a main class which allows the user to interact with the program, and choose which player and which article they would like to view

## Milestone 3 Updates!
- `WordCounter.java` & `Main.java` updated for high cohesion and low coupling
  - Made sure that `Main.java` only orchestrates, and simply calls the methods from `WordCounter.java`
  - reworked the methods inside `Wordcounter.java` to support this

## UML Class Diagram

```mermaid
classDiagram
  class main {
    +static void main(String[] args)
}

class ReadFile {
+List<String> getWords(String player,int fileIndex)
      +List<String> getWordsFromPath(String path)
    }

    class WordRemover {
      +List<String> removeStopwords(List<String> tokens, String stopwordPath)
    }

    class WordCounter {
      +int countWords(List<String>)
      +Map<String, Integer> countFrequencies(List<String>)
      +int countAppearanceOnce(Map<String, Integer>)
      +List<Map.Entry<String,Integer>> rankFrequency(Map<String, Integer>)
    }

    class VocabAnalysis {
      <<static>> String POS
      <<static>> String NEG
      +Map<String,Integer> analyzePlayerFile(List<String> cleanedWords)
    }

    main --> ReadFile : loads article words
    main --> WordRemover : removes stopwords
    main --> WordCounter : counts and ranks words
    main --> VocabAnalysis : analyzes sentiment
