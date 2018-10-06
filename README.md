# Taste Wine Problem
## Wine Tasting
A large group of friends from the town of Nocillis visit the vineyards of Apan to taste wines. The vineyards produce many fine wines and the friends decide to buy as many as 3 bottles of wine each if they are available to purchase. Unfortunately, the vineyards of Apan have a peculiar restriction that they can not sell more than one bottle of the same wine. So the vineyards come up with the following scheme: They ask each person to write down a list of up to 10 wines that they enjoyed and would be happy buying. With this information, please help the vineyards maximize the number of wines that they can sell to the group of friends.

## Input
A two-column TSV file with the first column containing the ID (just a string) of a person and the second column the ID of the wine that they like. Here are three input data sets of increasing sizes. Please send us solutions even if it runs only on the first file.
##### https://s3.amazonaws.com/br-user/puzzles/person_wine_3.txt
##### https://s3.amazonaws.com/br-user/puzzles/person_wine_4.txt.zip
##### https://s3.amazonaws.com/br-user/puzzles/person_wine_5.txt.zip

## Output
Output First line contains the number of wine bottles sold in aggregate with your solution. Each subsequent line should be two columns, tab separated. The first column is an ID of a person and the second column should be the ID of the wine that they will buy.

## Approach
I have Created 2 different Classes Wine.java and Person.java to store the Wine and Person details. I have read the TSV file using BufferedReader and with the help of StringTokenizer got the person and wine name.<br />
I have used LinkedHashMap to store the Wine and Person combination. To make the Wine as unique entry hashCode() and equals() is defined in Wine.java. Also same for Person also. Used LinkedHashMap as also have to maintain the insertion order so to maintain FCFS.<br />
After getting LinkedHashMap object Writer and PrintWriter is used to store the output in corresponding directory as person_wine_3_opt.txt,person_wine_4_opt.txt, person_wine_5_opt.txt.

## Input Files Limitations
As It is not possible to use the large files in GitHub that's why need to put the file same as /home/kuldeep/IdeaProjects/Vineyards-Of-Apan/src/com/vineyardsOfApan/person_wine_3.txt is.  