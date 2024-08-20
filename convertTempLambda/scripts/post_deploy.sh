#!/bin/bash

# Set your function name and alias
LAMBDA_FUNCTION_NAME="TempConvertFunction"
LAMBDA_ALIAS="live"

# Log the start of the post-deployment tasks
echo "Starting post-deployment tasks for Lambda function: $LAMBDA_FUNCTION_NAME with alias: $LAMBDA_ALIAS"

# Get the current function version associated with the alias
LAMBDA_VERSION=$(aws lambda get-alias --function-name $LAMBDA_FUNCTION_NAME --name $LAMBDA_ALIAS --query 'FunctionVersion' --output text)

if [ "$LAMBDA_VERSION" == "null" ] || [ -z "$LAMBDA_VERSION" ]; then
  echo "Error: Unable to retrieve Lambda function version for alias $LAMBDA_ALIAS."
  exit 1
fi

echo "Lambda function alias $LAMBDA_ALIAS is now pointing to version $LAMBDA_VERSION."

# Example: Log deployment details to CloudWatch Logs or an external system
# Replace this with actual logging code or API calls as needed
echo "Deployment of Lambda function $LAMBDA_FUNCTION_NAME version $LAMBDA_VERSION completed successfully."

# Example: Send a notification (e.g., using AWS SNS, Slack, or another service)
# Uncomment and configure the following lines to send a notification
# SNS_TOPIC_ARN="arn:aws:sns:region:account-id:my-sns-topic"
# MESSAGE="Deployment of Lambda function $LAMBDA_FUNCTION_NAME version $LAMBDA_VERSION completed successfully."
# aws sns publish --topic-arn "$SNS_TOPIC_ARN" --message "$MESSAGE"
# echo "Notification sent."

# Example: Cleanup old Lambda versions (Optional)
# Retain only the last 5 versions
MAX_VERSIONS=5
echo "Cleaning up old versions of the Lambda function, retaining only the last $MAX_VERSIONS versions."
aws lambda list-versions-by-function --function-name $LAMBDA_FUNCTION_NAME --query 'Versions[*].Version' --output text | sort -n | head -n -$MAX_VERSIONS | while read -r version; do
  if [ "$version" != "\$LATEST" ]; then
    echo "Deleting Lambda function version: $version"
    aws lambda delete-function --function-name $LAMBDA_FUNCTION_NAME --qualifier $version
  fi
done

# Final log message
echo "Post-deployment tasks completed successfully."

# Exit with status 0 to indicate success
exit 0
