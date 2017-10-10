#!/usr/bin/env bash

set -ex

mvn flyway:migrate
mvn -Ptest flyway:migrate