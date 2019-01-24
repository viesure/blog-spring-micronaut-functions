#!/usr/bin/env bash
BucketName=""
while read line; do
    BucketName=${line}
done < tmp
echo "Deleting s3 bucket: $BucketName"
aws s3 rb s3://${BucketName} --force  
rm tmp

aws cloudformation delete-stack --stack-name viesure-blog-spring-micronaut-functions
echo "Successfully deleted stack"