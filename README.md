# Spring vs. Micronaut Functions as AWS Lambda
Code Repository for the [AWS Lambda - Spring vs Micronaut Blog](https://viesure.io/awslambda/)

## Prerequisites
* AWS Account
* [aws-cli](https://aws.amazon.com/cli/)
* java 8

## How to deploy
You can use the lambda-deploy.sh script to deploy both functions using a cloudformation stack. 
You need to define a s3 bucket where the artifacts will be uploaded. 
The script creates a new bucket which can be deleted using the cleanup.sh script.

## Cleanup
You can use the cleanup script to delete the created bucket and EVERYTHING in it.
If you used an already existing bucket for the deployment script ,be careful when using the cleanup.sh as it will delete everything within the used bucket.
It will also delete the created cloudformation stack.
