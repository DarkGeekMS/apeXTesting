#!/bin/bash
set -ex

main() {
    mkdir -p driver
    
    # chrome 
    wget -q "https://chromedriver.storage.googleapis.com/74.0.3729.6/chromedriver_linux64.zip" -O $TMP_DIR/chrome.zip
    unzip -o $TMP_DIR/chrome.zip -d driver/

    # geckodriver
    wget -q "https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-linux64.tar.gz" -O $TMP_DIR/geck.tar
    tar xf $TMP_DIR/geck.tar -C driver/

    # opera 
    wget -q "https://github.com/operasoftware/operachromiumdriver/releases/download/v.2.45/operadriver_linux64.zip" -O $TMP_DIR/opera.zip
    unzip -o $TMP_DIR/opera.zip -d driver/
    cp driver/operadriver*/operadriver driver/operadriver
}

cleanup() { rm -rf $TMP_DIR; }

TMP_DIR=`mktemp -d -p .`
trap cleanup EXIT

main $@