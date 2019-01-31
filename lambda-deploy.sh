#!/usr/bin/env bash
BucketName=""

function usage()
{
    echo "Usage: "
    echo ""
    echo "./lambda-deploy.sh --bucket-name={BUCKET_NAME}"
    echo ""
}

while [[ "$1" != "" ]]; do
    PARAM=`echo $1 | awk -F= '{print $1}'`
    VALUE=`echo $1 | awk -F= '{print $2}'`
    case ${PARAM} in
        -h | --help)
            usage
            exit
            ;;
        --bucket-name)
            BucketName=$VALUE
            ;;
        *)
            echo "ERROR: unknown parameter \"$PARAM\""
            usage
            exit 1
            ;;
    esac
    shift
done

if [[ ! $BucketName ]]; then
  echo ""
  echo "ERROR: Missing bucket-name Parameter"
  usage
  exit 1
fi

# build micronaut function
cd micronaut-function
./gradlew clean build

# build spring function
cd ../spring-function
./mvnw clean package
cd ..

aws s3 mb s3://${BucketName}

# upload artifacts to s3 bucket and create sam template
aws cloudformation package \
--template-file aws/template.yml \
--output-template-file aws/serverless-output.yaml \
--s3-bucket ${BucketName}

# create cloudformation stack
aws cloudformation deploy \
--template-file aws/serverless-output.yaml \
--stack-name viesure-blog-spring-micronaut-functions \
--capabilities CAPABILITY_IAM

echo ${BucketName} > tmp