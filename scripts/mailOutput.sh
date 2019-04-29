#!/bin/bash
set -e

SCRIPTPATH=`dirname $(realpath $0)`

FILE_NAME="report.html"
FILE_PATH="$SCRIPTPATH/../test-output/emailable-report.html"

TEMPLATE_PATH="$SCRIPTPATH/template.json"

EMAIL_SUBJECT="E2E Testing output"

main() {
    FILE_CONTENT=`cat $FILE_PATH | base64 -w 0`

    DATA=`sed "s/<EMAIL_SUBJECT>/$EMAIL_SUBJECT/g;s/<EMAIL_CONTENT>/$EMAIL_CONTENT/g;
        s/<FILE_CONTENT>/$FILE_CONTENT/g;s/<FILE_NAME>/$FILE_NAME/g" $TEMPLATE_PATH`

    echo sending email...

    STATUS_CODE=`curl --silent --output /dev/stderr --write-out "%{http_code}" \
                    --request POST \
                    --url https://api.sendgrid.com/v3/mail/send \
                    --header "Authorization: Bearer $SENDGRID_API_KEY" \
                    --header 'Content-Type: application/json' \
                    --data "$DATA"`

    if [[ $STATUS_CODE -ne 202 ]]; then
        echo sending email failed!
        exit 1
    fi

    echo email sent
}


if [[ -z "$SENDGRID_API_KEY" ]]; then
    echo Need SendGrid api key
    exit 1
fi

if [[ $# -eq 1 ]]; then
    EMAIL_CONTENT=${1}
else
    echo Usage: $0 content
    exit 1
fi

main