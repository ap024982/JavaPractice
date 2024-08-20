#!/bin/bash

# Set your function name and alias
LAMBDA_FUNCTION_NAME="TempConvertFunction"
LAMBDA_ALIAS="live"

# Log the start of the validation
echo "Starting pre-traffic validation for Lambda function: $LAMBDA_FUNCTION_NAME with alias: $LAMBDA_ALIAS"

# Check if the Lambda function exists and the alias points to a valid function version
LAMBDA_VERSION=$(aws lambda get-alias --function-name $LAMBDA_FUNCTION_NAME --name $LAMBDA_ALIAS --query 'FunctionVersion' --output text)

if [ "$LAMBDA_VERSION" == "null" ] || [ -z "$LAMBDA_VERSION" ]; then
  echo "Error: Lambda function alias $LAMBDA_ALIAS does not point to a valid function version."
  exit 1
fi

echo "Lambda function alias $LAMBDA_ALIAS is pointing to version $LAMBDA_VERSION."
