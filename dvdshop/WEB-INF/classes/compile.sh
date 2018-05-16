#!/bin/sh
echo "Enter Your Project Name: "
read project
echo "Compliling Start..."
path="/Users/TAMIM_/Documents/j2ee/apache-tomcat-8.0.35/webapps/$project/WEB-INF/classes/*.java"
javac $path
if [ $? -ne 0 ]
then 
    echo "\n\nCompliling Error...\n"
else
    echo "Compliling Successful...\n"
    echo "\n\nPress any key to EXIT "
    read a
    killall Terminal
fi
