#!/bin/bash

curl -X POST \
     -H 'Content-Type: application/json' \
     -d '
{
	"name": "foo",
	"nickName": "bar"
}
' \
    -L localhost:8080/automatic
