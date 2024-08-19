#!/bin/bash

# Find and kill the running Spring Boot application
echo "Stopping the Java application..."
pkill -f 'java -jar'

# Ensure the application is stopped
if pgrep -f 'java -jar' > /dev/null; then
  echo "Failed to stop the application."
  exit 1
else
  echo "Application stopped successfully."
fi
