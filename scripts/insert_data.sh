#!/bin/bash

curl -X POST -H "Content-Type: application/json" \
 -d '{"name":"math test 2","description":"dont eat this it isnt food","ingredients":[{"name": "math paper", "amount": 1, "unit": "cup"}]}' \
 http://localhost:8080/recipes