#!/usr/bin/env bash

set -x

environment=${1:-"dev"}

war_dir="$PWD/target/*-1.0-SNAPSHOT"

rm -rf $war_dir/scripts

cd src/main/frontend
export PATH="$PATH:node_modules/.bin"

if [ ! -d "node_modules/aurelia-cli" ]; then
	npm install
fi

au build --env $environment

cp -r scripts $war_dir
