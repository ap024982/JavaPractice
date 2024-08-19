#!/bin/bash

# Ensure log directory exists and has the correct permissions
if [ ! -d "/home/ec2-user/application/logs/" ]; then
  mkdir -p /home/ec2-user/application/logs/
  chown ec2-user:ec2-user /home/ec2-user/application/logs/
  chmod 755 /home/ec2-user/application/logs/
fi

# Ensure the log file has the correct permissions
touch /home/ec2-user/application/logs/application.log
chown ec2-user:ec2-user /home/ec2-user/application/logs/application.log
chmod 644 /home/ec2-user/application/logs/application.log

# Start the application and log output
nohup java -jar /home/ec2-user/application/CurrencyExchange.jar > /home/ec2-user/application/logs/application.log 2>&1 &
