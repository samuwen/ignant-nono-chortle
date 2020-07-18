#!/bin/bash

curl -X POST -H "Content-Type: application/json" \
 -d '{"name":"math test 2","description":"dont eat this it isnt food","ingredients":[{"name": "math paper", "amount": 1, "unit": "cup"}],"steps":[{"text": "do the paper", "ordinal": 0},{"text": "turn it in", "ordinal": 1}], "tags": [{"text": "Entree", "ordinal": 0}]}' \
 http://localhost:8080/recipes