#!/usr/bin/env bash

set -ex

git pull
git checkout production
git pull
git merge master
git push
git checkout master