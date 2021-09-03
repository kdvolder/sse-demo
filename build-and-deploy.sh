#!/bin/bash
set -e

image_name=kdvolder/sse-demo:latest
./mvnw -Dspring-boot.build-image.imageName=${image_name} spring-boot:build-image
docker push $image_name
kubectl apply -f k8s
kubectl get ingress