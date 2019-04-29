#!/bin/bash
set -exo pipefail

if [[ -z $1 ]]; then
    echo "Usage: $0 SERVER_URL"
    echo "i.e. $0 http://localhost:80"
    exit 1
fi

env SERVER_URL=${1} mvn test 