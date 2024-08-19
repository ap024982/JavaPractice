#!/bin/bash

# Install Java if not already installed
if ! type java > /dev/null 2>&1; then
  echo "Installing Java..."
  sudo yum update -y
  sudo amazon-linux-extras install java-openjdk17 -y
else
  echo "Java is already installed."
fi
