# Importing the tidyverse library
library(tidyverse)
library("DBI")



# Loading the database 
x <- dbConnect(RMySQL::MySQL(),dbname="selab",host="localhost",port=3306,user="root",password="password")
users <-dbReadTable(x,"basic_user_information",stringsAsFactors = FALSE)
tables <-dbListTables(x)

# Calculating the lengths of users' passwords
users$Length <- str_length(users$Password)

# Flagging the users with too short passwords
users$Too_Short <- users$Length<8

# Counting the number of users with too short passwords
sum(str_length(users$password) < 8)

# Reading in the top 10000 passwords
Common_Passwords <- read_lines("10_million_password_list_top_1000000.txt")

# Taking a look at the top 100
head(Common_Passwords,100)

# Flagging the users with passwords that are common passwords
users$Common_Password <- users$Password %in% Common_Passwords

# Reading in a list of the 10000 most common words
Words <- read_lines("google-10000-english.txt")

# Flagging the users with passwords that are common words
users$Common_Word <- users$Password %in% Words

# Flagging the users with passwords that matches their names
users$Uses_Name <- users$Password==users$FirstName|users$Password==users$LastName

#Flagging the users with passwords that matches their usernames

users$Uses_Username <- users$Password==users$Username

# Splitting the passwords into vectors of single characters
Split_Passwords <- str_split(users$Password,"")

# Picking out the max number of repeat characters for each password
users$Max_Repeats <- sapply(Split_Passwords, function(Split_Password) {
  n<-rle(Split_Password)
  return(max(n$lengths))
})

# Flagging the passwords with >= 4 repeats
users$Too_Many_Repeats <- users$Max_Repeats>=4

# Flagging all passwords that are bad
users$Bad_Password <- users$Too_Many_Repeats|users$Uses_Name|users$Uses_Username|users$Common_Word|users$Common_Password|users$Too_Short

#Copying Username and Bad_Password into another data frame users_mod
usernameMod <- users$Username
badpassMod <- users$Bad_Password
users_mod <-data.frame(usernameMod,badpassMod,stringsAsFactors = FALSE)
users_mod$badpassMod <- as.integer(users_mod$badpassMod)

#Writing the data frame as a table in MySQL
if('mytable' %in% tables){
  dbSendQuery(x,"DROP TABLE MyTable")
}
dbWriteTable(x, value = users_mod, name = "MyTable", append = TRUE )
