
# Task:
Develop a program that modifies a text file by formatting the text in a given file in the following way:
1) Align all lines of text by center (similar to how Word does it after the command Format -> Paragraph > Center Text). To format text, increase the number of whitespace characters at the beginning and end of a line. There can be one less space character at the end of a line (be sure to add spaces at the end of lines as well).
2) Delete empty lines, each line must start with a capital letter.
3) Insert a blank line between every two lines.
4) The length of the text lines in the resulting file must be selected according to the length of the longest text line.

# Requirements for the user interface:
The program must handle print, format and exit queries. Until the user enters the exit command, the program must enter commands and perform corresponding actions in an infinite loop.

Team format:

print filename

format filename

exit
