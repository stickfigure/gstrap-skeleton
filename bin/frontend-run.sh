#!/usr/bin/env bash
#
# Start the frontend proxy, which provides /dist/*
#

cd src/main/frontend
export PATH="node_modules/.bin:$PATH"

# weird, the hot reload server fails if this hasn't been done
if [ ! -d "node_modules/webpack" ]; then
	npm link webpack
fi

# for some crazy reason, the --hot is required; the config file setting doesn't work
webpack-dev-server --hot