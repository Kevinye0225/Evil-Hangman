This is the readme file for EvilHangman.

EvilHangman Class:
This is the list of instance variable of EvilHangman class:
1. wordLength is an integer that used to capture the length of word users enter.
2. word is a string that reveals the current status of the game, it is initialized to contain wordLength of "_", it gets printed out every time user makes a guess.
3. dictonary is the list of words read from dictionary.txt. 
4. usedLetter contains the list of letters that has been entered by user.
5. in is a scanner variable.
6. wordCount keeps track of number of the letter is revealed.
7. guess is the number of guess available, it is initalized by user input.
8. wordFamily is a WordFamily class that makes the game evil.

Constructor takes no argument, calls the readFile method, and initialize all the instance variable based on user input, it will continue asking user for a valid word length if user enters an invalid number, then it calls updateList method.

Play method is the main method, it continues on prompting user to input a letter until user wins or user runs out of guesses. After user enter a letter, it calls generateFamily method, and shows the user current status of the game.

updateDictionary method user an iterator to iterate through the wordFamily hashmap and figure out which family contains most words. Then it uses another loop to update the word variable, and print out the word to show user current status. 

printList method prints a list of letter that has been used.


Dictionary class:
Instance variable:
1. wordSize is a hashset that contatins a list of available word length based on the dictionary. 
2. available is a list of current possible words.
3. in is a scanner that used to read file.

Constructor method:
Initializes wordSize and available, then calls readFile and updateList.

ReadFile method:
Reads the dictionary file and populate the list of words into available. 

UpdateList method:
Updates the wordSize based on available. 



WordFamily class:
Instance variable: family is a hashmap stores the available words family based on user guess.

generateFamily method takes in a String variable and a list of strings, it put the words from available list into a hashmap based on where the letter appears in those words. The key shows how the letter shows up in the word, ex: for letter b in abbbc, the key would b1b2b3, the int follows the letter is the index of the letter in a word family. Key zero contains a list of words that do not contains the letter.

readKey method interprets the key I defined at wordFamily hashmap, it translates the string into a list of index number that contains the letter so the word variable can be updated accordingly.


Choice of data structure:
ArrayList to store available word list and used letter, since dic
HashSet to store available word length since it could eliminate the duplicates.
HashMap to store word family, with key being the pattern and value being the list of words that fit into that pattern.

Extra Credit strategy:
Instead of using the longest list, the computer first checks how much larger the longest list is to the "Zero" list, if it is not significantly larger (4 times larger), it uses the "Zero" list so that the player would lose a guess and no word gets revealed, which makes it harder for the user to guess. If it is significantly larger, it then checks whether the average number of vowels in longest list is significantly larger than the "Zero" list, if so, it would use the "Zero" list. The reasoning for comparing the average number of vowels is that users tend to guess the vowel first, the less vowels in a word, the harder it is for user to guess. 




