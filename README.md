# WordLadder
A word ladder program to find the shortest distance between two words.
I modeled this problem as a graph to be able to utilize graph algorithms, BFS in this case, 
to find the shortest distance between adjacent words.
Words are adjacent if they are separated by a one letter operation(substitution, removal and insertion).
A sample dictionary of about 4200 words has been included in the files however, one would be able to use their own dictionary should
they choose to do so.
When the application is executed, the user will be required to post a path to the dictionary which should be a text file with each word on it's own line, similar to the file "dictionary.txt".
