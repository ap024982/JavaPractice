#!/bin/bash

# Stop any running instance of the application
echo "Stopping any existing Java application..."
pkill -f 'java -jar'

# Start the new Spring Boot application
echo "Starting the new Java application..."
nohup java -jar /home/ec2-user/application/TemperatureConvert.jar > /home/ec2-user/application/logs/application.log 2>&1 &

# Check if the application started successfully
if pgrep -f 'java -jar' > /dev/null; then
  echo "Application started successfully."
else
  echo "Failed to start the application."
  exit 1
fi
