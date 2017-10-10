#!/usr/bin/env bash

set -ex

environment=${1:-"dev"}

war_dir="$PWD/target/*-1.0-SNAPSHOT"

rm -rf ${war_dir}/dist

cd src/main/frontend
export PATH="node_modules/.bin:$PATH"

if [ ! -d "node_modules/webpack" ]; then
	npm install
fi

if [ "$environment" = "prod" ]; then
	NODE_ENV='production' webpack	# can't use -p anymore, the old uglify doesn't work with es6
else
	webpack
fi

cp -r dist ${war_dir}
