#!/bin/sh

echo "Restarting...\n\n"
/Users/TAMIM_/Documents/j2ee/apache-tomcat-8.0.35/bin/shutdown.sh
sleep 5
/Users/TAMIM_/Documents/j2ee/apache-tomcat-8.0.35/bin/startup.sh

echo "\n\nPress any key to EXIT "
read x
killall Terminal