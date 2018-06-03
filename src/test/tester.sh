#!/usr/bin/env bash

SECONDS=0

for i in `seq 1 1000`;
do
   	user="{“user_id”:”user$i”}"
	curl -X POST http://localhost:8080/user -d "$user"
done

echo "$SECONDS"