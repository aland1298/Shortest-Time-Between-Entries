# Shortest-Time-Between-Entries
This program reads user entries from the text file that are line separated. The program reads these entries and finds the shortest time between them and displays it.

## Dependencies


## Text File
The text fine is where the user (you) can enter in entries (order does not matter) on a new line. This is also where the program pulls its data from so any errors inputting entries will crash the program. An entry must be in the format of 00:00AP-00:00AP 12 hour time. For example, 8:35AM-12:00AM. The format of the entry is strict, meaning, you must follow the following rules to the tea:
  - Entries must not contain any spaces
  - Entries must follow 12 hour format
  - Entries must be separated by a new line
  - Entries must not contain anyother symbol other than a '-' and ':', that means no periods between AM and PM (not case sensitive)
  - Entries must contain 3 digits; two of which represent the min (:00) and at least one representing the hour(s) (00:)
  - Entries must not overlap in time periods

Any violations to the above rules will cause unforseen errors to spit at you. If you are still confused how the format either look up "12 hour format" on google or check your phone or system clock as they should by default display in standard 12 hour format. For further examples check the text file provided in this repository.

## Driver Class

## Calc Class
